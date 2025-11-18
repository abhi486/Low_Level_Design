public class AlertSubscriber implements Subscriber {
    private String id;

    public AlertSubscriber(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Alert Subscriber " + id + " received alert: " + message.getContent());
    }
}
