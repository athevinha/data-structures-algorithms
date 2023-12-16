package DataStructures.StackLinkedListDecToRep;

import java.util.EmptyStackException;

public class StackLinkedList<T> {
    private Node<T> root;
    private int size;

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        this.root = null;
        this.size = 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) this.root = newNode;
        else {
            Node<T> temp = this.root;
            this.root = newNode;
            newNode.setNext(temp);
        }
        this.size++;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T poped = null;
        poped = this.root.getData();
        this.root = this.root.getNext();
        this.size--;
        return poped;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return root.getData();
    }

    public void traverse() {
        if (isEmpty()) return;
        Node<T> curr = this.root;
        while (curr != null) {
            System.out.print(" | " + curr.getData());
            curr = curr.getNext();
        }
        System.out.println(" | ");
    }
}
