package DataStructures.DepthFirstSearch;

public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;
    
    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode data(int data) {
        setData(data);
        return this;
    }

    public TreeNode left(TreeNode left) {
        setLeft(left);
        return this;
    }

    public TreeNode right(TreeNode right) {
        setRight(right);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " data='" + getData() + "'" +
            ", left='" + getLeft() + "'" +
            ", right='" + getRight() + "'" +
            "}";
    }
}
