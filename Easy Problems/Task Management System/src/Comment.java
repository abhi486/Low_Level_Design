import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

class Comment {
    private int id;
    private String content;
    private User author;
    private LocalDate timestamp;
    private LocalDate LastEdited;

    public Comment(int id, String content, User author, LocalDate timestamp) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.timestamp = timestamp;
        this.LastEdited = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setContentAndAuthor(String content, User author) {
        this.content = content;
        this.author = author;
        this.LastEdited = LocalDate.now();
    }
}
