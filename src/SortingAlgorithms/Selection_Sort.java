package SortingAlgorithms;

import java.util.Scanner;

public class Selection_Sort {
    public static void printArray(int [] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of your array: ");
        int n = sc.nextInt();

        int [] arr = new int[n]; // taking the elements of the array as input
        System.out.println("Enter the elements of your array: ");
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();

        }
        //Selection Sort Technique
        for (int i = 0; i < arr.length-1; i++) {
            int smallest = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[smallest] > arr[j]){
                    smallest = j;
                }

            }
            //swap
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        printArray(arr);

    }
}
