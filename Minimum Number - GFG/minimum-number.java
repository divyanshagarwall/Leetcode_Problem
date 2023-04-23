//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimumNumber(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumNumber(int n, int[] arr) {
        // code here
        int z=0;
       for(int i=0;i<n-1;i++){
         if(arr[z]>0 &&arr[i+1]>0){
           if(arr[z]>=arr[i+1]){
               arr[z]=arr[z]%arr[i+1];
               if(arr[z]==1) return(1);
               if(arr[z]!=0) arr[i+1]=arr[i+1]%arr[z];
               else z=i+1;
               if(arr[i+1]==1) return(1);
           }
           else{
               arr[i+1]=arr[i+1]%arr[z];
               if(arr[i+1]==1) return(1);
               if(arr[i+1]!=0) arr[z]=arr[z]%arr[i+1];
               if(arr[z]==0) z=i+1;
               if(arr[z]==1) return(1);
       }
         }
       else{
           if(arr[z]<=0) z=i+1;
       }
    }
    int max=0;
    for(int i=0;i<n;i++){
        if(max<arr[i]) max=arr[i];
    }
    return max;
    }
}
        
