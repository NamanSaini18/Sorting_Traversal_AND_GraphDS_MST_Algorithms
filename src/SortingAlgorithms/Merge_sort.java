package SortingAlgorithms;

import java.util.Scanner;

public class Merge_sort {
    public static void divide(int arr[], int start, int end)
    {
        if(start >= end)
        {
            return;
        }
        int mid = start + (end-start)/2;  // (si+ei)/2
        divide(arr,start,mid);
        divide(arr,mid+1,end);
        conquer(arr,start,mid,end);
    }
    public static void conquer(int arr[], int start, int mid,int end)
    {
        int merged[] = new int[end - start + 1];

        int idx1 = start;
        int idx2 = mid+1;
        int x = 0;

        while(idx1<= mid && idx2<= end)
        {
            if(arr[idx1] <= arr[idx2])
            {
                merged[x++] = arr[idx1++];
            }
            else
            {
                merged[x++] = arr[idx2++];

            }
        }
        while(idx1 <= mid )
        {
            merged[x++] = arr[idx1++];
        }
        while(idx2 <= end)
        {
            merged[x++] = arr[idx2++];
        }
        for(int i=0, j=start;i<merged.length;i++,j++)
        {
            arr[j] = merged[i];
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        int size = arr.length;
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sc.nextInt();
        }

        divide(arr,0,n-1);
        // print the sorted array
        for(int i=0;i<size;i++)
        {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
