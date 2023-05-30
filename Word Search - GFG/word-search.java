//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int x = board.length;
        int y = board[0].length;
        boolean[][] visited = new boolean[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(helperDFS(board, word, 0, i, j, visited)) return true;
            }
        }
        
        return false;
    }
    
    boolean helperDFS(char[][] board, String word, int curr, int x, int y, boolean[][] visited) {
        if(x >= board.length || y >= board[0].length || x < 0 || y < 0) return false; 
        if(curr >= word.length() || board[x][y] != word.charAt(curr) || visited[x][y]) return false;
        if(curr == word.length()-1) return true;
        
        visited[x][y] = true;
        
        boolean a1 = helperDFS(board, word, curr+1, x+1, y, visited);
        boolean a2 = helperDFS(board, word, curr+1, x, y+1, visited);
        boolean a3 = helperDFS(board, word, curr+1, x-1, y, visited);
        boolean a4 = helperDFS(board, word, curr+1, x, y-1, visited);
        
        visited[x][y] = false;
        
        if(a1 || a2 || a3 || a4) return true;
        return false;
    }
}