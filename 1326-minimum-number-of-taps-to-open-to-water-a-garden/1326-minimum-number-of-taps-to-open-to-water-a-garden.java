class Solution {
    public int minTaps(int n, int[] ranges) {
        final int INF = (int) 1e9;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for (int i = 0; i <= n; i++) {
            int tapStart = Math.max(0, i - ranges[i]);
            int tapEnd = Math.min(n, i + ranges[i]);
            
            for (int j = tapStart; j <= tapEnd; j++) {
                dp[tapEnd] = Math.min(dp[tapEnd], dp[j] + 1);
            }
        }
        if (dp[n] == INF) {
            return -1;
        }
        return dp[n];
    }
}