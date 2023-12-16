import java.io.*;
import java.util.Scanner;

/**
 * This class contains a solution for merging two sorted singly linked lists.
 */
public class MergeSortedLinkedLists {

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
     * Merges two sorted singly linked lists into a new sorted linked list.
     *
     * @param head1 The head of the first sorted linked list.
     * @param head2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     */
    static ListNode mergeSortedLists(ListNode head1, ListNode head2) {
        ListNode result;
        if (head1.data < head2.data) {
            result = new ListNode(head1.data);
            head1 = head1.next;
        } else {
            result = new ListNode(head2.data);
            head2 = head2.next;
        }
        ListNode temp = result;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                result.next = new ListNode(head1.data);
                head1 = head1.next;
            } else {
                result.next = new ListNode(head2.data);
                head2 = head2.next;
            }
            result = result.next;
        }
        if (head1 == null && head2 != null) {
            result.next = head2;
        } else if (head1 != null && head2 == null) {
            result.next = head1;
        }
        return temp;
    }

    /**
     * Prints the singly linked list to the provided BufferedWriter.
     *
     * @param node           The head of the linked list.
     * @param sep            The separator to use between elements.
     * @param bufferedWriter The BufferedWriter to write the output.
     * @throws IOException If an I/O error occurs.
     */
    public static void printSinglyLinkedList(ListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    /**
     * Main method to execute the merging of sorted linked lists.
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

            ListNode mergedList = mergeSortedLists(linkedList1.head, linkedList2.head);

            printSinglyLinkedList(mergedList, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }
}
