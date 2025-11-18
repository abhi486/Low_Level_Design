public class NewsSubscriber implements Subscriber {
    private String id;
    public NewsSubscriber(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Subscriber " + id + " received message: " + message.getContent());
    }
}
