package DataStructures.Queue;

import java.util.NoSuchElementException;

public class QueueLinkedList<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public QueueLinkedList() {
        this.front = this.rear = null;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public int getSize() {
        return this.size;
    }

    public void clear() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) this.front = newNode;
        else this.rear.setNext(newNode);
        this.rear = newNode;
        size++;

        // ======= PRINT QUEUE =======
        System.out.println("enqueu " + newNode.getData());
    }

    public void traverse() {
        if (isEmpty()) throw new NoSuchElementException();
        Node<T> curr = this.front;
        System.out.print("Queue = ");
        while (curr != null) {
            System.out.print("| " + curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println("| , Front = " + this.front.getData() + ", Rear = " + this.rear.getData());
    }

    public void traverseReverse() {
        if (isEmpty()) throw new NoSuchElementException();
        Node<T> curr = this.front;
        String reverseString = " |";
        while (curr != null) {
            reverseString = " | " + curr.getData() + reverseString;
            curr = curr.getNext();
        }
        System.out.println(reverseString);
    }

    public T remove() {
        if (isEmpty()) throw new NoSuchElementException();
        Node<T> removedNode = this.front;
        this.front = removedNode.getNext();
        this.size--;

        // ======= QUESTION 12 =======
        System.out.println("dequeue " + removedNode.getData());

        return removedNode.getData();
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.front.getData();
    }
}