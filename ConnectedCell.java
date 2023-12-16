
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /**
     * Finds the size of the largest connected cell in the matrix.
     *
     * @param matrix 2D matrix representing the grid
     * @return Size of the largest connected cell
     */
    public static int connectedCell(List<List<Integer>> matrix) {
        int maxSize = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 1) {
                    maxSize = Math.max(maxSize, DFS(matrix, i, j));
                }
            }
        }
        return maxSize;
    }

    /**
     * Performs Depth-First Search (DFS) to find the size of the connected cell.
     *
     * @param matrix 2D matrix representing the grid
     * @param i      Row index
     * @param j      Column index
     * @return Size of the connected cell starting from the specified position
     */
    public static int DFS(List<List<Integer>> matrix, int i, int j) {
        if (i < 0 || i >= matrix.size() || j < 0 || j >= matrix.get(i).size() || matrix.get(i).get(j) == 0) {
            return 0;
        }

        // Mark the cell as visited
        matrix.get(i).set(j, 0);

        int size = 1;
        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {
                size += DFS(matrix, i + row, j + col);
            }
        }

        return size;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        // Read the matrix from input
        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Calculate the result
        int result = Result.connectedCell(matrix);

        // Write the result to output
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        // Close readers and writers
        bufferedReader.close();
        bufferedWriter.close();
    }
}
