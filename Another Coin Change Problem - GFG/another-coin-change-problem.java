//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());

            int K;
            K = Integer.parseInt(br.readLine());

            int target;
            target = Integer.parseInt(br.readLine());

            int[] coins = IntArray.input(br, N);

            Solution obj = new Solution();
            boolean res = obj.makeChanges(N, K, target, coins);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makeChanges(int n, int k, int t, int[] coins) {
        // code here
        int dp[][] = new int[k+1][t+1];
        for(int []r: dp) Arrays.fill(r, -1);
      return solve(0, k, t, coins, dp);
    }
    public static boolean solve(int i, int k, int t, int[] coins, int dp[][]) {
      if(i == coins.length){
          if(k == 0 && t == 0) return true;
          else return false;
      }
      if(dp[k][t] != -1) return dp[k][t] == 1;
      boolean take = false, notTake = false;
      
      if(t>=coins[i] && k>0){
          take = solve(i, k-1, t-coins[i], coins, dp);
      }
          notTake = solve(i+1, k, t, coins, dp);
          if(take || notTake) dp[k][t] = 1;
          else dp[k][t] = 0;
        return take || notTake;

    }
}
