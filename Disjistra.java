
import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * Represents a cost associated with a vertex for the shortest reach problem.
 */
class Cost implements Comparable<Cost> {
    public int cost, vertex;

    public Cost(int cost, int vertex) {
        this.cost = cost;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Cost other) {
        if (cost < other.cost) return -1;
        if (cost > other.cost) return 1;
        if (vertex < other.vertex) return -1;
        if (vertex > other.vertex) return 1;
        return 0;
    }
}

/**
 * Represents the result of the shortestReach function.
 */
class Result {

    /**
     * Finds the shortest reach in a graph from a given source vertex.
     *
     * @param n     Number of vertices
     * @param edges List of edges (connections between vertices)
     * @param s     Source vertex
     * @return List of integers representing the shortest reach to each vertex
     */
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        List<List<Cost>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<Cost>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adjacencyList.get(u).add(new Cost(w, v));
            adjacencyList.get(v).add(new Cost(w, u));
        }

        PriorityQueue<Cost> priorityQueue = new PriorityQueue<>();
        int[] distances = new int[n + 1];

        Arrays.fill(distances, 1000000);
        distances[s] = 0;

        priorityQueue.add(new Cost(0, s));
        while (!priorityQueue.isEmpty()) {
            Cost currentCost = priorityQueue.poll();
            if (distances[currentCost.vertex] < currentCost.cost) {
                continue;
            }

            for (Cost neighbor : adjacencyList.get(currentCost.vertex)) {
                if (distances[neighbor.vertex] > currentCost.cost + neighbor.cost) {
                    distances[neighbor.vertex] = currentCost.cost + neighbor.cost;
                    priorityQueue.add(new Cost(distances[neighbor.vertex], neighbor.vertex));
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                distances[i] = -1;
            }
            if (i != s) {
                result.add(distances[i]);
            }
        }
        return result;
    }
}

/**
 * Main class for reading input and executing the shortestReach function.
 */
public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            if (st == null || !st.hasMoreElements()) {
                do {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } while (st == null || !st.hasMoreElements());
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader(); // Creating the object
        int t1 = in.nextInt(); // Taking input of the number of test cases to be solved
        for (int gj = 0; gj < t1; gj++) { // Taking input of the nodes and edges
            int n = in.nextInt();
            int m = in.nextInt();
            long[][] w = new long[n + 1][n + 1];
            for (long[] row : w)
                Arrays.fill(row, 1000000L);
            IntStream.range(0, m).forEach(i -> {
                int x = in.nextInt(), y = in.nextInt();
                long cmp = in.nextLong();
                if (w[x][y] > cmp) {
                    w[x][y] = cmp;
                    w[y][x] = cmp;
                }
            });
            Stack<Integer> t = new Stack<>();
            int src = in.nextInt();
            for (int i = 1; i <= n; i++) {
                if (i != src) {
                    t.push(i);
                }
            }
            Stack<Integer> p = new Stack<>();
            p.push(src);
            w[src][src] = 0;
            if (!t.isEmpty()) {
                do {
                    int min = 989997979, loc = -1;
                    for (int i = 0; i < t.size(); i++) {
                        w[src][t.elementAt(i)] = Math.min(w[src][t.elementAt(i)], w[src][p.peek()] + w[p.peek()][t.elementAt(i)]);
                        if (w[src][t.elementAt(i)] <= min) {
                            min = (int) w[src][t.elementAt(i)];
                            loc = i;
                        }
                    }
                    p.push(t.elementAt(loc));
                    t.removeElementAt(loc);
                } while (!t.isEmpty());
            }
            int i = 1;
            while (i <= n) {
                if (i != src && w[src][i] != 1000000L) {
                    System.out.print(w[src][i] + " ");
                } else if (i != src) {
                    System.out.print("-1" + " ");
                }
                i++;
            }
            System.out.println();
        }
    }
}
