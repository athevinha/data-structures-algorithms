import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine(); // Consume the newline character after the integer input
        TreeMap<String, Integer> tm = new TreeMap<>();

        // Input names and phone numbers into TreeMap
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine(); // Consume the newline character after the integer input
            tm.put(name, phone);
        }

        // Query for names and print corresponding phone numbers
        while (in.hasNext()) {
            String query = in.nextLine();
            if (tm.containsKey(query)) {
                System.out.println(query + "=" + tm.get(query));
            } else {
                System.out.println("Not found");
            }
        }
        in.close(); // Close the Scanner
    }
}
