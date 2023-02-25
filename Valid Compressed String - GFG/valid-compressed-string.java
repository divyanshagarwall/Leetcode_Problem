//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        int i=0;
        int j = 0;
        while(i<S.length() && j<T.length()){
            if(S.charAt(i)==T.charAt(j)){
                i++;
                j++;
            }
            else if((int)T.charAt(j)>57 || (int)T.charAt(j)<48)
                return 0;
            else{
                int index = j;
                int val = 0;
                int count = 0;
                while(index<T.length() && (int)T.charAt(index)>=48 && (int)T.charAt(index)<=57){
                    if(count==0 && (int)T.charAt(index)==48)
                        return 0;
                    count++;
                    index++;       
                }
                index = j;
                int last = count;
                while(count!=0){
                    val+=((int)T.charAt(index)-48)*Math.pow(10,count-1);
                    count--;
                    index++;
                }
                i+=val;
                j+=last;
            }
        }
        if(i==S.length() && j==T.length())
            return 1;
        return 0;
    }
}