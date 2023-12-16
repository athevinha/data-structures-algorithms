package DataStructures.DepthFirstSearch;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(3);
        tree.add(7);
        tree.add(6);
        tree.add(8);
        System.out.println("leaves = " + tree.getSize());
        tree.traverseLevelOrder();
        System.out.println(" ");
        tree.traverseLevelOrderRecursion();

        // Output
        // leaves = 7
        // 5 2 7 1 3 6 8
        // 5 2 7 1 3 6 8
    }
}
