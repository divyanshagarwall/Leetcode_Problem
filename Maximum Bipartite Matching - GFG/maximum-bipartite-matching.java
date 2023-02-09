//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            out.println(ans);
       }
       out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maximumMatch(int[][] G) {
        int m = G.length;
        int n = G[0].length;
        int[] match = new int[n];
        int result = 0;
        
        Arrays.fill(match, -1);

        for (int u = 0; u < m; u++) {
          boolean[] vis = new boolean[n];
          if (bfs(u, G, match, vis)) result++;
        }
        return result;
    }
    private static boolean bfs(int u, int[][] g, int[] match, boolean[] vis) {
        for (int v = 0; v < g[0].length; v++) {
            if (g[u][v] == 1 && !vis[v]) {
                vis[v] = true;
                if (match[v] == -1 || bfs(match[v], g, match, vis)) {
                  match[v] = u;
                  return true;
                }
            }
        }
        return false;
    }
}