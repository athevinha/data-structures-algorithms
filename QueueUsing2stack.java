import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();

        int q = sc.nextInt(); // Number of queries

        while (q-- != 0) {
            int t = sc.nextInt(); // Type of query

            if (t == 1) {
                // Enqueue operation: Add an element to the queue
                int x = sc.nextInt();
                queue.add(x);
            }
            else if (t == 2) {
                // Dequeue operation: Remove the front element from the queue
                queue.remove();
            }
            else {
                // Print Front operation: Print the front element of the queue
                System.out.println(queue.peek());
            }
        }
    }
}
