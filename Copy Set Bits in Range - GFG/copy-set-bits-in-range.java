//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line[] = in.readLine().trim().split("\\s+");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int l = Integer.parseInt(line[2]);
            int r = Integer.parseInt(line[3]);
            
            Solution ob = new Solution();
            System.out.println(ob.setSetBit(x, y, l, r));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int setSetBit(int x, int y, int l, int r) {
        List<Integer> position = new ArrayList<>();
        int cnt = 1;
        
        while (y != 0) {
            if (cnt >= l && cnt <= r) {
                if ((y & 1) != 0) {
                    position.add(cnt - 1); // 0 based indexing
                }
            }
            
            cnt++;
            y >>= 1;
        }
        
        for (int i = 0; i < position.size(); i++) {
            int shift = position.get(i);
            int num = (1 << shift);
            x |= num;
        }
        
        return x;
    }
}