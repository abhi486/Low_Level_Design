import java.util.Date;

class Comment {
    private final int id;
    private final User author;
    private final String content;
    private final Date creationDate;

    public Comment(User author, String content) {
        id = Helpers.generateId();
        this.author = author;
        this.content = content;
        creationDate = new Date();
    }

    int getId() { return id; }
    User getAuthor() { return author; }
    String getContent() { return content; }
    Date getCreationDate() { return creationDate; }
}
