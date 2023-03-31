//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] lexicographicallyLargest(int [] arr, int n) {
		//Write your code here
		if(n==1){
            return arr;
        }
        boolean condition =  true;
        while(condition){
            condition = false;
            for(int i = 0 ; i < n -1 ; i++){
                if((arr[i] + arr[i+1])%2 == 0 && arr[i+1] > arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1]= temp;
                    condition = true;
                }
            }
            
            
        }
        return arr;
	}
}