class Solution {
    ArrayList<ArrayList<Integer>> adj;
    int n;
    int ans = 1;

    public int longestPath(int[] parent, String s) {
        adj = new ArrayList<>();
        n = parent.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                adj.get(i).add(parent[i]);
                adj.get(parent[i]).add(i);
            }
        }
        int l = go(0, -1, s);
        return ans;

    }

    private int go(int i, int par, String s) {
        int max = 0, secMax = 0;
        for (Integer it : adj.get(i)) {
            if (it != par) {
                int l = go(it, i, s);
                if (s.charAt(i) != s.charAt(it)) {
                    ans = Math.max(ans, l + 1);
                    if (l > max) {
                        secMax = max;
                        max = l;
                    } else if (l > secMax) {
                        secMax = l;
                    }
                }
            }
        }
        ans = Math.max(max + secMax + 1, ans);
        return max + 1;
    }
}