//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int maxSweetness(int [] sweetness, int N, int K) {
	    // Write your code here.
	int left = 1; // Minimum possible sweetness of a piece
    int right = Arrays.stream(sweetness).sum(); // Maximum possible sweetness of a piece
    while (left < right) {
        int mid = (left + right + 1) / 2; // Midpoint of the sweetness range
        int pieces = 0; // Number of pieces that can be formed with the current sweetness
        int currentSweetness = 0; // Sweetness of the current piece being formed
        for (int s : sweetness) {
            currentSweetness += s;
            if (currentSweetness >= mid) {
                pieces++;
                currentSweetness = 0;
            }
        }
        if (pieces > K) {
            // If we can form more pieces than allowed, sweetness should be increased
            left = mid;
        } else {
            // If we can form fewer pieces than allowed, sweetness should be decreased
            right = mid - 1;
        }
    }
    return left;

	}
}