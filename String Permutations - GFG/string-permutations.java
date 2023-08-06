//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    ArrayList<String> list = new ArrayList<>();
    
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        totalpermutations(S, "");
        Collections.sort(list);
        return list;
 
    }
 
    public void totalpermutations(String s, String asof) {
 
        if (s.length() == 0) {
            list.add(asof);
            return;
        }
 
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i+1);
            String ans = left + right;
 
            totalpermutations(ans, asof + ch);
 
 
        }
    }
	   
}
