import java.io.*;
import java.util.*;

/**
 * The {@code Result} class provides a method to calculate the minimum operations to achieve the desired sweetness.
 */
class Result {

    /**
     * Calculates the minimum operations to achieve the desired sweetness.
     *
     * @param k The threshold sweetness level.
     * @param sweetnessLevels The list of sweetness levels of cookies.
     * @return The minimum number of operations, or -1 if it's not possible.
     */
    public static int cookies(int k, List<Integer> sweetnessLevels) {
        int operations = 0;
        int n = sweetnessLevels.size();

        // Use PriorityQueue to efficiently handle sweetness levels
        PriorityQueue<Integer> sweetnessQueue = new PriorityQueue<>(sweetnessLevels);

        while (!sweetnessQueue.isEmpty() && sweetnessQueue.peek() < k) {
            int leastSweet = sweetnessQueue.poll();

            if (!sweetnessQueue.isEmpty()) {
                int secondLeastSweet = sweetnessQueue.poll();

                int newCookieSweetness = leastSweet + 2 * secondLeastSweet;
                sweetnessQueue.offer(newCookieSweetness);
                operations++;
            } else {
                return -1; // Not possible to achieve the threshold sweetness
            }
        }

        return operations;
    }
}

/**
 * The {@code Solution} class is the main application class for solving the problem.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] sweetnessLevelsInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> sweetnessLevels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sweetness = Integer.parseInt(sweetnessLevelsInput[i]);
            sweetnessLevels.add(sweetness);
        }

        int result = Result.cookies(k, sweetnessLevels);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
