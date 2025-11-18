import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;

class Topic {
    private String title;
    private Set<Subscriber> subscribers;
    private ExecutorService executor;

    Topic(String title, ExecutorService executor) {
        this.title = title;
        this.executor = executor;
        this.subscribers = new CopyOnWriteArraySet<>();
    }

    public String getTitle() {
        return title;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void broadcast(Message message) {
        for (Subscriber subscriber : subscribers) {
            executor.submit(() -> {
                try {
                    subscriber.onMessage(message);
                }
                catch (Exception e) {
                    System.err.println("Error delivering message to subscriber " + subscriber.getId() + ": " + e.getMessage());
                }
            });
        }
    }
}
