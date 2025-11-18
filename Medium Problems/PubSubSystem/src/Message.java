import java.time.Instant;

class Message {
    private String content;
    private Instant timestamp;

    Message(String content) {
        this.content = content;
        this.timestamp = Instant.now();
    }

    public String getContent() {
        return content;
    }
}
