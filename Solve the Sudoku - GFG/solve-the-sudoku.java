//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static boolean isSafe(int row, int col, int num, int [][] grid){
        int N = grid.length;
        for(int i=0; i<N; i++){
            if(grid[row][i] == num) return false;
            if(grid[i][col] == num) return false;
        }
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        for(int i= sr; i< sr+3; i++){
            for(int j=sc; j< sc+3; j++){
                if(grid[i][j] == num) return false;
            }
        }
        return true;
    }
    public static boolean solve(int row, int col, int [][] grid){
        int N = grid.length;
        if(row == N) return true;
        int NRow=0, NCol=0;
        if(col != N-1) {
            NRow = row;
            NCol = col + 1;
        }else {
            NRow = row + 1;
            NCol = 0;
        }
        if(grid[row][col] == 0){
            for(int num=1; num<=9; num++){
                if(isSafe(row, col, num, grid)){
                    grid[row][col] = num;
                    if(solve(NRow, NCol, grid)) return true;
                    grid[row][col] = 0;
                }
            }
        }else {
            if(solve(NRow, NCol, grid)) return true;
        }
        return false;
    }
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        int n = grid.length, m = grid[0].length;
        return solve(0, 0, grid);
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        int n = grid.length, m= grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) System.out.print(grid[i][j]+" ");
        }
    }
}