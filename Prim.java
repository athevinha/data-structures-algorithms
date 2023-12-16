
import java.io.*;
import java.util.*;
import java.util.stream.*;

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

class Result {

    /**
     * Performs Prim's algorithm to find the minimum spanning tree in a graph.
     *
     * @param numVertices Number of vertices
     * @param edges       List of edges (connections between vertices)
     * @param startVertex Starting vertex for the algorithm
     * @return Minimum spanning tree's total cost
     */
    public static int prims(int numVertices, List<List<Integer>> edges, int startVertex) {
        List<List<Cost>> adjacencyList = new ArrayList<>();
        boolean[] visitedVertices = new boolean[numVertices + 1];

        for (int i = 0; i <= numVertices; i++) {
            adjacencyList.add(new ArrayList<Cost>());
        }

        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            adjacencyList.get(from).add(new Cost(edge.get(2), to));
            adjacencyList.get(to).add(new Cost(edge.get(2), from));
        }

        int totalCost = 0;
        PriorityQueue<Cost> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Cost(0, startVertex));

        while (!priorityQueue.isEmpty()) {
            Cost currentVertex = priorityQueue.peek();
            priorityQueue.poll();

            if (visitedVertices[currentVertex.vertex]) continue;
            visitedVertices[currentVertex.vertex] = true;
            totalCost += currentVertex.cost;

            for (int i = 0; i < adjacencyList.get(currentVertex.vertex).size(); i++) {
                Cost adjacentVertex = adjacencyList.get(currentVertex.vertex).get(i);
                if (!visitedVertices[adjacentVertex.vertex]) {
                    priorityQueue.add(adjacentVertex);
                }
            }
        }

        return totalCost;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int numVertices = Integer.parseInt(firstMultipleInput[0]);
        int numEdges = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, numEdges).forEach(i -> {
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

        int startVertex = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(numVertices, edges, startVertex);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
