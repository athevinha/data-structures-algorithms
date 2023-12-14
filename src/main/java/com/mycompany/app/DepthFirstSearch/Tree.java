package DataStructures.DepthFirstSearch;

public class Tree {
    private TreeNode root;
    private int size;

    public Tree() {
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int data) {
        this.root = addRecursive(this.root, data);
        if (this.root != null) size++;
    }

    private TreeNode addRecursive(TreeNode currNode, int data) {
        if (currNode == null) return new TreeNode(data);
        if (data < currNode.getData())
            currNode.setLeft(addRecursive(currNode.getLeft(), data));
        else if (data > currNode.getData())
            currNode.setRight(addRecursive(currNode.getRight(), data));
        else { 
            System.out.println("Error: Value " + data + " is already exists!");
            return null;
        }
        return currNode;
    }

    public void delete(int data) { 
        this.root = deleteRecursive(this.root, data);
        this.size--;
    }
   
    private TreeNode deleteRecursive(TreeNode currNode, int data)  { 
        if (currNode == null) {
            this.size++; //offset delete() failed
            return currNode;
        } 
        if (data < currNode.getData())
            currNode.setLeft(deleteRecursive(currNode.getLeft(), data));
        else if (data > currNode.getData())
            currNode.setRight(deleteRecursive(currNode.getRight(), data)); 
        else  { 
            if (currNode.getLeft() == null) 
                return currNode.getRight(); 
            else if (currNode.getRight() == null) 
                return currNode.getLeft(); 
            currNode.setData(minValue(currNode.getRight())); 
            currNode.setRight(deleteRecursive(currNode.getRight(), currNode.getData())); 
        } 
        return currNode; 
    } 
   
    private int minValue(TreeNode currNode) {
        int minVal = currNode.getData(); 
        while (currNode.getLeft() != null)  { 
            minVal = currNode.getLeft().getData();
            currNode = currNode.getLeft(); 
        } 
        return minVal; 
    }

    public boolean search(int data)  { 
        TreeNode currNode = search_Recursive(this.root, data); 
        return currNode != null;
    }

    private TreeNode search_Recursive(TreeNode currNode, int data)  {
        if (currNode == null || currNode.getData() == data) 
            return currNode;
        if (currNode.getData() > data) 
            return search_Recursive(currNode.getLeft(), data); 
        return search_Recursive(currNode.getRight(), data); 
    } 

    public void traverseInOrder() {
        traverseInOrderRecursive(this.root);
    }

    public void traversePreOrder() {
        traversePreOrderRecursive(this.root);
    }

    public void traversePostOrder() {
        traversePostOrderRecursive(this.root);
    }

    private void traverseInOrderRecursive(TreeNode currNode) {
        if (currNode != null) {
            traverseInOrderRecursive(currNode.getLeft());
            System.out.print(currNode.getData() + " ");
            traverseInOrderRecursive(currNode.getRight());
        }
    }

    private void traversePreOrderRecursive(TreeNode currNode) {
        if (currNode != null) {
            System.out.print(currNode.getData() + " ");
            traversePreOrderRecursive(currNode.getLeft());
            traversePreOrderRecursive(currNode.getRight());
        }
    }

    private void traversePostOrderRecursive(TreeNode currNode) {
        if (currNode != null) {
            traversePostOrderRecursive(currNode.getLeft());
            traversePostOrderRecursive(currNode.getRight());
            System.out.print(currNode.getData() + " ");
        }
    }

    // ========= PRINT LEVEL ORDER BY QUEUE ============
    public void traverseLevelOrder() {
        QueueLinkedList<TreeNode> myQueue = new QueueLinkedList<>();
        myQueue.add(this.root);
        while (!myQueue.isEmpty()){
            TreeNode tempNode = myQueue.poll();
            System.out.print(tempNode.getData() + " ");
            if (tempNode.getLeft() != null) myQueue.add(tempNode.getLeft());
            if (tempNode.getRight() != null) myQueue.add(tempNode.getRight());
        }
    }

    // ========= PRINT LEVEL ORDER BY RECURSIVE ============
    public void traverseLevelOrderRecursion() {
        final int height = findHeight(this.root);
        for (int level = 1; level <= height; level++)
            printCurrLevel(this.root, level);
    }
 
    private int findHeight(TreeNode currNode) {
        if (currNode == null) return 0;
        int leftHeight = findHeight(currNode.getLeft());
        int rightHeight = findHeight(currNode.getRight());
        if (leftHeight > rightHeight) return (leftHeight + 1);
        return (rightHeight + 1);
    }
 
    private void printCurrLevel(TreeNode currNode, int level) {
        if (currNode == null) return;
        if (level == 1) System.out.print(currNode.getData() + " ");
        else if (level > 1) {
            printCurrLevel(currNode.getLeft(), level-1);
            printCurrLevel(currNode.getRight(), level-1);
        }
    }
}   
