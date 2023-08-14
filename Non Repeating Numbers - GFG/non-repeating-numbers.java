//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
         HashMap <Integer,Integer> map = new HashMap<>();
        int ans[] = new int[2];
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
            } else {
                map.put(nums[i],1);
            }
        }
        int k =0;
        for (int i : map.keySet()){
            ans[k] = i; k++;
        }
        if(ans[0] > ans[1]){
            int temp = ans[0];
            ans[0] = ans[1];
            ans[1] = temp;
        }
        return ans;
    }
}