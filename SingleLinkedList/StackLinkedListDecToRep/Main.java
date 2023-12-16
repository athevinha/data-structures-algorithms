package DataStructures.StackLinkedListDecToRep;

public class Main {
    public static void main(String[] args) {
        StackLinkedList<String> myStack = new StackLinkedList<>();
        System.out.println("Is empty: " + myStack.isEmpty());
        myStack.push("K");
        myStack.push("C");
        myStack.push("A");
        myStack.push("T");
        myStack.push("S");
        myStack.traverse();
        System.out.println("Top = " + myStack.peek());
        System.out.println("Size = " + myStack.getSize());
        System.out.println("Poped " + myStack.pop());
        System.out.println("Size = " + myStack.getSize());
        myStack.traverse();
        myStack.clear();
        System.out.println("Is empty: " + myStack.isEmpty());

        // Output:
        // Is empty: true
        // | S | T | A | C | K |
        // Top = S
        // Size = 5
        // Poped S
        // Size = 4
        // | T | A | C | K |
        // Is empty: true

        decToRep(255, 2);
        decToRep(4096, 2);
        // Output:
        // | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
        // | 1 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |

        decToRep(512, 8);
        decToRep(511, 8);
        // Output:
        // | 1 | 0 | 0 | 0 |
        // | 7 | 7 | 7 |
    }

    public static void decToRep(int decimalCode, int rep) {
        if (decimalCode <= 0) return;
        StackLinkedList<Integer> mytack = new StackLinkedList<>();
        while (decimalCode > 0) {
            Integer binOctCode = Integer.valueOf(decimalCode % rep);
            mytack.push(binOctCode);
            decimalCode /= rep;
        }
        mytack.traverse();
    }
}