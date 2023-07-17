//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        StringBuilder result = new StringBuilder();

        for (char c : A.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                q.add(c);
            }
            while (!q.isEmpty() && map.get(q.peek()) > 1) {
                q.poll();
            }
            if (q.isEmpty()) {
                result.append("#");
            } else {
                result.append(q.peek());
            }
        }

        return result.toString();
    }
}