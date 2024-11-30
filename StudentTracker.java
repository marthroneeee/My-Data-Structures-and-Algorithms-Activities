import java.util.HashMap;
import java.util.Scanner;

public class StudentTracker {
    //Menu
    public static void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Add Student");
        System.out.println("2. Retrieve Student by ID");
        System.out.println("3. Display All Students");
        System.out.println("4. Exit");
    }

    //Method to add a student (name and id)
    public static void addStudent(HashMap<Integer, String> studentTable) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentTable.containsKey(id)) {
            System.out.println("A student with this ID already exists: " + studentTable.get(id));
        } else {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            studentTable.put(id, name);
            System.out.println("Student added successfully!");
        }
    }

    //Method to get a student by ID
    public static void retrieveStudent(HashMap<Integer, String> studentTable) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to search: ");
        int searchId = sc.nextInt();
        if (studentTable.containsKey(searchId)) {
            System.out.println("Student Name: " + studentTable.get(searchId));
        } else {
            System.out.println("Student not found!");
        }
    }

    //Method to display all students
    public static void displayAllStudents(HashMap<Integer, String> studentTable) {
        if (studentTable.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All Students:");
            for (var entry : studentTable.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        HashMap<Integer, String> studentTable = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent(studentTable);
                    break;

                case 2:
                    retrieveStudent(studentTable);
                    break;

                case 3:
                    displayAllStudents(studentTable);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
