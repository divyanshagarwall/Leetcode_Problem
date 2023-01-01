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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.compute_value(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int m = (int)1e9 + 7;
    private long f(long a, long b) {
        a %= m;
        long ans = 1;
        while(b > 0) {
            if((b & 1) != 0)
                ans = ans * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return ans;
    }
    
    private long rev(long n) {
        return f(n, m-2);
    }
    
    public int compute_value(int n) {
        long ans = 1, num = 1, den = 1;
        int cur = n;
        for(int i = 1, j = n; i <= n; i++, j--) {
            num = (num * j) % m;
            den = (den * i) % m;
            
            long t = (num * rev(den)) % m;
            t = f(t, 2);
            ans = (ans + t) % m;
        }
        return (int)ans;
    }
}