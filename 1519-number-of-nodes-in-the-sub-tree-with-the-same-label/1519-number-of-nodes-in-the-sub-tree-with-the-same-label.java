class Solution {
    int[] result;
Set<Integer> visited;
Map<Integer, Set<Integer>> graph;
String labels;
public int[] countSubTrees(int n, int[][] edges, String labels) {
    visited = new HashSet<>();
    this.labels = labels;
    result = new int[n];
    graph = buildGraph(edges);
    findLabels(0);
    return result;
}

private Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] e : edges) {
        int a = e[0];
        int b = e[1];
        addEdge(map, a, b);
        addEdge(map, b, a);
    }
    return map;
}

private void addEdge(Map<Integer, Set<Integer>> map, int a, int b) {
    if (!map.containsKey(a)) {
        map.put(a, new HashSet<>());
    }
    map.get(a).add(b);
}

private int[] findLabels(int root) {
    int[] allLabelsCounter = new int[26];
    if (visited.contains(root)) {
        return allLabelsCounter;
    }
    visited.add(root);
    Set<Integer> neighbors = graph.get(root);
    int labelIndex = labels.charAt(root) - 'a';
    allLabelsCounter[labelIndex]++;
    if (neighbors == null || neighbors.size() == 0) {
        result[root] = allLabelsCounter[labelIndex];
        return allLabelsCounter;
    }
    for (int nbr : neighbors) {
        int[] temp = findLabels(nbr);
        for (int i = 0; i < temp.length; i++) {
            allLabelsCounter[i] += temp[i];
        }
    }
    result[root] = allLabelsCounter[labelIndex];
    return allLabelsCounter;
}
}