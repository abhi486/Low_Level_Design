import java.time.LocalDate;

public class TaskManagementDemo {
    public static void main(String[] args) {
        // Create users
        User alice = new User(1, "Alice", "alice.@example.com");
        User bob = new User(2, "Bob", "bob.@example.com");
        User charlie = new User(3, "Charlie", "charlie.@example.com");

        // Create TaskManager instance
        TaskManager taskManager = TaskManager.getInstance();
        taskManager.addUser(alice);
        taskManager.addUser(bob);
        taskManager.addUser(charlie);

        // Create tasks
        Task loginFeature = new Task(
                1,
                "Implement Login Feature",
                alice,
                bob,
                Priority.High,
                TaskState.ToDo,
                LocalDate.now().plusDays(2));

        Task paymentIntegration = new Task(
                2,
                "Payment Gateway Integration",
                charlie,
                bob,
                Priority.Medium,
                TaskState.InProgress,
                LocalDate.now().plusDays(5));

        taskManager.addTask(loginFeature);
        taskManager.addTask(paymentIntegration);

        // Add comments to a task
        Comment comment1 = new Comment(1, "Initial setup done.", alice, LocalDate.now());
        Comment comment2 = new Comment(2, "Working on UI.", charlie, LocalDate.now());
        loginFeature.getComments().add(comment1);
        loginFeature.getComments().add(comment2);


        // Display tasks by priority
        System.out.println("Tasks sorted by Priority:");
        taskManager.displayByPriority();

        // Display tasks by state
        System.out.println("\nTasks sorted by State:");
        taskManager.displayByState();

        // Display tasks by due date
        System.out.println("\nTasks sorted by Due Date:");
        taskManager.displayByDueDate();

        // Reset to original order
        System.out.println("\nTasks in original order:");
        taskManager.resetOrder();

        // Search tasks by title
        System.out.println("\nSearch results for 'Login':");
        for (Task task : taskManager.searchTaskByTitle("Login")) {
            System.out.println(task);
        }

        // Update task state
        loginFeature.setState(TaskState.InProgress);
        System.out.println("\nUpdated Task State:");
        System.out.println(loginFeature);

        // Update due date
        paymentIntegration.setDueDate(LocalDate.now().plusDays(7));
        System.out.println("\nUpdated Task Due Date:");
        System.out.println(paymentIntegration);
    }
}
