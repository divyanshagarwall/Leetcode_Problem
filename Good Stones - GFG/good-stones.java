//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static int[] dp;
    public static int goodStones(int n, int[] arr) {
        // code here
        dp = new int[n];
        Arrays.fill(dp,-1);
        
        for(int i=0;i<n;i++)
            numOfWays(i,arr);
        int ans = 0;
        for(int i=0;i<n;i++)
            if(dp[i]>0)
                ans+=dp[i];
        return ans;
    }
    
    static int numOfWays(int curr,int[] arr){
        if(curr<0 || curr>=arr.length) 
            return 1;
        else if(dp[curr]>=0) 
            return dp[curr];
        
        dp[curr]=0;
        dp[curr]+=numOfWays(curr+arr[curr],arr);
        return dp[curr];
    }
}