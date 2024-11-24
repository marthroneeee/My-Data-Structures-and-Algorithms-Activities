import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class RankingSystem {

    //Max-heap for storing students name and score
    private static PriorityQueue<Student> maxHeap = new PriorityQueue<>(new Comparator<Student>() {

        @Override
        public int compare(Student s1, Student s2) {
            return s2.score - s1.score;
        }
    });

        //Method to add students name and score
	    private static void addStudent(Scanner sc) {
			System.out.println();
	        System.out.print("Enter student's name: ");
	        String name = sc.next();

	        System.out.print("Enter " + name + "'s score: ");
	        int score = sc.nextInt();

	        maxHeap.add(new Student(name, score));
	        System.out.println("Student added successfully!");
	    }

	    //Method to view the rankings
	    private static void viewRanking() {
	        if (maxHeap.isEmpty()) {
	            System.out.println("No students to display. Add students first!");
	            return;
	        }

	        System.out.println("\nStudent Rankings (Highest to Lowest):");
	        int rank = 1;

	        //heap to preserve original data
	        PriorityQueue<Student> tempHeap = new PriorityQueue<>(maxHeap);
	        while (!tempHeap.isEmpty()) {
	            Student topStudent = tempHeap.poll();
	            System.out.println(rank + ". " + topStudent.name + " - " + topStudent.score);
	            rank++;
	        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Display the menu
            System.out.println("\nMenu:");
            System.out.println("1. Add Student and Score");
            System.out.println("2. View Ranking");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewRanking();
                    break;
                case 3:
                    System.out.println("Exiting the program......");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        while (choice != 3);

        sc.close();
    }
}
