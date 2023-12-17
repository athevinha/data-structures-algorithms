import java.util.*;

/**
 * The Solution class represents a solution for a specific problem.
 */
public class Solution {

    /**
     * The main method that reads input from STDIN, processes it, and prints the output to STDOUT.
     *
     * @param args Command-line arguments (not used in this case).
     */
    public static void main(String[] args) {
        PriorityQueue<Long> higher = new PriorityQueue<>();
        long sum = 0;
        Scanner sc = new Scanner(System.in);

        // Read input values
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] a = new long[n + 1];
        long[] ans = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        // Process the input
        higher.offer(a[1]);
        sum += a[1];
        ans[1] = a[1];

        for (int i = 2; i <= n; i++) {
            if (higher.size() < k) {
                higher.offer(a[i]);
                sum += a[i];
                ans[i] = sum;
            } else {
                long t = higher.peek();
                if (t < a[i]) {
                    higher.poll();
                    higher.offer(a[i]);
                    sum = sum - t + a[i];
                    ans[i] = sum;
                } else {
                    ans[i] = sum;
                }
            }
        }

        // Print the output
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
