
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
         * Prints the elements of the linked list to the provided BufferedWriter.
         *
         * @param node           The head of the linked list.
         * @param sep            The separator between elements.
         * @param bufferedWriter The writer to output the elements.
         * @throws IOException If an I/O error occurs.
         */
        public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
                throws IOException {
            while (node != null) {
                bufferedWriter.write(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    bufferedWriter.write(sep);
                }
            }
        }
    }

    /**
     * Represents a class containing the logic for deleting a node in a singly linked list.
     */
    static class Result {

        /**
         * Deletes the node at the specified position in the linked list.
         *
         * @param head     The head of the linked list.
         * @param position The position of the node to delete.
         * @return The new head of the linked list after deletion.
         */
        public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
            int count = 0;
            SinglyLinkedListNode temp = head;

            // If the position is 0, delete the head
            if (position == 0) {
                head = head.next;
                return head;
            }

            // Iterate to the node before the one to be deleted
            while (count != position - 1) {
                temp = temp.next;
                count++;
            }

            // Delete the node at the specified position
            if (temp.next.next != null) {
                temp.next = temp.next.next;
            } else {
                temp.next = null;
            }

            return head;
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
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        // Read the position of the node to delete
        int position = Integer.parseInt(bufferedReader.readLine().trim());

        // Delete the node at the specified position
        SinglyLinkedListNode llist1 = Result.deleteNode(llist.head, position);

        // Print the updated linked list
        SinglyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
        bufferedWriter.newLine();

        // Close resources
        bufferedReader.close();
        bufferedWriter.close();
    }
}
