import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    String name;
    String type;
    String idNumber;
    List<TreeNode> children;

    // Constructor for both Year/Section and Student nodes
    public TreeNode(String name, String type, String idNumber) {
        this.name = name;
        this.type = type;
        this.idNumber = (idNumber != null) ? idNumber : "";
        this.children = new ArrayList<>();
    }

    // Method to add a child node
    public void addChild(TreeNode child) {
        children.add(child);
    }

    // Method to display people present by year level
    public void displayPeoplePresent(String space) {
        if (this.type.equals("Student")) {
            System.out.println(space + "- " + name + " (ID: " + idNumber + ")");
        } else {
            System.out.println(space + name);
        }

        // Recursively display children (students or sections)
        for (TreeNode child : children) {
            child.displayPeoplePresent(space + "  ");
        }
    }
}

public class StudentAttendanceSystem {
    static Scanner sc = new Scanner(System.in);

    // Method to add sections to a given year level
    public static void addSections(TreeNode yearNode) {
        yearNode.addChild(new TreeNode("Section A", "Section", null));
        yearNode.addChild(new TreeNode("Section B", "Section", null));
        yearNode.addChild(new TreeNode("Section C", "Section", null));
        yearNode.addChild(new TreeNode("Section D", "Section", null));
        yearNode.addChild(new TreeNode("Section E", "Section", null));
    }

    // Method to add a student under a specific section
    public static void addStudent(TreeNode section) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your ID number: ");
        String idNumber = sc.nextLine();

        // Create a new student node and add it to the section
        TreeNode student = new TreeNode(name, "Student", idNumber);
        section.addChild(student);

        System.out.println("Student added successfully!\n");
    }

    // Method to handle navigation through years and sections to add students
    public static void navigateAndAdd(TreeNode root) {
        int yearChoice;
        int sectionChoice;

        System.out.println("YEAR AND SECTION:");
        // Display year levels
        for (int a = 0; a < root.children.size(); a++) {
            System.out.println((a + 1) + ". " + root.children.get(a).name);
        }
        System.out.print("Select a Year Level (1-4): ");
        yearChoice = sc.nextInt();
        sc.nextLine();

        if (yearChoice >= 1 && yearChoice <= 4) {
            // Get the corresponding Year Level
            TreeNode selectedYear = root.children.get(yearChoice - 1);

            // Display sections under the selected year level
            System.out.println("Choose a Section:");
            for (int a = 0; a < selectedYear.children.size(); a++) {
                System.out.println((a + 1) + ". " + selectedYear.children.get(a).name);
            }
            System.out.print("Select a Section (1-4): ");
            sectionChoice = sc.nextInt();
            sc.nextLine();

            if (sectionChoice >= 1 && sectionChoice <= 4) {
                // Get the corresponding Section
                TreeNode selectedSection = selectedYear.children.get(sectionChoice - 1);
                // Add student details
                addStudent(selectedSection);
            } else {
                System.out.println("Invalid section choice. Please try again.");
            }
        } else {
            System.out.println("Invalid year choice. Please try again.");
        }
    }

    // Method to initialize the tree with Year Levels and Sections
    public static TreeNode initializeTree() {
        TreeNode root = new TreeNode("YEAR AND SECTION", "Root", null);

        // Create Year Levels
        TreeNode firstYear = new TreeNode("1st Year", "Year", null);
        TreeNode secondYear = new TreeNode("2nd Year", "Year", null);
        TreeNode thirdYear = new TreeNode("3rd Year", "Year", null);
        TreeNode fourthYear = new TreeNode("4th Year", "Year", null);

        // Add Year Levels to root
        root.addChild(firstYear);
        root.addChild(secondYear);
        root.addChild(thirdYear);
        root.addChild(fourthYear);

        // Add Sections (A, B, C, D) to each Year Level
        addSections(firstYear);
        addSections(secondYear);
        addSections(thirdYear);
        addSections(fourthYear);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = initializeTree();
        int mainChoice;

        do {
            System.out.println("\n-BACHELOR OF SCIENCE IN INFORMATION TECHNOLOGY(BSIT) STUDENT ATTENDANCE SYSTEM-");
            System.out.println("\nMain Menu:");
            System.out.println("1. YEAR AND SECTION");
            System.out.println("2. PEOPLE PRESENT BY YEAR LEVEL");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            mainChoice = Integer.parseInt(sc.nextLine());

            switch (mainChoice) {
                case 1:
                    navigateAndAdd(root);
                    break;
                case 2:
                    System.out.println("\nPeople Present by Year Level:");
                    root.displayPeoplePresent("");
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (mainChoice != 3);

        sc.close();
    }
}
