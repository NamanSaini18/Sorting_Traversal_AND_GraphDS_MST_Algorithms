import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int arr[], int first, int last, int key){
        if (last>=first){
            int mid = first + (last - first)/2;

            if (arr[mid] == key){
                return mid;
            }
            else if (arr[mid] > key){
                return binarySearch(arr, first, mid-1, key);//searching in left subarray
            }
            else
            {
                return binarySearch(arr, mid+1, last, key);//searching in right subarray
            }
        }
        return -1;   // If element is not found in the array then return -1
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i=0;i < arr.length;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("The array entered by you is: ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        Arrays.sort(arr); // here we are sorting the input array


        System.out.println("Enter the key: ");
        int key = sc.nextInt();
        int last=arr.length-1;

        int result = binarySearch(arr,0,last,key);
        if (result == -1)
            System.out.println("Element is not found in the sequence!!!");
        else
            System.out.println("Given key matched successfully");
        System.out.println("Element is found at the index: " + result);

    }
}
