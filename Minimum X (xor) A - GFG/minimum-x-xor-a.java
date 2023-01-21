//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static int countSetBits(int x)
    {
        int ans = 0;
        while(x>0)
        {
            if(x%2==1) ans++;
            x = x/2;
        }
        return ans;
    }
    private static int setBitAtPos(int x, int pos)
    {
        return x | (1<<pos);
    }
    public static int minVal(int a, int b) {
        int count = countSetBits(b);
        int x = 0;
        for(int i=31; i>=0; i--)
        {
            if(count==0) break;
            if(((a&(1<<i)) != 0) && count>0)
            {
                x = setBitAtPos(x, i);
                count--;
            }
        }
        if(count==0) return x;
        for(int i=0; i<31; i++)
        {
            if(((a&(1<<i))==0) && count>0)
            {
                x = setBitAtPos(x, i);
                count--;
            }
        }
        return x;
    }
}