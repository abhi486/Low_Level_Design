public interface Subscriber {
    String getId();
    void onMessage(Message message);
}
