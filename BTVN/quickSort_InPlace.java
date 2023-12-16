import java.util.*;

/**
 * The {@code QuickSortSolution} class provides an implementation of the quicksort algorithm for sorting an array of integers.
 */
public class QuickSortSolution {

    // Scanner to read input
    private static Scanner scanner = new Scanner(System.in);
    
    // Size of the array
    private static int arraySize;

    // Array to store elements
    private static int[] elements = new int[5006];

    /**
     * Swaps two elements in the array.
     *
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    public static void swap(int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    /**
     * Partitions the array and returns the pivot index.
     *
     * @param left  The left boundary of the partition.
     * @param right The right boundary of the partition.
     * @return The pivot index.
     */
    public static int partition(int left, int right) {
        int pivotIndex = right;
        int i = left;

        for (int j = left; j < right; j++) {
            if (elements[j] < elements[pivotIndex]) {
                swap(i, j);
                i++;
            }
        }

        swap(right, i);
        return i;
    }

    /**
     * Recursively performs quicksort on the array.
     *
     * @param left  The left boundary of the array.
     * @param right The right boundary of the array.
     */
    public static void quicksort(int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = partition(left, right);

        // Print the current state of the array
        for (int i = 1; i <= arraySize; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.print("\n");

        quicksort(left, mid - 1);
        quicksort(mid + 1, right);
    }

    /**
     * Reads input, performs quicksort, and displays the sorted result.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        arraySize = scanner.nextInt();

        for (int i = 1; i <= arraySize; i++) {
            elements[i] = scanner.nextInt();
        }

        quicksort(1, arraySize);
    }
}
