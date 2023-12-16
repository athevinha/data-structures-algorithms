import java.io.*;
import java.util.*;

/**
 * The {@code MedianFinder} class provides a method to find the median of an array of integers using quicksort.
 */
class MedianFinder {

    /**
     * Partitions the array and returns the pivot index.
     *
     * @param l   The left boundary of the partition.
     * @param r   The right boundary of the partition.
     * @param arr The list of integers to be partitioned.
     * @return The pivot index.
     */
    public static int partition(int l, int r, List<Integer> arr) {
        int i = l;
        int pivot = arr.get(r);

        for (int j = l; j < r; j++) {
            int val = arr.get(j);
            if (val < pivot) {
                Collections.swap(arr, i++, j);
            }
        }

        Collections.swap(arr, r, i);
        return i;
    }

    /**
     * Finds the median of the given list of integers using quicksort.
     *
     * @param arr The list of integers.
     * @return The median.
     */
    public static int findMedian(List<Integer> arr) {
        int n = arr.size();
        int k = n / 2;
        int l = 0, r = n - 1;

        while (true) {
            int pos = partition(l, r, arr);

            if (pos == k) {
                return arr.get(pos);
            } else if (pos < k) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
    }
}

/**
 * The {@code MedianSolution} class is responsible for reading input, finding the median, and displaying the result.
 */
public class MedianSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = MedianFinder.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
