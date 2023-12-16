import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * The {@code QuickSorter} class provides a quicksort implementation for sorting a list of integers.
 */
class QuickSorter {

    /**
     * Sorts the given list of integers using the quicksort algorithm.
     *
     * @param inputList The list of integers to be sorted.
     * @return A sorted list of integers.
     */
    public static List<Integer> performQuickSort(List<Integer> inputList) {
        // Base case: If the list has 1 or fewer elements, it is already sorted
        if (inputList.size() <= 1) {
            return inputList;
        }

        // Choose the first element as the pivot
        int pivotIndex = 0;
        int pivot = inputList.get(pivotIndex);

        // Partition the list into elements less than the pivot and elements greater than the pivot
        List<Integer> leftPartition = new ArrayList<>();
        List<Integer> rightPartition = new ArrayList<>();

        for (int i = 1; i < inputList.size(); i++) {
            int current = inputList.get(i);
            if (current < pivot) {
                leftPartition.add(current);
            } else {
                rightPartition.add(current);
            }
        }

        // Recursively sort the partitions
        List<Integer> sortedLeft = performQuickSort(leftPartition);
        List<Integer> sortedRight = performQuickSort(rightPartition);

        // Combine the sorted partitions and pivot to get the final sorted list
        List<Integer> sortedList = new ArrayList<>(sortedLeft);
        sortedList.add(pivot);
        sortedList.addAll(sortedRight);

        return sortedList;
    }
}

/**
 * The {@code SortingDriver} class is responsible for reading input, performing sorting, and displaying the sorted result.
 */
public class SortingDriver {

    /**
     * Reads input, performs sorting using quicksort, and displays the sorted result.
     *
     * @param args Command-line arguments (not used).
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Read the size of the array
        int arraySize = Integer.parseInt(reader.readLine().trim());

        // Read the array elements and convert them to a list of integers
        List<Integer> inputList = Arrays.stream(reader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Perform quicksort and get the sorted result
        List<Integer> sortedResult = QuickSorter.performQuickSort(inputList);

        // Write the sorted result to the output
        writer.write(
                sortedResult.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
                        + "\n"
        );

        // Close the readers and writers
        reader.close();
        writer.close();
    }
}
