
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /**
     * Calculates the minimum cost to provide library access to all cities.
     *
     * @param n      Number of cities
     * @param c_lib  Cost to build a library in a city
     * @param c_road Cost to repair a road
     * @param cities List of roads connecting cities
     * @return Minimum cost
     */
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // If there are no roads or the cost of building a library is less than or equal to the cost of repairing a road,
        // it is optimal to build a library in each city.
        if (cities == null || cities.isEmpty() || c_lib <= c_road) {
            return (long) n * c_lib;
        }

        // Build an adjacency map to represent the connected cities.
        Map<Integer, Set<Integer>> citiesMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            citiesMap.put(i, new HashSet<Integer>());
        }

        // Populate the adjacency map based on the provided roads.
        for (List<Integer> road : cities) {
            int from = road.get(0);
            int to = road.get(1);

            citiesMap.get(from).add(to);
            citiesMap.get(to).add(from);
        }

        boolean[] visited = new boolean[n + 1];
        long answer = 0;

        // Iterate through each city to perform a breadth-first search (BFS).
        for (int city = 1; city <= n; city++) {
            if (!visited[city]) {
                visited[city] = true;
                int cityNumberOfTown = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(city);

                while (!queue.isEmpty()) {
                    Integer cityFrom = queue.poll();

                    Iterator<Integer> iterator = citiesMap.get(cityFrom).iterator();

                    while (iterator.hasNext()) {
                        int connectedCity = iterator.next();

                        if (!visited[connectedCity]) {
                            queue.add(connectedCity);
                            cityNumberOfTown++;
                            visited[connectedCity] = true;
                        }
                    }
                }

                // Calculate the cost for the current town and add it to the total answer.
                answer += (long) (cityNumberOfTown - 1) * (long) c_road + (long) c_lib;
            }
        }

        return answer;
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
                int c_lib = Integer.parseInt(firstMultipleInput[2]);
                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
