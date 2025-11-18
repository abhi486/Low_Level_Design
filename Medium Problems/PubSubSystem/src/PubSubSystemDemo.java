public class PubSubSystemDemo {
    public static void main(String[] args) {
        PubSubSystem pubSubSystem = PubSubSystem.getInstance();

        pubSubSystem.createTopic("NEWS");
        pubSubSystem.createTopic("ALERTS");

        Subscriber newsSubscriber1 = new NewsSubscriber("NewsSub1");
        Subscriber newsSubscriber2 = new NewsSubscriber("NewsSub2");
        Subscriber alertSubscriber1 = new AlertSubscriber("AlertSub1");

        pubSubSystem.subscribe("NEWS", newsSubscriber1);
        pubSubSystem.subscribe("NEWS", newsSubscriber2);
        pubSubSystem.subscribe("ALERTS", alertSubscriber1);

        Message newsMessage = new Message("Breaking News: New Java Version Released!");
        Message alertMessage = new Message("Alert: Severe Weather Warning!");

        pubSubSystem.publish("NEWS", newsMessage);
        pubSubSystem.publish("ALERTS", alertMessage);
    }
}
