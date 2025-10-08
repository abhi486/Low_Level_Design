import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TaskManager {
    private List<Task> tasks;
    private List<User> users;
    private static TaskManager instance;

    private TaskManager () {
        this.tasks = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public static synchronized TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task.getTitle());
    }

    public void displayByPriority() {
        tasks.sort(Comparator.comparing(Task::getPriority));
        printTasks();
    }

    public void displayByState() {
        tasks.sort(Comparator.comparing(Task::getState));
        printTasks();
    }

    public void displayByDueDate() {
        tasks.sort(Comparator.comparing(Task::getDueDate));
        printTasks();
    }

    public void resetOrder() {
        tasks.sort(Comparator.comparing(Task::getId));
        printTasks();
    }

    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public List<Task> searchTaskByTitle(String title) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Task> searchTaskByUser(User user) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getAssignedTo().equals(user) || task.getCreatedBy().equals(user)) {
                result.add(task);
            }
        }
        return result;
    }

    public List<Task> searchTaskById(int id) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getId() == id) {
                result.add(task);
            }
        }
        return result;
    }
}
