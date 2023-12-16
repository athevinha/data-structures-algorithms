
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /**
     * Performs Breadth-First Search (BFS) on a graph and calculates the shortest path distances.
     *
     * @param n     Number of nodes in the graph
     * @param m     Number of edges in the graph
     * @param edges List of edges (connections between nodes)
     * @param s     Starting node for BFS
     * @return List of shortest path distances from the starting node to all other nodes
     */
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, n + 1);
        distances[s] = 0;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> neighbors = new ArrayList<>();
            adjList.add(neighbors);
        }

        for (int i = 0; i < m; i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            List<Integer> neighbors = adjList.get(u);

            for (int v : neighbors) {
                if (distances[v] > distances[u] + 1) {
                    distances[v] = distances[u] + 1;
                    queue.add(v);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            if (distances[i] == n + 1) result.add(-1);
            else result.add(distances[i] * 6);
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);
                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
