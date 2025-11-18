import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PubSubSystem {
    Map<String, Topic> topics;
    private static PubSubSystem instance;
    private ExecutorService deliveryExecutor;
    private PubSubSystem() {
        topics = new java.util.concurrent.ConcurrentHashMap<>();
        deliveryExecutor = Executors.newCachedThreadPool();
    }

    public static synchronized PubSubSystem getInstance() {
        if (instance == null) {
            instance = new PubSubSystem();
        }
        return instance;
    }

    void createTopic(String title) {
        topics.putIfAbsent(title, new Topic(title, deliveryExecutor));
    }

    void subscribe(String topicTitle, Subscriber subscriber) {
        if (!topics.containsKey(topicTitle)) {
            System.out.println("Topic " + topicTitle + " does not exist.");
            return;
        }
        topics.get(topicTitle).addSubscriber(subscriber);
        System.out.println("Subscriber " + subscriber.getId() + " subscribed to topic " + topicTitle);
    }

    void unsubscribe(String topicTitle, Subscriber subscriber) {
        if (!topics.containsKey(topicTitle)) {
            System.out.println("Topic " + topicTitle + " does not exist.");
            return;
        }
        topics.get(topicTitle).removeSubscriber(subscriber);
        System.out.println("Subscriber " + subscriber.getId() + " unsubscribed from topic " + topicTitle);
    }

    void publish(String topicTitle, Message message) {
        if (!topics.containsKey(topicTitle)) {
            System.out.println("Topic " + topicTitle + " does not exist.");
            return;
        }
        topics.get(topicTitle).broadcast(message);
        System.out.println("Published message to topic " + topicTitle + ": " + message.getContent());
    }

    void shutdown() {
        System.out.println("Shutting down PubSub System...");
        deliveryExecutor.shutdown();
        try {
            if (!deliveryExecutor.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS)) {
                deliveryExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            deliveryExecutor.shutdownNow();
        }
        System.out.println("PubSub System shut down...");
    }
}
