import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class User {
    private final int id;
    private final Date creationDate;
    private final String username;
    private final String email;
    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;

    public User(int id, String username, String email) {
        this.id = id;
        creationDate = new Date();
        this.username = username;
        this.email = email;
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String content, List<String> tags) {
        Question question = new Question(this, title, content, tags);
        questions.add(question);
        return question;
    }

    public Answer giveAnswer(String content, Question question) {
        Answer answer = new Answer(this, content, question);
        answers.add(answer);
        return answer;
    }

    public Comment giveComment(Commentable commentable, String content) {
        Comment comment = new Comment(this, content);
        comments.add(comment);
        commentable.addComment(comment);
        return comment;
    }

    public int getId() { return id; }
    public Date getCreationDate() { return creationDate; }
    public String getUsername() { return username; }
    public List<Question> getQuestions() { return new ArrayList<>(questions); }
    public List<Answer> getAnswers() { return new ArrayList<>(answers); }
    public List<Comment> getComments() { return new ArrayList<>(comments); }
}
