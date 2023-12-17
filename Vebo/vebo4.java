import java.util.*;

/**
 * The Solution class represents a solution for a specific problem using a segment tree.
 */
public class Solution {
    static int[] a = new int[300001];
    static int[] t = new int[300001 * 4];

    /**
     * The main method that reads input from STDIN, processes it, and prints the output to STDOUT.
     *
     * @param args Command-line arguments (not used in this case).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        build(1, n, 1);
        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            int m = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(get(1, n, 1, m, k));
        }
    }
    
    /**
     * Builds the segment tree.
     *
     * @param l  The left index of the current segment.
     * @param r  The right index of the current segment.
     * @param id The current node in the segment tree.
     */
    public static void build(int l, int r, int id) {
        if (l == r) {
            t[id] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, 2 * id);
        build(mid + 1, r, 2 * id + 1);
        t[id] = Math.max(t[2 * id], t[2 * id + 1]);
    }

    /**
     * Gets the maximum value in a given range.
     *
     * @param l The left index of the current segment.
     * @param r The right index of the current segment.
     * @param id The current node in the segment tree.
     * @param u The left index of the query range.
     * @param v The right index of the query range.
     * @return The maximum value in the specified range.
     */
    public static int get(int l, int r, int id, int u, int v) {
        if (v < l || r < u) return Integer.MIN_VALUE;
        if (u <= l && r <= v) return t[id];
        int mid = (l + r) / 2;
        int left = get(l, mid, 2 * id, u, v);
        int right = get(mid + 1, r, 2 * id + 1, u, v);
        return Math.max(left, right);
    }

}
