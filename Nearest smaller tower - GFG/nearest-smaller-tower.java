//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
		//Write your code here
		int[] ans = new int[arr.length];
	    int[] right=right(arr);
	    int[] left=left(arr);
	     
	    for(int i=0;i<arr.length;i++){
	        if(right[i]==-1 && left[i]==-1) ans[i]=-1;
	        
	        else if(right[i]==-1) ans[i]=left[i];
	        
	        else if(left[i]==-1)ans[i]=right[i];
	        
	        else{
	        
    	        int x = Math.abs(i-right[i]);
    	        int y = Math.abs(i-left[i]);
    	         
    	        if(x<y)ans[i]=right[i];
    	        
    	       else if(x>y)ans[i]=left[i];
    	        else{
    	          if(arr[left[i]]<arr[right[i]])  ans[i]=left[i];
    	          else if(arr[left[i]]>arr[right[i]]) ans[i]=right[i];
    	          else {
    	              if(left[i]<right[i])ans[i]=left[i];
    	              else ans[i]=right[i];
    	          }
    	        }
	        }    
	    }
	  return ans;
	}
	int[] right(int[] arr){
	    int[] right = new int[arr.length];
	    Stack<Integer> st = new Stack<>();
	    for(int i=arr.length-1;i>=0;i--){
	        while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
	        right[i]= st.isEmpty()? -1:st.peek();
	        st.push(i);
	      }
	   return right ;
	}
	
		int[] left(int[] arr){
	    int[] left = new int[arr.length];
	    Stack<Integer> st = new Stack<>();
	    for(int i=0;i<arr.length;i++){
	        while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
	        left[i]= st.isEmpty()? -1:st.peek();
	        st.push(i);
	      }
	   return left ;
	}
}