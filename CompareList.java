import java.io.*;
import java.util.Scanner;

/**
 * This class contains a solution for comparing two singly linked lists.
 */
public class LinkedListComparison {

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
     * Compares two singly linked lists.
     *
     * @param head1 The head of the first linked list.
     * @param head2 The head of the second linked list.
     * @return true if the linked lists are the same, false otherwise.
     */
    static boolean compareLinkedLists(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data != temp2.data) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1 == null && temp2 == null;
    }

    /**
     * Main method to execute the linked list comparison.
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
            LinkedList linkedList1 = new LinkedList();

            int list1Size = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < list1Size; i++) {
                int listItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                linkedList1.insertNode(listItem);
            }

            LinkedList linkedList2 = new LinkedList();

            int list2Size = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < list2Size; i++) {
                int listItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                linkedList2.insertNode(listItem);
            }

            boolean result = compareLinkedLists(linkedList1.head, linkedList2.head);

            bufferedWriter.write(result ? "1" : "0");
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }
}
