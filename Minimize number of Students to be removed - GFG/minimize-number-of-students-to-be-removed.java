//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int N) {
        // code here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0, H[0]);
        int j = 0;
        for (int i = 1; i < N; i++)
        {
            if (H[i] > arr.get(j))
            {
                ++j;
                arr.add(j, H[i]);
            }
            else
            {
                int index = lowerBound(arr, H[i]);
                arr.set(index, H[i]);
            }
        }
        
        return N-arr.size();
    }
    
    public int lowerBound(ArrayList<Integer> arr, int key)
    {
        int low = 0, high = arr.size();
        int mid;
    
        while (low < high)
        {
            mid = low + (high-low)/2;
            
            if (key <= arr.get(mid))
                high = mid;
            else
                low = mid+1;
            
        }
        
        // Key does not exist
        if (low < arr.size() && arr.get(low) < key)
            low++;
            
        return low;
    }
}