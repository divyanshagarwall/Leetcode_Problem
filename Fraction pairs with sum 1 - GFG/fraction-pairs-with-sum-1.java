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
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
     public static int gcd(int a , int b){
        if(b==0){
            return a;
        }
        
        else return gcd(b,a%b);
    }
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        // code here
        int [] frac = new int[n];
        HashMap<Integer,HashMap<Integer,Integer>> hasMap = new HashMap<>();
          int count = 0;
        for(int i=0;i<n;i++){
            int fraction = gcd(numerator[i], denominator[i]);
            int x = numerator[i]/fraction;
            int y = denominator[i]/fraction;
            int z = y-x;
         
            if(hasMap.containsKey(z) && hasMap.get(z).containsKey(y)){
                
                count+=hasMap.get(z).get(y);
            }
            
            if(hasMap.containsKey(x)){
                 HashMap<Integer,Integer> hm = hasMap.get(x);
                 hm.put(y,hm.getOrDefault(y,0)+1);
            }
            else{
                HashMap<Integer,Integer> hm = new HashMap<>();
                hm.put(y,1);
                hasMap.put(x,hm);
            }
           
        }
        
        
        return count;
    }
}
        
