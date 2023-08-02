//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int x;
    int y;
    Pair parent;
    
    Pair(int x,int y){
        this.x=x;
        this.y=y;
        
    }
    Pair(){
        
    }
}

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
         if(X>=N || Y>=M )return -1;
        if(A[X][Y]==0)return -1;
        
        
        int vis[][]=new int[N][M]; 
        
        Queue<Pair> q=new LinkedList<Pair>();
        Pair ans=new Pair();
        q.add(new Pair(0,0));
        vis[0][0]=-1;

        while(!q.isEmpty()){
            ans=q.poll();

            if(ans.x==X && ans.y==Y)break;
            
            if(check(A,ans.x+1,ans.y,vis,N,M)){
                Pair temp=new Pair(ans.x+1,ans.y);
                temp.parent=ans;
                q.add(temp);
            }
            
            if(check(A,ans.x-1,ans.y,vis,N,M)){
               Pair temp=new Pair(ans.x-1,ans.y);
                temp.parent=ans;
                q.add(temp);
            }
            
            if(check(A,ans.x,ans.y+1,vis,N,M)){
                Pair temp=new Pair(ans.x,ans.y+1);
                temp.parent=ans;
                q.add(temp);
            }
            if(check(A,ans.x,ans.y-1,vis,N,M)){
                Pair temp=new Pair(ans.x,ans.y-1);
                temp.parent=ans;
                q.add(temp);
            }
        }
        
        int count=0;
        if(ans.x==X && ans.y==Y) {
            while(ans!=null){
                ans=ans.parent;
                count++;
            }return count-1;
        }
        return -1;
    }
    boolean check(int A[][],int i,int j,int vis[][],int N,int M){
        if(i>=N || i<0 || j>=M || j<0 || vis[i][j]==-1 || A[i][j]==0)return false;
        vis[i][j]=-1;
        return true;
    }
};