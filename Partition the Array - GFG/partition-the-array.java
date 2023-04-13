//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.minDifference(N, A); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long minDifference(int N, int A[]) 
    { 
        // code here
        long[] prefixSums = new long[N + 1];
        prefixSums[0] = 0;
        for (int i = 1; i <= N; i++) {
            prefixSums[i] = prefixSums[i - 1] + A[i - 1];
        }
        long smallestDifference = prefixSums[N];
        for (int i = 1; i < N - 2; i++) {
            MinMaxPair leftMinMax = getMinMaxSums(prefixSums, 1, i + 1);
            MinMaxPair rightMinMax = getMinMaxSums(prefixSums, i + 2, N);
            long maxSumPQ = leftMinMax.maxSum;
            long maxSumRS = rightMinMax.maxSum;
            long minSumPQ = leftMinMax.minSum;
            long minSumRS = rightMinMax.minSum;
            long absoluteDifference = Math.abs(Math.max(maxSumPQ, maxSumRS) - Math.min(minSumPQ, minSumRS));
            smallestDifference = Math.min(smallestDifference, absoluteDifference);
        }
        return smallestDifference;
    }
     static class MinMaxPair {
        long minSum, maxSum;
        public MinMaxPair(long minSum, long maxSum) {
            this.minSum = minSum;
            this.maxSum = maxSum;
        }
    }
    static MinMaxPair getMinMaxSums(long[] prefixSums, int left, int right) {
        int lo = left, hi = right - 1;
        long minSum = 0, maxSum = prefixSums[right] - prefixSums[left - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long leftSum = prefixSums[mid] - prefixSums[left - 1];
            long rightSum = prefixSums[right] - prefixSums[mid];
            if (Math.abs(rightSum - leftSum) < maxSum - minSum) {
                minSum = Math.min(leftSum, rightSum);
                maxSum = Math.max(leftSum, rightSum);
            }
            if (leftSum < rightSum) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return new MinMaxPair(minSum, maxSum);
    }
} 