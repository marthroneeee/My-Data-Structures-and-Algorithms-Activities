import java.util.Scanner;
import java.util.Arrays;

public class selec{
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
			 selectionSort(arr);
			 //para ma print hehe
			 System.out.println();
		     System.out.println("Sorted array: ");
			 for(int a = 0; a < num; a++){
			 System.out.println(arr[a] + " ");
				}
			}
//mo select siya og kinagamyan na element bisag asa na part sa array
//dayon usa pa niya isort kung asa siya angayan ibutang
public static void selectionSort(int arr[]) {
	for (int a = 0; a < arr.length - 1; a++) {
		int minIndex = a;
        for (int b = a + 1; b < arr.length; b++) {
			if (arr[b] < arr[minIndex]) {
            minIndex = b;
            }
        }
        int temp = arr[minIndex];
        arr[minIndex] = arr[a];
        arr[a] = temp;
        }
    }
}


