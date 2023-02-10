//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
       String str="ballon";
       if(s.length()<str.length()) return 0;
       
       int[] freq=new int[26];
       
       for(int i=0;i<s.length();i++){
           freq[s.charAt(i)-'a']++;
       }
       int occ=freq[str.charAt(0)-'a'];
       for(int i=1;i<str.length();i++){
           int a=freq[str.charAt(i)-'a'];
           if(str.charAt(i)=='l' || str.charAt(i)=='o'){
               if( a%2!=0 || a!=occ*2  ){
                   occ=Math.min(occ,a/2);
               }
           }else if(occ>a){
               occ=a;
           }else if(a==0){
               occ=0;
               break;
           }
       }
       
       return occ;
    }
}
