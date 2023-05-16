//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String s = read.readLine();
            Solution ob = new Solution();
            
            System.out.println(ob.cuts(s));
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int cuts(String s)
    {
        // code here
        int n=s.length();
        Set<Long>set=new HashSet<>();
        long in=1;
        for(int i=1;i<51 && in>0;i++)
        {
            set.add(in);
            in*=5;
        }
        int[]arr=new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            int min=Integer.MAX_VALUE;
            if(s.charAt(i)=='0')
            {
                arr[i]=-1;
                continue;
            }
            long curr=0;
            for(int j=i;j<n;j++)
            {
                curr=(curr<<1)+(s.charAt(j)-'0');
                if(!set.contains(curr) || arr[j+1]==-1) continue;
                min=Math.min(min,1+arr[j+1]);
            }
            arr[i]=min==Integer.MAX_VALUE?-1:min;
        }
        return arr[0];
    }
}
