import java.util.Scanner;
import java.util.Arrays;

public class merge{
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
			 mergeSort(arr, 0, arr.length - 1);
			 //para ma print hehe
			 System.out.println();
		     System.out.println("Sorted array: ");
			 for(int a = 0; a < num; a++){
			 System.out.println(arr[a] + " ");
				}
			}
//una kay tungaon niya ang array into 2
//usa pa niya isort kato iyang gi tunga
//dayon isort niya balik duha ga gi sort ganiha na array para ma usa na
public static void mergeSort(int arr[], int left, int right) {
      if (left < right) {
          int mid = left + (right - left) / 2;

          mergeSort(arr, left, mid);
          mergeSort(arr, mid + 1, right);

          merge(arr, left, mid, right);
        }
    }

public static void merge(int arr[], int left, int mid, int right) {
      int n1 = mid - left + 1;
      int n2 = right - mid;

      int L[] = new int[n1];
      int R[] = new int[n2];


      System.arraycopy(arr, left, L, 0, n1);
      System.arraycopy(arr, mid + 1, R, 0, n2);

      int a = 0, b = 0;

      int c = left;
      while (a < n1 && b < n2) {
          if (L[a] <= R[b]) {
              arr[c] = L[a];
              a++;
        }
      else {
              arr[c] = R[b];
              b++;
            }
            c++;
        }

      while (a < n1) {
            arr[c] = L[a];
            a++;
            c++;
        }

      while (b < n2) {
            arr[c] = R[b];
            b++;
            c++;
        }
    }
}


