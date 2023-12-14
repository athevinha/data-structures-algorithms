package DataStructures.DoublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
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

    public void insertAtHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) this.tail = this.head = newNode;
        else {
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
        this.size++;
    }

    public void insertAfter(int index, T data) {
        if (index > this.size-1 || index < 0) throw new NoSuchElementException();
        if (index == 0 || isEmpty()) {
            insertAtHead(data);
            return;
        }
        if (index == this.size - 1) {
            insertAtTail(data);
            return;
        }
        Node<T> newNode = new Node<>(data);
        Node<T> tempNode = this.head;
        int counter = 0;
        while (tempNode != null) {
            if (counter == index-1) {
                newNode.setNext(tempNode.getNext());
                tempNode.setNext(newNode);
                newNode.setPrev(tempNode);
                newNode.getNext().setPrev(newNode);
                System.out.println(index + " position element inserted!");
                this.size++;
                return;
            }
            tempNode = tempNode.getNext();
            counter++;
        }
    }

    public void insertAtTail(T data) {
        if (isEmpty()) insertAtHead(data);
        Node<T> newNode = new Node<>(data);
        this.tail.setNext(newNode);
        newNode.setPrev(this.tail);
        this.tail = newNode;
        this.size++;
    }

    public T removeFromHead() {
        if (isEmpty()) throw new NoSuchElementException();
        Node<T> removedNode = this.head;
        if (this.head.getNext() == null) {
            clear();
            return removedNode.getData();
        }
        this.head.getNext().setPrev(null);
        this.head = this.head.getNext();
        this.size--;
        removedNode.setNext(null);
        return removedNode.getData();
    }

    public T removeAt(T data) {
        if (isEmpty() || data == null) throw new NoSuchElementException();
        if (data.equals(this.head.getData())) return removeFromHead();
        if (data.equals(this.tail.getData())) return removeFromEnd();

        Node<T> removedNode = this.head;
        while (removedNode != null) {
            if (removedNode.getData().equals(data)) {
                removedNode.getNext().setPrev(removedNode.getPrev());
                removedNode.getPrev().setNext(removedNode.getNext());
                this.size--;
                return removedNode.getData();
            }
            removedNode = removedNode.getNext();
        }
        return null;
    }

    public T removeAt(int index) {
        if (index > this.size-1 || index < 0) throw new IndexOutOfBoundsException();
        if (isEmpty() || index == 0)  return removeFromHead();
        if (index == this.size - 1) return removeFromEnd();
        Node<T> removedNode = this.head;
        int counter = 0;
        while (removedNode != null) {
            if (index == counter) {
                removedNode.getPrev().setNext(removedNode.getNext());
                removedNode.getNext().setPrev(removedNode.getPrev());
                this.size--;
                return removedNode.getData();
            }
            removedNode = removedNode.getNext();
            counter++;
        }
        return null;
    }

    public T removeFromEnd() {
        if (isEmpty()) throw new NoSuchElementException();
        Node<T> removedNode = this.tail;
        if (tail.getPrev() == null) {
            clear();
            return removedNode.getData();
        }
        tail.getPrev().setNext(null);
        removedNode.setPrev(null);
        tail = tail.getPrev();
        this.size--;
        return removedNode.getData();
    }

    public void traverse() {
        if (isEmpty()) throw new NoSuchElementException();
        Node<T> curr = this.head;
        while (curr != null) {
            System.out.println(curr.getData());
            curr = curr.getNext();
        }
    }

    public T search(T data) {
        if (isEmpty()) throw new NoSuchElementException();
        Node<T> node = this.head;
        while (node != null) {
            if (node.getData().equals(data)) return (node.getData());
            node = node.getNext();
        }
        return null;
    }

// ====== Produce ========
    public void sortByName() {
        if (isEmpty()) throw new NoSuchElementException();
        Node<T> nodeA;
        Node<T> nodeB;
        T temp;
        nodeA = head;
        while (nodeA != null) {
            nodeB = nodeA.getNext();
            while (nodeB != null) {
                if (((Product) nodeB.getData()).getName().compareTo(((Product) nodeA.getData()).getName()) < 0) {
                    temp = nodeA.getData();
                    nodeA.setData(nodeB.getData());
                    nodeB.setData(temp);
                }
                nodeB = nodeB.getNext();
            }
            nodeA = nodeA.getNext();
        }
    }

    public void removeExpired() {
        if (isEmpty()) throw new NoSuchElementException();
        final int THIS_YEAR = 2021;
        Node<T> removedNode = this.head;
        while (removedNode != null) {
            if ((((Product) removedNode.getData()).getManufacturing() + ((Product) removedNode.getData()).getExpiry()) < THIS_YEAR) {
                removeAt(removedNode.getData());
                System.out.println("Removed 01 element found!");
            }
            removedNode = removedNode.getNext();
        }
    }
}
