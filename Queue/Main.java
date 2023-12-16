package DataStructures.Queue;

public class Main {
    public static void main(String[] args) {
        QueueLinkedList<Integer> myQueue = new QueueLinkedList<>();
        myQueue.traverse();
        myQueue.add(5); myQueue.traverse();
        myQueue.add(3); myQueue.traverse();
        myQueue.remove(); myQueue.traverse();
        myQueue.add(2); myQueue.traverse();
        myQueue.add(8); myQueue.traverse();
        myQueue.remove(); myQueue.traverse();
        myQueue.add(9); myQueue.traverse();
        myQueue.add(1); myQueue.traverse();
        myQueue.remove(); myQueue.traverse();
        myQueue.add(7); myQueue.traverse();
        myQueue.add(6); myQueue.traverse();
        myQueue.remove(); myQueue.traverse();
        myQueue.remove(); myQueue.traverse();
        myQueue.add(4); myQueue.traverse();
        myQueue.remove(); myQueue.traverse();
        myQueue.remove(); myQueue.traverse();

        // Output:
        // Added 5, Front = 5, Rear = 5, Size = 1
        // | 5 | 
        // Added 3, Front = 5, Rear = 3, Size = 2
        // | 5 | 3 |
        // Removed 5, Front = 3, Rear = 3, Size = 1
        // | 3 |
        // Added 2, Front = 3, Rear = 2, Size = 2
        // | 3 | 2 |
        // Added 8, Front = 3, Rear = 8, Size = 3
        // | 3 | 2 | 8 |
        // Removed 3, Front = 2, Rear = 8, Size = 2
        // | 2 | 8 |
        // Added 9, Front = 2, Rear = 9, Size = 3
        // | 2 | 8 | 9 |
        // Added 1, Front = 2, Rear = 1, Size = 4
        // | 2 | 8 | 9 | 1 |
        // Removed 2, Front = 8, Rear = 1, Size = 3
        // | 8 | 9 | 1 |
        // Added 7, Front = 8, Rear = 7, Size = 4
        // | 8 | 9 | 1 | 7 |
        // Added 6, Front = 8, Rear = 6, Size = 5
        // | 8 | 9 | 1 | 7 | 6 |
        // Removed 8, Front = 9, Rear = 6, Size = 4
        // | 9 | 1 | 7 | 6 |
        // Removed 9, Front = 1, Rear = 6, Size = 3
        // | 1 | 7 | 6 |
        // Added 4, Front = 1, Rear = 4, Size = 4
        // | 1 | 7 | 6 | 4 |
        // Removed 1, Front = 7, Rear = 4, Size = 3
        // | 7 | 6 | 4 |
        // Removed 7, Front = 6, Rear = 4, Size = 2
        // | 6 | 4 |
    }
}