
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * The Result class contains a static method for counting pairs with a specific difference.
 */
class Result {

    /**
     * Counts the number of pairs in the array with the specified difference.
     *
     * @param k   The target difference.
     * @param arr The input list of integers.
     * @return The number of pairs with the specified difference.
     */
    public static int pairs(int k, List<Integer> arr) {
        // Check for null input or empty array
        if (arr == null || arr.isEmpty()) {
            return 0;
        }

        Set<Integer> numberSet = new HashSet<>();
        int count = 0;

        for (int num : arr) {
            // Check for pairs with the specified difference
            if (numberSet.contains(num - k)) {
                count++;
            }
            if (numberSet.contains(num + k)) {
                count++;
            }
            numberSet.add(num);
        }

        return count;
    }
}

/**
 * The Solution class contains the main method for handling input and output.
 */
public class Solution {
    /**
     * Reads input from the console, processes it, and writes the result to the console.
     *
     * @param args Command line arguments (not used).
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Read input size and target difference
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        // Read input array
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        // Count pairs and write the result to the console
        int result = Result.pairs(k, arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        // Close resources
        bufferedReader.close();
        bufferedWriter.close();
    }
}
