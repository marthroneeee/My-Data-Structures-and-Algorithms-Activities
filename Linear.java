import java.util.Scanner;
import java.util.Arrays;

public class Linear{
public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
		//enter ka sa size sa imong array
        System.out.print("Enter Size of the array: ");
        int num = sc.nextInt();

        int arr[] = new int[num];
		//mo loop para maka enter ka sa element
        for (int a = 0; a < num; a++){
            System.out.print("Enter element: ");
            arr[a] = sc.nextInt();
        }
		// enter ka sa value na gusto nimo isearch
		// mo print sa value na imong gusto
        System.out.print("Enter value to search : ");
		int target = sc.nextInt();
		int linearResult = linearSearch(arr, target);
        System.out.println("Linear Search result: " + (linearResult != -1 ? "Found at index " + linearResult : "Not found"));
	}
// method para makuha makuha ang linear search
//una kay kuhaon kung unsa imong isearch
//dayon if pareha iprint niya nya if dili kay mo padayon ra siyag check hantud makit-an
public static int linearSearch(int[] array, int target) {
	for (int i = 0; i < array.length; i++) {
		if (array[i] == target) {
		return i;
			}
		}
		return -1;
    }
}


