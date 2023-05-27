//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head)
    {
        ArrayList<Integer>list = new ArrayList<Integer>();
        if(head==null || head.next==null){
            return head;
        }
        Node temp=head;
        while(temp!=null){
            list.add(temp.data);
            temp=temp.next;
        }
        temp=head;
        int n=list.size();
        // System.out.println(n);
        int i=0;
        int j=n-1;
        int m=(n%2==1)?n/2:n/2-1;
        
        while(j>m){
            int temp1=list.get(i);
            list.set(i,list.get(j)-list.get(i));
            list.set(j,temp1);
            i++;
            j--;
        }
        i=0;
        while(temp!=null){
            temp.data=list.get(i);
            temp=temp.next;
            i++;
        }
        // System.out.println(list);

        return head;
    }
}