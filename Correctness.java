import java.io.*;
import java.util.*;

public class Solution {

    // Implementation of Insertion Sort
    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        // Print the sorted array
        printArray(A);
    }

    // Helper method to print an array
    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }

        // Call the insertionSort method
        insertionSort(ar);
    }
}
