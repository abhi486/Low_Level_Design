import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

class StackOverFlow {
    private Map<Integer, Question> questionMap;
    private Map<Integer, Answer> answerMap;
    private Map<Integer, User> userMap;
    private Map<String, Tag> tagMap;

    public StackOverFlow() {
        questionMap = new ConcurrentHashMap<>();
        answerMap = new ConcurrentHashMap<>();
        userMap = new ConcurrentHashMap<>();
        tagMap = new ConcurrentHashMap<>();
    }

    public User createUser(String username, String email) {
        int id = userMap.size() + 1;
        User user = new User(id, username, email);
        userMap.putIfAbsent(user.getId(), user);
        return user;
    }

    public Question askQuestion(User user, String title, String content, List<String> tags) {
        Question question = user.askQuestion(title, content, tags);
        questionMap.putIfAbsent(question.getId(), question);
        for (Tag tag : question.getTags()) {
            tagMap.putIfAbsent(tag.getTag(), tag);
        }
        return question;
    }

    public Answer answerQuestion(User user, Question question, String content) {
        Answer answer = user.giveAnswer(content, question);
        answerMap.putIfAbsent(answer.getId(), answer);
        return answer;
    }

    public Comment giveComment(User user, Commentable commentable, String content) {
        return user.giveComment(commentable, content);
    }

    public void voteQuestion(User user, int value, Question question) {
        question.vote(new Vote(user, value));
    }

    public void voteAnswer(User user, int value, Answer answer) {
        answer.vote(new Vote(user, value));
    }

    public List<Question> searchQuestion(String query) {
        return questionMap.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(query) ||
                        q.getContent().toLowerCase().contains(query) ||
                        q.getTags().stream().anyMatch(t -> t.getTag().toLowerCase().contains(query)))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestionsByUser(User user) {
        return user.getQuestions();
    }

    public User getUser(int id) { return userMap.get(id); }
    public Question getQuestion(int id) { return questionMap.get(id); }
    public Answer getAnswer(int id) { return answerMap.get(id); }
    public Tag getTag(String name) { return tagMap.get(name); }
}
