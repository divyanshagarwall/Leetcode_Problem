//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
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
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {

    public static String longestString(int n, String[] arr) {

        Arrays.sort(arr);

        

        int max=0;

        String ans="";

        

        HashMap<String,Integer> map=new HashMap<>();

        for(String s:arr){

            if(s.length()==1){

                map.put(s,s.length());

                if(s.length()>max){

                    max=s.length();

                    ans=s;

                }

            }

            else{

                if(map.containsKey(s.substring(0,s.length()-1)) && map.get(s.substring(0,s.length()-1))>0){

                    map.put(s,s.length());

                    if(s.length()>max){

                        max=s.length();

                        ans=s;

                    }

                }

                else{ 

                    map.put(s,0);

                }

            }

        }

        

        return ans;

    }

}

