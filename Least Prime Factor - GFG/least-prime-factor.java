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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.leastPrimeFactor(n);
            for(int i = 1; i <=n; i++)
            {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] leastPrimeFactor(int n)
    {
        // code here
        int[]arr=new int[n+1];
        arr[0]=0;
        if(n>1)
        {
        arr[1]=1;
       // return arr;
        }
        for(int i=2;i<=n;i++)
        {
            int ans=findPrime(i);
            arr[i]=ans;
        }
        return arr;
    }
    public int findPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            return i;
        }
        return n;
    }
}