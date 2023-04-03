//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
  
            String x = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.xmod11(x)); 

            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int xmod11(String x)
	{    
	    // code here
	    int i=0, evenSum = 0 , oddSum = 0;
	    for(char ch : x.toCharArray()){
	        int digit = ch - '0';
	        if(i++ % 2 == 0)    evenSum += digit;
	        else    oddSum += digit;
	    }
	    int diff = oddSum - evenSum;
	    return diff % 11 < 0 ? diff % 11 + 11 : diff % 11;
        
	}
} 

