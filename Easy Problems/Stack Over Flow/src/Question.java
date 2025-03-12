import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Question implements Commentable, Votable{
    private final int id;
    private final Date creationDate;
    private final User author;
    private final String title;
    private final String content;
    private List<Comment> comments;
    private List<Tag> tags;
    private List<Answer> answers;
    private List<Vote> votes;

    public Question(User author, String title, String content, List<String> tagNames) {
        id = Helpers.generateId();
        creationDate = new Date();
        this.author = author;
        this.title = title;
        this.content = content;
        tags = new ArrayList<>();
        comments = new ArrayList<>();

        for (String tag : tagNames) {
            tags.add(new Tag(tag));
        }
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
            throw new IllegalArgumentException("Vote value should be 1 or -1");
        }

        votes.removeIf(v -> v.getUser().equals(vote.getUser()));
        votes.add(vote);
    }

    @Override
    public int getVotes() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    void addAnswer(Answer answer) {
        if (!answer.isAccepted()) {
            throw new IllegalArgumentException("Answer should be accepted");
        }

        if (!answers.contains(answer)) {
            answers.add(answer);
        }
        else {
            System.out.println("Answer already added");
        }
    }

    int getId() { return id; }
    Date getCreationDate() { return creationDate; }
    User getAuthor() { return author; }
    String getTitle() { return title; }
    String getContent() { return content; }
    List<Tag> getTags() { return new ArrayList<>(tags) ; }
    List<Answer> getAnswers() { return new ArrayList<>(answers); }
}
