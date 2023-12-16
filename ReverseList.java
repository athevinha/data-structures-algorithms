import java.io.*;
import java.util.Scanner;

/**
 * This class contains a solution for reversing a singly linked list.
 */
public class LinkedListReversal {

    /**
     * Represents a node in a singly linked list.
     */
    static class ListNode {
        int data;
        ListNode next;

        /**
         * Constructs a new ListNode with the given data.
         *
         * @param nodeData The data to be stored in the node.
         */
        public ListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    /**
     * Represents a singly linked list.
     */
    static class LinkedList {
        ListNode head;
        ListNode tail;

        /**
         * Constructs an empty linked list.
         */
        public LinkedList() {
            this.head = null;
            this.tail = null;
        }

        /**
         * Inserts a new node with the given data to the linked list.
         *
         * @param nodeData The data for the new node.
         */
        public void insertNode(int nodeData) {
            ListNode node = new ListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    /**
     * Reverses a singly linked list.
     *
     * @param head The head of the linked list.
     * @return The head of the reversed linked list.
     */
    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode newHead = null;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = newHead;
            newHead = current;
            current = nextNode;
        }

        return newHead;
    }

    /**
     * Prints the elements of a singly linked list.
     *
     * @param head           The head of the linked list.
     * @param separator      The separator between elements.
     * @param bufferedWriter The BufferedWriter to write the output.
     * @throws IOException If an I/O error occurs.
     */
    public static void printLinkedList(ListNode head, String separator, BufferedWriter bufferedWriter) throws IOException {
        while (head != null) {
            bufferedWriter.write(String.valueOf(head.data));

            head = head.next;

            if (head != null) {
                bufferedWriter.write(separator);
            }
        }
    }

    /**
     * Main method to execute the linked list reversal.
     *
     * @param args The command line arguments (not used in this case).
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testItr = 0; testItr < tests; testItr++) {
            LinkedList linkedList = new LinkedList();

            int listSize = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < listSize; i++) {
                int listItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                linkedList.insertNode(listItem);
            }

            ListNode reversedList = reverseLinkedList(linkedList.head);

            printLinkedList(reversedList, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }
}
