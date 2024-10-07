import java.util.Scanner;
import java.util.Arrays;

public class Binary{
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
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.print("Enter value to search: ");
        int target = sc.nextInt();
        int binaryResult = binarySearch(arr, target, 0, arr.length - 1);
        System.out.println("Binary Search result: " + (binaryResult != -1 ? "Found at index " + binaryResult : "Not found"));

	}
//method ni siya sa binary search
//una kay kuhaon gihapon niya imong gusto isearch
//dayon tungaon niya ang array kay anam-anamon og check if wala sa first half mo padayon siya check sa second half
//if target is mas dako adto siya sa right mo check if mas gamay adto siya sa left mo check
public static int binarySearch(int arr[], int target, int low, int high) {
	if (low <= high) {
		int mid = low + (high - low) / 2;

		if (arr[mid] == target) {
		return mid;
		}

	if (arr[mid] > target) {
		return binarySearch(arr, target, low, mid - 1);
		}

        return binarySearch(arr, target, mid + 1, high);
        }
        return -1;
    }

}

