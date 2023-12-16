package DataStructures.QuickSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 22, 12, 9, 7, 31, 19, 2, 27 };
        QuickSort qSort = new QuickSort();
        qSort.sort(arr);

        // Ouput
        // Arr[] = 22 12 9 7 31 19 2 27  
        // Left index = 0, Right index = 7, Pivot index = 7, Pivot = 27
        // Initialize index_of_smaller_element = -1
        // Traverse elements from left [0] to right [7]
        // [i] = 0:
        // arr[0] < pivot, do index_of_smaller_element++
        // No change as index_of_smaller_element and [i] are same
        // [i] = 1:
        // arr[1] < pivot, do index_of_smaller_element++
        // No change as index_of_smaller_element and [i] are same
        // [i] = 2:
        // arr[2] < pivot, do index_of_smaller_element++
        // No change as index_of_smaller_element and [i] are same
        // [i] = 3:
        // arr[3] < pivot, do index_of_smaller_element++
        // No change as index_of_smaller_element and [i] are same
        // i = 4: arr[4] >= pivot, do nothing
        // [i] = 5:
        // arr[5] < pivot, do index_of_smaller_element++
        // and swap(arr[4], arr[5])
        // [i] = 6:
        // arr[6] < pivot, do index_of_smaller_element++
        // and swap(arr[5], arr[6])
        // i = 7: arr[7] >= pivot, do nothing
        // Come out of loop because index_of_smaller_element is now equal to right.
        // Place pivot at correct position by swapping arr[5+1] and arr[7]
        // arr[] = 22 12 9 7 19 2 27 31
        // Left index = 0, Right index = 5, Pivot index = 5, Pivot = 2
        // Initialize index_of_smaller_element = -1
        // Traverse elements from left [0] to right [5]
        // i = 0: arr[0] >= pivot, do nothing
        // i = 1: arr[1] >= pivot, do nothing
        // i = 2: arr[2] >= pivot, do nothing
        // i = 3: arr[3] >= pivot, do nothing
        // i = 4: arr[4] >= pivot, do nothing
        // i = 5: arr[5] >= pivot, do nothing
        // Come out of loop because index_of_smaller_element is now equal to right.
        // Place pivot at correct position by swapping arr[-1+1] and arr[5]
        // arr[] = 2 12 9 7 19 22 27 31
        // Left index = 1, Right index = 5, Pivot index = 5, Pivot = 22
        // Initialize index_of_smaller_element = 0
        // Traverse elements from left [1] to right [5]
        // [i] = 1:
        // arr[1] < pivot, do index_of_smaller_element++
        // No change as index_of_smaller_element and [i] are same
        // [i] = 2:
        // arr[2] < pivot, do index_of_smaller_element++
        // No change as index_of_smaller_element and [i] are same
        // [i] = 3:
        // arr[3] < pivot, do index_of_smaller_element++
        // No change as index_of_smaller_element and [i] are same
        // [i] = 4:
        // arr[4] < pivot, do index_of_smaller_element++
        // No change as index_of_smaller_element and [i] are same
        // i = 5: arr[5] >= pivot, do nothing
        // Come out of loop because index_of_smaller_element is now equal to right.
        // Place pivot at correct position by swapping arr[4+1] and arr[5]
        // arr[] = 2 12 9 7 19 22 27 31
        // Left index = 1, Right index = 4, Pivot index = 4, Pivot = 19
        // Initialize index_of_smaller_element = 0
        // Traverse elements from left [1] to right [4]
        // [i] = 1:
        // arr[1] < pivot, do index_of_smaller_element++
        // No change as index_of_smaller_element and [i] are same
        // [i] = 2:
        // arr[2] < pivot, do index_of_smaller_element++
        // No change as index_of_smaller_element and [i] are same
        // [i] = 3:
        // arr[3] < pivot, do index_of_smaller_element++
        // No change as index_of_smaller_element and [i] are same
        // i = 4: arr[4] >= pivot, do nothing
        // Come out of loop because index_of_smaller_element is now equal to right.
        // Place pivot at correct position by swapping arr[3+1] and arr[4]
        // arr[] = 2 12 9 7 19 22 27 31
        // Left index = 1, Right index = 3, Pivot index = 3, Pivot = 7
        // Initialize index_of_smaller_element = 0
        // Traverse elements from left [1] to right [3]
        // i = 1: arr[1] >= pivot, do nothing
        // i = 2: arr[2] >= pivot, do nothing
        // i = 3: arr[3] >= pivot, do nothing
        // Come out of loop because index_of_smaller_element is now equal to right.
        // Place pivot at correct position by swapping arr[0+1] and arr[3]
        // arr[] = 2 7 9 12 19 22 27 31
        // 2 7 9 12 19 22 27 31
    }
}
