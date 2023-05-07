//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        // code here
        int pos=0;
        char temp=str.charAt(0);
        for(int i=1;i<str.length();i++)
        {
            if(pos==0&&str.charAt(i)==temp)
            {
                break;
            }
            else if(str.charAt(i)<=temp)
            {
                temp=str.charAt(i);
                pos=i;
            }
            else
            {
                break;
            }
        }
        if(pos==0)
        {
            String l="";
            l=l+temp;
            l+=temp;
            return l;
        }
        
        char[]arr=new char[pos+1];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=str.charAt(i);
        }
        StringBuilder ans=new StringBuilder();
    
        for(int i=0;i<arr.length;i++)
        {
            ans=ans.append(arr[i]);
        }
     for(int i=arr.length-1;i>=0;i--)
        {
            ans=ans.append(arr[i]);
        }
        return ans.toString();
    }
}
        
