
import java.io.*;
import java.util.*;

/**
 * Represents a node in an AVL tree.
 */
class AVLNode {
    int value;
    AVLNode left;
    AVLNode right;
    int height = 0;

    AVLNode() {}

    AVLNode(int value) {
        this.value = value;
    }

    AVLNode(int value, AVLNode left, AVLNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

/**
 * Represents an AVL tree.
 */
class AVLTree {
    public AVLNode root;

    /**
     * Gets the height of the given node.
     *
     * @param node The node to get the height of.
     * @return The height of the node.
     */
    private int getHeight(AVLNode node) {
        int left = (node.left == null) ? -1 : node.left.height;
        int right = (node.right == null) ? -1 : node.right.height;
        return Math.max(left, right) + 1;
    }

    /**
     * Gets the balance factor of the given node.
     *
     * @param node The node to get the balance factor of.
     * @return The balance factor of the node.
     */
    public int getBalanceFactor(AVLNode node) {
        if (node == null) {
            return 0;
        }
        int left = (node.left == null) ? -1 : node.left.height;
        int right = (node.right == null) ? -1 : node.right.height;
        return left - right;
    }

    /**
     * Rotates the given node to the left.
     *
     * @param x The node to rotate.
     * @return The rotated node.
     */
    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = getHeight(x);
        y.height = getHeight(y);
        return y;
    }

    /**
     * Rotates the given node to the right.
     *
     * @param x The node to rotate.
     * @return The rotated node.
     */
    private AVLNode rotateRight(AVLNode x) {
        AVLNode y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = getHeight(x);
        y.height = getHeight(y);
        return y;
    }

    /**
     * Inserts a value into the AVL tree.
     *
     * @param value The value to insert.
     */
    public void insert(int value) {
        root = insert(root, value);
    }

    /**
     * Inserts a value into the AVL tree rooted at the given node.
     *
     * @param rootNode The root node of the tree to insert into.
     * @param value     The value to insert.
     * @return The new root node after insertion.
     */
    private AVLNode insert(AVLNode rootNode, int value) {
        if (rootNode == null) {
            return new AVLNode(value);
        }
        if (value > rootNode.value) {
            rootNode.right = insert(rootNode.right, value);
        } else if (value < rootNode.value) {
            rootNode.left = insert(rootNode.left, value);
        } else {
            return rootNode;
        }
        rootNode.height = getHeight(rootNode);
        if (getBalanceFactor(rootNode) > 1) {
            if (getBalanceFactor(rootNode.left) < 0) {
                rootNode.left = rotateLeft(rootNode.left);
            }
            if (getBalanceFactor(rootNode.left) >= 0) {
                rootNode = rotateRight(rootNode);
            }
        } else if (getBalanceFactor(rootNode) < -1) {
            if (getBalanceFactor(rootNode.right) > 0) {
                rootNode.right = rotateRight(rootNode.right);
            }
            if (getBalanceFactor(rootNode.right) <= 0) {
                rootNode = rotateLeft(rootNode);
            }
        }
        return rootNode;
    }

    /**
     * Performs an inorder traversal of the AVL tree rooted at the given node.
     *
     * @param rootNode The root node of the tree to traverse.
     */
    public void inorder(AVLNode rootNode) {
        if (rootNode == null) return;
        inorder(rootNode.left);
        System.out.print(rootNode.value + "(BF=" + getBalanceFactor(rootNode) + ") ");
        inorder(rootNode.right);
    }

    /**
     * Performs a preorder traversal of the AVL tree rooted at the given node.
     *
     * @param rootNode The root node of the tree to traverse.
     */
    public void preorder(AVLNode rootNode) {
        if (rootNode == null) return;
        System.out.print(rootNode.value + "(BF=" + getBalanceFactor(rootNode) + ") ");
        preorder(rootNode.left);
        preorder(rootNode.right);
    }
}

/**
 * Main class for the AVL tree solution.
 */
public class AVLTreeSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfNodes = scanner.nextInt();
        AVLTree tree = new AVLTree();
        for (int i = 0; i < numberOfNodes; i++) {
            tree.insert(scanner.nextInt());
        }
        tree.insert(scanner.nextInt());
        tree.inorder(tree.root);
        System.out.println();
        tree.preorder(tree.root);
    }
}
