static int maxx = 0;
    static int[] arr = new int[25];

    public static int height(Node root) {
        // Reset global variables for each function call
        maxx = 0;
        arr = new int[25];

        // Use BFS to traverse the tree and calculate depths
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            // Enqueue left child
            if (tmp.left != null) {
                q.add(tmp.left);
                arr[tmp.left.data] = arr[tmp.data] + 1;
                maxx = Math.max(maxx, arr[tmp.left.data]);
            }

            // Enqueue right child
            if (tmp.right != null) {
                q.add(tmp.right);
                arr[tmp.right.data] = arr[tmp.data] + 1;
                maxx = Math.max(maxx, arr[tmp.right.data]);
            }
        }

        // Return the maximum depth encountered during traversal
        return maxx;
    }