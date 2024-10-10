import java.util.Scanner;
import java.util.Arrays;

public class Bub{
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
			 BubSort(arr);
			 //para ma print hehe
			 System.out.println();
		     System.out.println("Sorted array: ");
			 for(int a = 0; a < num; a++){
			 System.out.println(arr[a] + " ");
				}
			}
	//mao ni ang method sa bubble sort
	//una kay icheck niya ang mga tapad tapad
	//dayon if dili sakto ang order kay iyang itarong para ma sort na
	public static void BubSort(int arr[]) {
		for (int a = 0; a < arr.length - 1; a++) {
			for (int b = 0; b < arr.length - a - 1; b++) {
				if (arr[b] > arr[b + 1]) {
				//mo swap sa elements if dili sakto ang order
			     int temp = arr[b];
			     arr[b] = arr[b + 1];
			     arr[b + 1] = temp;
			     }
			   }
			}
    	}

	}