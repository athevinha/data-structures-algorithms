import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as a parameter.
     */

    public static String isBalanced(String s) {
        // Create a stack to track opening brackets
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the characters in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') 
                stack.push(0);
            else if (s.charAt(i) == '[') 
                stack.push(1);
            else if (s.charAt(i) == '{') 
                stack.push(2);
            else if (s.charAt(i) == ')') {
                // Check if the stack is not empty and the top of the stack matches the corresponding opening bracket
                if (!stack.isEmpty() && stack.peek() == 0) 
                    stack.pop();
                else 
                    return "NO";
            }
            else if (s.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == 1) 
                    stack.pop();
                else 
                    return "NO";
            }
            else {
                if (!stack.isEmpty() && stack.peek() == 2) 
                    stack.pop();
                else 
                    return "NO";
            }
        }
        
        // Check if the stack is empty, indicating all opening brackets have matching closing brackets
        if (stack.isEmpty()) 
            return "YES";
        return "NO";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
