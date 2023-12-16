
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * The Result class contains a static method for determining the minimum number of bribes.
 */
class Result {

    /**
     * Determines the minimum number of bribes made to queue up.
     *
     * @param q The input list representing the final state of the queue.
     */
    public static void minimumBribes(List<Integer> q) {
        // Check for null or empty input
        if (q == null || q.isEmpty()) {
            System.out.println("Invalid input");
            return;
        }

        int count = 0;

        // Iterate through the queue in reverse order
        for (int i = q.size() - 1; i >= 0; i--) {
            // Check for chaotic conditions
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            } else {
                // Count the number of bribes made for each person
                for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                    if (q.get(j) > q.get(i)) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}

/**
 * The Solution class contains the main method for handling input and output.
 */
public class Solution {
    /**
     * Reads input from the console, processes it, and prints the result to the console.
     *
     * @param args Command line arguments (not used).
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        // Process each test case
        IntStream.range(0, t).forEach(tItr -> {
            try {
                // Read the size of the queue
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                // Read the queue elements
                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                // Invoke the minimumBribes method for each test case
                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Close the input stream
        bufferedReader.close();
    }
}
