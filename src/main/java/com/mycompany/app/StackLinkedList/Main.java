package DataStructures.StackLinkedList;

public class Main {
    public static void main(String[] args) {
        StackLinkedList<String> myStack = new StackLinkedList<>();
        myStack.push("E");
        myStack.push("A");
        myStack.push("S");
        System.out.println(myStack.pop());
        myStack.push("Y");
        System.out.println(myStack.pop());
        myStack.push("Q");
        myStack.push("U");
        myStack.push("E");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push("S");
        myStack.push("T");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push("I");
        System.out.println(myStack.pop());
        myStack.push("O");
        myStack.push("N");
        myStack.traverse();
        System.out.println(myStack.getSize());

        // resutl:
        // Pushed to stack: E
        // Pushed to stack: A
        // Pushed to stack: S
        // S
        // Pushed to stack: Y
        // Y
        // Pushed to stack: Q
        // Pushed to stack: U
        // Pushed to stack: E
        // E
        // U
        // Q
        // Pushed to stack: S
        // Pushed to stack: T
        // T
        // S
        // A
        // Pushed to stack: I
        // I
        // Pushed to stack: O
        // Pushed to stack: N
        // | N | O | E |
        // 3
        
    }
}