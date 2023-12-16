
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
                this.tail.next = node;
            }

            // Update the tail to the new node
            this.tail = node;
        }
    }

    /**
     * Prints the elements of the linked list to the console.
     *
     * @param head The head of the linked list.
     */
    static void printLinkedList(SinglyLinkedListNode head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    /**
     * The main method for handling input and output.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SinglyLinkedList llist = new SinglyLinkedList();

        // Example: Insert nodes at the tail of the linked list
        llist.insertNode(1);
        llist.insertNode(2);
        llist.insertNode(3);

        // Print the linked list
        printLinkedList(llist.head);

        // Close resources
        scanner.close();
    }
}
