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
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        PriorityQueue<Long> lower = new PriorityQueue<>();
        TreeMap<Long, Long> mp = new TreeMap<>();
        Long sum = 0L;

        for (long i = 1; i < n; i++) {
            long t = sc.nextLong();
            if (t == 1) {
                long q = sc.nextLong();
                lower.offer(q);
                mp.put(i, q);
            }
            if (t == 2) {
                long q = sc.nextLong();
                while (lower.size() >= q) {
                    removeElementFromMap(mp, lower.poll());
                }
            }
        }

        long t = sc.nextLong();
        long tmp = sc.nextLong();
        if (lower.size() < tmp) {
            System.out.println(-1);
        } else {
            while (!lower.isEmpty()) {
                sum += lower.poll();
            }
            System.out.println(sum);
            printKeys(mp);
        }
    }

    /**
     * Removes the specified value from the map.
     *
     * @param map   The map from which to remove the value.
     * @param value The value to be removed from the map.
     */
    private static void removeElementFromMap(TreeMap<Long, Long> map, Long value) {
        for (Iterator<Map.Entry<Long, Long>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Long, Long> entry = iterator.next();
            if (entry.getValue().equals(value)) {
                iterator.remove();
                break;
            }
        }
    }

    /**
     * Prints the keys of the map to STDOUT.
     *
     * @param map The map whose keys are to be printed.
     */
    private static void printKeys(TreeMap<Long, Long> map) {
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
    }
}
