import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Answer implements Commentable, Votable{
    private final int id;
    private final Date creationDate;
    private final User author;
    private final String content;
    private final Question question;
    private boolean isAccepted;
    private List<Comment> comments;
    private List<Vote> votes;

    public Answer(User author, String content, Question question) {
        id = Helpers.generateId();
        creationDate = new Date();
        this.author = author;
        this.content = content;
        this.question = question;
        isAccepted = false;
        votes = new ArrayList<>();
        comments = new ArrayList<>();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void vote(Vote vote) {
        if (vote.getValue() != -1 && vote.getValue() != 1) {
            throw new IllegalArgumentException("Vote value should be -1 or 1");
        }

        votes.removeIf(v -> v.getUser().equals(vote.getUser()));
        votes.add(vote);
    }

    @Override
    public int getVotes() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    public void markAsAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("Already marked as accpeted");
        }
        isAccepted = true;
    }


    int getId() { return id; }
    User getAuthor() { return author; }
    String getContent() { return content; }
    Question getQuestion() { return question; }
    boolean isAccepted() { return isAccepted; }
    Date getCreationDate() { return creationDate; }
}
