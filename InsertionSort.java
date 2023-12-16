import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

    /**
     * Performs one step of the insertion sort algorithm on the provided array.
     *
     * @param n   The size of the array.
     * @param arr The array to be sorted.
     */
    public static void insertionSort1(int n, List<Integer> arr) {
        // Start from the second-to-last element of the array.
        int pos = n - 1;

        // Iterate backward through the array.
        for (int i = n - 2; i >= 0; i--) {
            // Compare the current element with the last element of the array.
            if (arr.get(i) > arr.get(pos)) {
                // If the current element is greater, shift elements to make space for insertion.
                for (int j = 0; j <= n - 1; j++) {
                    if (j == pos) {
                        // Print the intermediate array after the shift.
                        System.out.print(arr.get(i) + " ");
                    } else {
                        System.out.print(arr.get(j) + " ");
                    }
                }
                System.out.print('\n');

                // Swap the elements and update the position.
                int mid = arr.get(pos);
                arr.set(pos, arr.get(i));
                arr.set(i, mid);
                pos = i;
            } else {
                // Break the loop if the current element is not greater.
                break;
            }
        }

        // Print the final array after the insertion.
        for (int j = 0; j <= n - 1; j++) {
            System.out.print(arr.get(j) + " ");
        }
        System.out.print('\n');
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read the size of the array.
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        // Read the elements of the array.
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Call the insertionSort1 method to perform one step of the insertion sort.
        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
