import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Task {
    private String name;
    private String description;
    private Priority priority;
    private Date dueDate;
    private boolean completed;

    public Task(String name, String description, Priority priority, Date dueDate) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dueDateString = dateFormat.format(dueDate);
        return "Task: " + name + "\nDescription: " + description + "\nPriority: " + priority +
                "\nDue Date: " + dueDateString + "\nCompleted: " + completed + "\n";
    }
}

enum Priority {
    HIGH, MEDIUM, LOW
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void markTaskAsCompleted(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.setCompleted(true);
            System.out.println("Task marked as completed: " + task.getName());
        } else {
            System.out.println("Invalid task index.");
        }
    }
}

public class TimeScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("Task Scheduler");
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter task priority (HIGH, MEDIUM, LOW): ");
                    Priority priority = Priority.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Enter task due date (yyyy-MM-dd HH:mm:ss): ");
                    String dueDateString = scanner.nextLine();

               //     try {
                 //       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                   //     Date dueDate = dateFormat.parse(dueDateString);
//
  //                      Task task = new Task(name, description, priority, dueDate);
    //                    taskManager.addTask(task);
      //                  System.out.println("Task added successfully.");
        //            } catch (ParseException e) {
          //              System.out.println("Invalid date format. Please use yyyy-MM-dd HH:mm:ss.");
            //        }
            try {
                int userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            
                switch (userChoice) {
                    // ... rest of the switch block
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
            
                    break;

                case 2:
                    System.out.println("Tasks:");
                    taskManager.displayTasks();
                    break;

                case 3:
                    System.out.print("Enter the index of the task to mark as completed: ");
                    int taskIndex = scanner.nextInt();
                    taskManager.markTaskAsCompleted(taskIndex);
                    break;

                case 4:
                    System.out.println("Exiting the Task Scheduler. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}