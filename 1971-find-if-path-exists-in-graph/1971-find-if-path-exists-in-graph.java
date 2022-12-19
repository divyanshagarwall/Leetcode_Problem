import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        q.add(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            vis.add(u);
            if (u == end) return true;
            for (int v : adj.get(u)) {
                if (!vis.contains(v)) {
                    q.add(v);
                }
            }
        }
        return false;
    }
}