import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result {

    /**
     * Performs the insertion sort algorithm on the provided array and prints the
     * intermediate arrays at each step.
     *
     * @param n   The size of the array.
     * @param arr The array to be sorted.
     */
    public static void insertionSort2(int n, List<Integer> arr) {
        // Iterate through the array starting from the second element.
        for (int i = 1; i < n; i++) {
            int pos = i;

            // Compare the current element with its predecessors and swap if necessary.
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(pos) < arr.get(j)) {
                    // Swap elements.
                    int mid = arr.get(pos);
                    arr.set(pos, arr.get(j));
                    arr.set(j, mid);
                    pos = j;
                } else {
                    // Break the loop if no more swaps are needed.
                    break;
                }
            }

            // Print the intermediate array after each step.
            for (int j = 0; j < n; j++) {
                System.out.print(arr.get(j) + " ");
            }
            System.out.print("\n");
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read the size of the array.
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        // Read the elements of the array.
        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        // Call the insertionSort2 method to perform the insertion sort and print intermediate arrays.
        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
