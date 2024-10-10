import java.util.Scanner;
import java.util.Arrays;

public class quick{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
			 //enter ka sa size sa imong array
		     System.out.print("Enter Size of the array: ");
		     int num = sc.nextInt();
			 //mo store sa element nga i-enter ni user
		     int arr[] = new int[num];
			 //mo loop para maka enter ka sa element
		     for (int a = 0; a < num; a++){
		     	System.out.print("Enter element: ");
            	arr[a] = sc.nextInt();
				}

			 //mo call sa method
			 quickSort(arr, 0, arr.length - 1);
			 //para ma print hehe
			 System.out.println();
		     System.out.println("Sorted array: ");
			 for(int a = 0; a < num; a++){
			 System.out.println(arr[a] + " ");
				}
			}
//fastest method na mo sort ni siya
//mo pili siya og pivot element dayon ibutang sa tunga nya ang gamay kay ibutang sa left nya ang dako sa right
public static void quickSort(int arr[], int low, int high) {
	if (low < high) {
	int pi = partition(arr, low, high);

	quickSort(arr, low, pi - 1);
	quickSort(arr, pi + 1, high);
    }
}

public static int partition(int arr[], int low, int high) {
	int pivot = arr[high];
	int a = (low - 1);

	for (int b = low; b < high; b++) {
		if (arr[b] <= pivot) {
        	a++;

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        }
    }

        int temp = arr[a + 1];
        arr[a + 1] = arr[high];
        arr[high] = temp;

        return a + 1;
    }
}