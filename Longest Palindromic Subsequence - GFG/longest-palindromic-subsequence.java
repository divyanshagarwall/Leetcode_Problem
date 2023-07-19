//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        String rev = helper(S);
        int m = rev.length();
        int dp[][] = new int[m+1][m+1];
        
        for(int i = 0; i<=m; i++)
            for(int j = 0; j<=m; j++){
                if(i == 0)
                    dp[i][j] = 0;
                else if(j == 0)
                    dp[i][j] = 0;
                else if(S.charAt(i-1) == rev.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); 
            }
        
        return dp[rev.length()][rev.length()];
    }
    
    public static String helper(String s){
        String rev = "";
        
        for(int i = s.length()-1; i>=0; i--)
            rev += s.charAt(i);
            
        return rev;
    }
}