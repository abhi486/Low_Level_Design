import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Task {
    private int id;
    private String title;
    private User assignedTo;
    private User createdBy;
    private Priority priority;
    private TaskState state;
    private List<Comment> comments;
    private LocalDate dueDate;

    public Task(int id, String title, User assignedTo, User createdBy, Priority priority, TaskState state, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.assignedTo = assignedTo;
        this.createdBy = createdBy;
        this.priority = priority;
        this.state = state;
        this.comments = new ArrayList<>();
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Priority getPriority() {
        return priority;
    }

    public TaskState getState() {
        return state;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    // Synchronized to handle concurrent additions of comments
    public synchronized void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + "\n Title: " + title + "\n Assigned To: " + assignedTo.getName() +
               "\n Created By: " + createdBy.getName() + "\n Priority: " + priority +
               "\n State: " + state + "\n Due Date: " + dueDate + "\n Comments Count: " + comments.size();
    }
}
