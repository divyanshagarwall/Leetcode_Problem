//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int a[], int n) {
        // Your code goes here
        int maxCount=0;
        int count = 0;
        int countOne = 0;
        for(int i=0;i<n;i++){
            if(a[i]==1){
                countOne++; //count number of 1's
            }
            if(a[i]==0){ 
                count++; //count of flips required
            }else{
                count--; //if element is 1 then it should be zero and not to be counted in the flip's count or in the result
            }
            if(count>0 && count > maxCount){
                maxCount = count;//update if count is maximum
            }else if(count<0){
                count = 0;// if negative count then discard
            }
        }
        return maxCount + countOne;
    }
}
