
import java.io.*;
import java.util.stream.IntStream;

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

        /**
         * Inserts a new node with the given data at the tail of the linked list.
         *
         * @param nodeData The data for the new node.
         */
        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            // If the linked list is empty, the new node becomes the head
            if (this.head == null) {
                this.head = node;
            } else {
                // Add the new node at the tail
                this.tail.next = node;
            }

            // Update the tail to the new node
            this.tail = node;
        }
    }

    /**
     * Represents a helper class for printing the singly linked list.
     */
    static class SinglyLinkedListPrintHelper {
        /**
         * Prints the elements of the linked list to the console.
         *
         * @param node The head of the linked list.
         * @param sep  The separator between elements.
         */
        public static void printList(SinglyLinkedListNode node, String sep) {
            while (node != null) {
                System.out.print(node.data);

                node = node.next;

                if (node != null) {
                    System.out.print(sep);
                }
            }
        }
    }

    /**
     * Represents a class containing the logic for reversing and printing a singly linked list.
     */
    static class Result {

        /**
         * Reverses the given singly linked list and prints it in reverse order.
         *
         * @param llist The head of the linked list to reverse and print.
         */
        public static void reversePrint(SinglyLinkedListNode llist) {
            SinglyLinkedListNode head = null;
            SinglyLinkedListNode tail = null;

            // Reverse the linked list
            while (llist != null) {
                tail = llist;
                llist = llist.next;
                tail.next = head;
                head = tail;
            }

            // Print the reversed linked list
            while (tail != null) {
                System.out.println(tail.data);
                tail = tail.next;
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        int tests = Integer.parseInt(bufferedReader.readLine().trim());

        // Process each test case
        IntStream.range(0, tests).forEach(testsItr -> {
            try {
                SinglyLinkedList llist = new SinglyLinkedList();

                // Read the number of elements in the linked list
                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                // Insert nodes at the tail of the linked list
                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());
                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                // Reverse and print the linked list
                Result.reversePrint(llist.head);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Close the BufferedReader
        bufferedReader.close();
    }
}
