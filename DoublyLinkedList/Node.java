package DataStructures.DoublyLinkedList;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node() {
    }
    
    public Node(T data) {
        this(data, null, null);
    }

    public Node(T data, Node<T> next, Node<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return this.prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> data(T data) {
        setData(data);
        return this;
    }

    public Node<T> next(Node<T> next) {
        setNext(next);
        return this;
    }

    public Node<T> prev(Node<T> prev) {
        setPrev(prev);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " data='" + getData() + "'" +
            ", next='" + getNext() + "'" +
            ", prev='" + getPrev() + "'" +
            "}";
    }
}