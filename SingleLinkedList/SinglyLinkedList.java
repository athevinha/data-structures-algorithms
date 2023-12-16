package DataStructures.SingleLinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int getSize() {
        return this.size;
    }

    public void clear() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) this.tail = newNode;
        else newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }

    public void addLast(T data) {
        if (isEmpty()) {
            addFirst(data);
            return;
        }
        Node<T> newNode = new Node<>(data);
        this.tail.setNext(newNode);
        this.tail = newNode;
        size++;
    }

    public void traverse() {
        if (isEmpty()) throw new NoSuchElementException();
        Node<T> currNode = this.head;
        while (currNode != null) {
            System.out.println(currNode.getData());
            currNode = currNode.getNext();
        }
    }

    public T removeAtFront() {
        if (isEmpty()) throw new NoSuchElementException();
        Node<T> removedNode = this.head;
        this.head = removedNode.getNext();
        this.size--;
        System.out.println("Front element deleted");
        return removedNode.getData();
    }

    public T removeAt(int index) {
        if (isEmpty()) throw new NoSuchElementException();
        if (index > this.size-1 || index < 0) throw new IndexOutOfBoundsException();
        Node<T> removedNode = this.head, prevNode = null;
        if (index == 0 && !isEmpty()) {
            return removeAtFront();
        }
        int counter = 0;
        while (removedNode != null) {
            if (counter == index) {
                prevNode.setNext(removedNode.getNext());
                System.out.println(index + " position element deleted");
                size--;
                return removedNode.getData();
            }
            prevNode = removedNode;
            removedNode = removedNode.getNext();
            counter++;
        }
        System.out.println(index + " position element not found");
        return null;
    }
}