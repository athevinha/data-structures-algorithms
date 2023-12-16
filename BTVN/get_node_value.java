import java.io.*;
import java.util.Scanner;

/**
 * This class contains a solution for finding the data of a node at a specified position from the tail
 * in a singly linked list.
 */
public class FindNodeFromTail {

    /**
     * Represents a node in a singly linked list.
     */
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        /**
         * Constructs a new SinglyLinkedListNode with the given data.
         *
         * @param nodeData The data to be stored in the node.
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
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;

        /**
         * Constructs an empty singly linked list.
         */
        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        /**
         * Inserts a new node with the given data to the singly linked list.
         *
         * @param nodeData The data for the new node.
         */
        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    /**
     * Finds the data of the node at the specified position from the tail of the singly linked list.
     *
     * @param head             The head of the singly linked list.
     * @param positionFromTail The position of the node from the tail.
     * @return The data of the node at the specified position from the tail.
     */
    public static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode temp = head;
        int count = 0;

        // Count the total number of nodes in the linked list
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Calculate the position from the head
        int positionFromHead = (count - 1) - positionFromTail;

        count = 0;
        SinglyLinkedListNode temp1 = head;

        // Traverse the linked list to find the node at the specified position from the head
        while (count != positionFromHead) {
            count++;
            temp1 = temp1.next;
        }

        // Return the data of the node
        return temp1.data;
    }

    /**
     * Main method to execute the finding of the node from the tail of the singly linked list.
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
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int position = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = getNode(llist.head, position);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }
}
