//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int addMinChar(String str){
		//code here
		char Str[] = str.toCharArray();
		int n = Str.length;
		
		int i = 0, j = n-1, ans = n-1;
		while(i<=j){
		    if(Str[i] == Str[j]){
		        i++;
		        j--;
		    } else {
		        ans--;
		        i = 0;
		        j = ans;
		    }
		}
		return n-ans-1;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends