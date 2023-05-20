public class Solution {

    private static final int NOT_POSSIBLE = -1;
    private static record Pair(String ID, double value) {}
    private Map<String, List<Pair>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values);
        double[] equationResult = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            equationResult[i] = breadthFirstSearch(queries.get(i).get(0), queries.get(i).get(1));
        }
        return equationResult;
    }

    private double breadthFirstSearch(String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return NOT_POSSIBLE;
        }
        if (start.equals(end)) {
            return 1;
        }

        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Pair(start, 1));
        visited.add(start);

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();
            if (!graph.containsKey(pair.ID)) {
                continue;
            }

            List<Pair> neighbours = graph.get(pair.ID);
            for (int i = 0; i < neighbours.size(); ++i) {
                if (visited.add(neighbours.get(i).ID)) {
                    if (neighbours.get(i).ID.equals(end)) {
                        return pair.value * neighbours.get(i).value;
                    }
                    queue.add(new Pair(neighbours.get(i).ID, (pair.value * neighbours.get(i).value)));
                }
            }
        }
        return NOT_POSSIBLE;
    }

    private void buildGraph(List<List<String>> equations, double[] values) {
        graph = new HashMap<>();
        final int size = equations.size();

        for (int i = 0; i < size; ++i) {
            String ID_first = equations.get(i).get(0);
            String ID_second = equations.get(i).get(1);
            graph.computeIfAbsent(ID_first, pair -> new ArrayList<>()).add(new Pair(ID_second, values[i]));
            graph.computeIfAbsent(ID_second, pair -> new ArrayList<>()).add(new Pair(ID_first, (1 / values[i])));
        }
    }
}