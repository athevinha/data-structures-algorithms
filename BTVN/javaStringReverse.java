import java.io.*;
import java.util.*;

/**
 * The {@code PalindromeChecker} class checks if a given string is a palindrome.
 */
public class PalindromeChecker {

    /**
     * Checks if the given string is a palindrome.
     *
     * @param str The input string.
     */
    public static void checkPalindrome(String str) {
        int length = str.length();
        int left = 0, right = length - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                System.out.println("No");
                return;
            }
            left++;
            right--;
        }
        System.out.print("Yes");
    }

    /**
     * Reads input, checks if it is a palindrome, and prints the result.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        checkPalindrome(inputString);
    }
}
