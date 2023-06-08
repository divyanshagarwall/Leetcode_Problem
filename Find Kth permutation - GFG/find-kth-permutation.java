//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution {
    public static void fact(int n,int a[])
    {
        a[0]=1;
        for(int i=1;i<=n;i++)
        a[i]=a[i-1]*i;
    }
    public static String kthPermutation(int n,int k) {
        // code here
        int fact[]=new int[n+1];
        ArrayList<Integer> adj=new ArrayList<>();
        for(int i=1;i<=n;i++)
        adj.add(i);
        fact(n,fact);
        String s1="";
        k-=1;
        while(n!=0)
        {
            s1+=adj.get(k/fact[n-1]);
            adj.remove(k/fact[n-1]);
            k=k%fact[n-1];
            n--;
        }
        return s1;
    }
}
        


//{ Driver Code Starts.

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
            
            int[] a = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends