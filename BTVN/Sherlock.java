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
 * The Result class contains a static method for determining if an array has a balanced sum.
 */
class Result {

    /**
     * Determines if there exists an index in the array such that the sum of elements to the left
     * is equal to the sum of elements to the right.
     *
     * @param a The input list of integers.
     * @return "YES" if a balanced sum exists, "NO" otherwise.
     */
    public static String balancedSums(List<Integer> a) {
        // Write your code here

        // Check for null input
        if (a == null) {
            return "NO";
        }

        // Check for single element array
        if (a.size() == 1) {
            return "YES";
        }

        // Calculate the total sum of the array
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
        }

        // Check for balanced sum
        int sumL = 0;
        for (int i = 0; i < a.size(); i++) {
            if (i == 0) {
                sumL += 0;
            } else {
                sumL += a.get(i - 1);
            }
            int sumR = sum - sumL - a.get(i);
            if (sumL == sumR) {
                return "YES";
            }
        }
        return "NO";
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

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                // Invoke the balancedSums method and write the result
                String result = Result.balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Close resources
        bufferedReader.close();
        bufferedWriter.close();
    }
}
