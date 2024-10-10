import java.util.Scanner;
import java.util.Arrays;

public class inset{
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
			 insertionSort(arr);
			 //para ma print hehe
			 System.out.println();
		     System.out.println("Sorted array: ");
			 for(int a = 0; a < num; a++){
			 System.out.println(arr[a] + " ");
				}
			}
//pili og usa ka number sa unsorted array na part
//dayon ibutang sa sorted array na part
public static void insertionSort(int arr[]) {
	for (int a = 1; a < arr.length; a++) {
    	int key = arr[a];
        int b = a - 1;

	while (b >= 0 && arr[b] > key) {
    	arr[b + 1] = arr[b];
        b = b - 1;
        }
        arr[b + 1] = key;
        }
    }
}


