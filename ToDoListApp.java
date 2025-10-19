// Importing required classes from Java library
import java.util.ArrayList;   // For using dynamic list to store tasks
import java.util.Scanner;     // For taking user input from console
// Main class for the To-Do List application
public class ToDoListApp {
    // Creating a static ArrayList to store all the tasks
    private static ArrayList<String> tasks = new ArrayList<>();
    // ------------------- METHOD TO ADD A TASK -------------------
    // This method takes a task as input and adds it to the list
    public static void addTask(String task) {
        tasks.add(task);  // Add the task to the ArrayList
        System.out.println("Task added successfully!");  // Confirmation message
    }
    // ------------------- METHOD TO DELETE A TASK -------------------
    // This method removes a task from the list using its index
    public static void deleteTask(int index) {
        // Check if the index entered is valid (within range)
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);  // Remove the task from the list
            System.out.println("Task deleted successfully!");  // Confirmation message
        } else {
            System.out.println("Invalid task number!");  // Error message if invalid
        }
    }
    // ------------------- METHOD TO DISPLAY TASKS -------------------
    // This method displays all the tasks currently in the list
    public static void displayTasks() {
        // If list is empty, show message
        if (tasks.isEmpty()) {
            System.out.println("No tasks available!");
        } else {
            System.out.println("\n--- To-Do List ---");  // Header for task list
            // Loop through all tasks and display them with numbers
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));  // Print task number and name
            }
        }
    }
    // ------------------- METHOD TO MARK TASK AS COMPLETE -------------------
    // This method marks a task as completed by updating its text
    public static void markTaskComplete(int index) {
        // Check if index is valid
        if (index >= 0 && index < tasks.size()) {
            String task = tasks.get(index) + " (Completed)";  // Add “(Completed)” to task
            tasks.set(index, task);  // Update the task in the list
            System.out.println("Task marked as complete!");  // Confirmation message
        } else {
            System.out.println("Invalid task number!");  // Error message
        }
    }
    // ------------------- MAIN METHOD -------------------
    // Main method: runs when program starts
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create Scanner object for user input
        int choice;  // Variable to store user's menu choice
        // Loop the menu until user chooses to exit
        do {
            // Displaying menu options
            System.out.println("\n===== TO-DO LIST MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();  // Read user choice
            sc.nextLine();  // Consume leftover newline character
            // Perform actions based on user's choice
            switch (choice) {
                case 1:
                    // Option 1: Add a new task
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();  // Read task from user
                    addTask(task);  // Call method to add task
                    break;
                case 2:
                    // Option 2: Delete an existing task
                    displayTasks();  // Show current tasks
                    System.out.print("Enter task number to delete: ");
                    int delIndex = sc.nextInt() - 1;  // Convert user number to index
                    deleteTask(delIndex);  // Call delete method
                    break;
                case 3:
                    // Option 3: Display all tasks
                    displayTasks();
                    break;
                case 4:
                    // Option 4: Mark a task as completed
                    displayTasks();  // Show current tasks
                    System.out.print("Enter task number to mark complete: ");
                    int compIndex = sc.nextInt() - 1;  // Convert to index
                    markTaskComplete(compIndex);  // Call method to mark complete
                    break;
                case 5:
                    // Option 5: Exit the program
                    System.out.println("Exiting... Have a productive day!");
                    break;
                default:
                    // If user enters invalid choice
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);  // Repeat until user chooses Exit
        sc.close();  // Close the Scanner to free resources
    }
}
