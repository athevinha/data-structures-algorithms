package com.mycompany.app.sort;

import java.util.Arrays;

public class insertionSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while(j >= 1 && arr[j] < arr[j - 1]){
                int k = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = k;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Original Array: " + Arrays.toString(arr));

        sort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

}
