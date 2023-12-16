import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * The Result class contains a static method to calculate the maximum height at which three stacks
 * can be made equal by removing elements from the top of the stacks.
 */
class Result {

    /**
     * Calculates the maximum height at which three stacks can be made equal.
     *
     * @param h1 List of integers representing the elements of the first stack.
     * @param h2 List of integers representing the elements of the second stack.
     * @param h3 List of integers representing the elements of the third stack.
     * @return The maximum height at which the three stacks can be made equal.
     */
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Initialize the maximum height.
        int maxHeight = 0;

        // Create three stacks for each stack and their total heights.
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        // Fill the stacks with cumulative heights.
        fillStacks(st1, h1, st2, h2, st3, h3);

        // Continue until any of the stacks is empty.
        while (!st1.isEmpty() && !st2.isEmpty() && !st3.isEmpty()) {

            // Get the current heights of each stack.
            int stack1Height = st1.peek();
            int stack2Height = st2.peek();
            int stack3Height = st3.peek();

            // Check if the heights are equal.
            if (stack1Height == stack2Height && stack2Height == stack3Height) {
                // Update the maximum height and break the loop.
                maxHeight = st1.peek();
                break;
            }

            // Pop the element from the stack with the maximum height.
            if (stack1Height >= stack2Height && stack1Height >= stack3Height) {
                st1.pop();
            } else if (stack2Height >= stack1Height && stack2Height >= stack3Height) {
                st2.pop();
            } else if (stack3Height >= stack1Height && stack3Height >= stack2Height) {
                st3.pop();
            }
        }

        // Return the maximum height.
        return maxHeight;
    }

    /**
     * Fills the stacks with cumulative heights.
     *
     * @param st1 Stack for the first list.
     * @param h1  List of integers representing the elements of the first stack.
     * @param st2 Stack for the second list.
     * @param h2  List of integers representing the elements of the second stack.
     * @param st3 Stack for the third list.
     * @param h3  List of integers representing the elements of the third stack.
     */
    public static void fillStacks(Stack<Integer> st1, List<Integer> h1, Stack<Integer> st2, List<Integer> h2,
                                  Stack<Integer> st3, List<Integer> h3) {
        int st1TotalHeight = 0, st2TotalHeight = 0, st3TotalHeight = 0;

        // Fill the first stack.
        for (int i = h1.size() - 1; i >= 0; i--) {
            st1TotalHeight += h1.get(i);
            st1.push(st1TotalHeight);
        }

        // Fill the second stack.
        for (int i = h2.size() - 1; i >= 0; i--) {
            st2TotalHeight += h2.get(i);
            st2.push(st2TotalHeight);
        }

        // Fill the third stack.
        for (int i = h3.size() - 1; i >= 0; i--) {
            st3TotalHeight += h3.get(i);
            st3.push(st3TotalHeight);
        }
    }
}

/**
 * The Solution class reads input and executes the equalStacks method.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // Read input for the sizes of the three stacks and their elements.
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n1 = Integer.parseInt(firstMultipleInput[0]);
        int n2 = Integer.parseInt(firstMultipleInput[1]);
        int n3 = Integer.parseInt(firstMultipleInput[2]);

        // Read elements of the first stack.
        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Read elements of the second stack.
        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Read elements of the third stack.
        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Execute the equalStacks method to get the result.
        int result = Result.equalStacks(h1, h2, h3);

        // Write the result to the output.
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
