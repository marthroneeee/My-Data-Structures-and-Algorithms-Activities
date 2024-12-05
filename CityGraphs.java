import java.util.*;

public class CityGraphs {
    private Map<String, List<String>> roadMap;

    //Constructor to initialize the road map
    public CityGraphs() {
        roadMap = new HashMap<>();
    }

    //Adds a city (node) to the graph
    public void addCity(String city) {
        roadMap.putIfAbsent(city, new ArrayList<>());
        System.out.println("City " + city + " added.");
    }

    //Adds (edge) between two cities
    public void addRoad(String city1, String city2) {
        if (roadMap.containsKey(city1) && roadMap.containsKey(city2)) {
            roadMap.get(city1).add(city2);
            roadMap.get(city2).add(city1);
            System.out.println("Road added between " + city1 + " and " + city2 + ".");
        } else {
            System.out.println("Both cities must exist to add a road.");
        }
    }

    //Displays the entire city road network
    public void displayNetwork() {
        System.out.println("\nCity Road Network:");
        for (String city : roadMap.keySet()) {
            System.out.println(city + " -> " + roadMap.get(city));
        }
    }

    //Main method
    public static void main(String[] args) {
        CityGraphs network = new CityGraphs();
        Scanner sc = new Scanner(System.in);
        int choice;

        //Menu
        do {
            System.out.println("\n--- City Network Menu ---");
            System.out.println("1. Add City");
            System.out.println("2. Add Road");
            System.out.println("3. Display Network");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter city name: ");
                    String city = sc.nextLine();

                    network.addCity(city);
                    break;
                case 2:
                    System.out.print("Enter first city: ");
                    String city1 = sc.nextLine();

                    System.out.print("Enter second city: ");
                    String city2 = sc.nextLine();

                    network.addRoad(city1, city2);
                    break;
                case 3:
                    network.displayNetwork();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
