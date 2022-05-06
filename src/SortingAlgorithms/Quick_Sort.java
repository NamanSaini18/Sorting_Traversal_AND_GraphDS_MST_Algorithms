package SortingAlgorithms;
import java.util.Scanner;

public class Quick_Sort {
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        // Taking the size of the array as input
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        // Here, the unsorted elements of the array will be taken as input
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sc.nextInt();
        }
        quicksort(arr,0,arr.length-1);
        printArray(arr);


    }
    public static void quicksort(int[] arr, int start, int end)
    {
        if(start< end)
        {
            int pivot = partition(arr,start,end);
            // left side of the array
            quicksort(arr,start,pivot-1);
            // right side of the array
            quicksort(arr,pivot+1,end);

        }
    }
    public static int partition(int[] arr, int h, int l)
    {
        int pivot = l;
        int i = h-1;
        for(int j=h;j<=l;j++)
        {
            if(arr[j]<=arr[pivot])
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }

    public static void printArray(int arr[])
    {
        System.out.println("This sorting is done by using the Quick Sort Algorithm ");
        System.out.println("The sorted array is: ");
        for(int i=0;i<arr.length;i++)
        {

            System.out.print(arr[i] + " ");
        }
    }
}
