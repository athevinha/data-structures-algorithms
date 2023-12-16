
import java.io.*;
import java.util.Scanner;

/**
 * The Solution class contains methods for handling a singly linked list.
 */
public class Solution {

    /**
     * Represents a node in a singly linked list.
     */
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        /**
         * Constructs a new node with the given data.
         *
         * @param nodeData The data for the new node.
         */
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    /**
     * Represents a singly linked list.
     */
    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        /**
         * Constructs an empty singly linked list.
         */
        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }
    }

    /**
     * Inserts a new node with the given data at the head of the linked list.
     *
     * @param llist The head of the linked list.
     * @param data  The data for the new node.
     * @return The new head of the linked list.
     */
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        // If the linked list is empty, the new node becomes the head
        if (llist == null) {
            return newNode;
        } else {
            newNode.next = llist;
            return newNode;
        }
    }

    /**
     * Prints the elements of the linked list to the provided BufferedWriter.
     *
     * @param node           The head of the linked list.
     * @param sep            The separator between elements.
     * @param bufferedWriter The writer to output the elements.
     * @throws IOException If an I/O error occurs.
     */
    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
            throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    /**
     * The main method for handling input and output.
     *
     * @param args Command line arguments (not used).
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        Scanner scanner = new Scanner(System.in);

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // Insert nodes at the head of the linked list
        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedListNode llistHead = insertNodeAtHead(llist.head, llistItem);

            llist.head = llistHead;
        }

        // Print the linked list
        printSinglyLinkedList(llist.head, "\n", bufferedWriter);
        bufferedWriter.newLine();

        // Close resources
        bufferedWriter.close();
        scanner.close();
    }
}
