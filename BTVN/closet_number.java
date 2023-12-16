import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * The Result class contains a static method for finding pairs with the closest numbers.
 */
class Result {

    /**
     * Finds pairs with the closest numbers in the given array.
     *
     * @param arr The input list of integers.
     * @return A list of integers representing pairs with the closest numbers.
     */
    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Check for null input or input with less than two elements
        if (arr == null || arr.size() < 2) {
            return new ArrayList<Integer>();
        }

        // Initialize variables
        int minDifference = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<Integer>();

        // Sort the array
        Collections.sort(arr);

        // Find pairs with the closest numbers
        for (int i = 1; i < arr.size(); i++) {
            int currentDifference = Math.abs(arr.get(i) - arr.get(i - 1));

            // Update result for a smaller difference
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                result.clear();
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            } else if (currentDifference == minDifference) {
                // Add to the result for equal differences
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            }
        }

        return result;
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

        // Read input size
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        // Read input array
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        // Find closest numbers and write the result to the console
        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        // Close resources
        bufferedReader.close();
        bufferedWriter.close();
    }
}
