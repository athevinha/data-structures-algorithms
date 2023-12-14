package DataStructures.DepthFirstSearch;

import java.util.NoSuchElementException;

public class QueueLinkedList<T> {
    private QueueNode<T> front;
    private QueueNode<T> rear;
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
        QueueNode<T> newNode = new QueueNode<>(data);
        if (isEmpty()) this.front = newNode;
        else this.rear.setNext(newNode);
        this.rear = newNode;
        size++;
    }

    public void traverse() {
        if (isEmpty()) throw new NoSuchElementException();
        QueueNode<T> curr = this.front;
        while (curr != null) {
            System.out.print("| " + curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println("| ");
    }

    public void traverseReverse() {
        if (isEmpty()) throw new NoSuchElementException();
        QueueNode<T> curr = this.front;
        String reverseString = " |";
        while (curr != null) {
            reverseString = " | " + curr.getData() + reverseString;
            curr = curr.getNext();
        }
        System.out.println(reverseString);
    }

    public T remove() {
        if (isEmpty()) throw new NoSuchElementException();
        QueueNode<T> removedNode = this.front;
        this.front = removedNode.getNext();
        this.size--;
        return removedNode.getData();
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.front.getData();
    }

    public T poll() {
        if (isEmpty()) return null;
        QueueNode<T> removedNode = this.front;
        this.front = removedNode.getNext();
        this.size--;
        return removedNode.getData();
    }
}