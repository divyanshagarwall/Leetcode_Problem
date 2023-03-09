//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String str) {
        // code here
        ArrayList<Node> ans1 = new ArrayList<>();
        String s="";
        Node p=head;
        
        while(head!=null){
            s+=head.data;
            if(s.length()==str.length()){
                if(isAnagram(s,str)){
                    addtoList(s,ans1);//method to add in ans
                    s="";
                }else{
                    s=s.substring(1);
                }
            }
            head=head.next;
        }
      
        return ans1;
        
    }
    static void addtoList(String e, ArrayList<Node> ans1){
        
         Node q= new Node('0');
         Node start=q;
        for(int i=0;i<e.length();i++){
            q.next=new Node(e.charAt(i));
            q=q.next;
        }
        
        ans1.add(start.next);
    }
    
    static boolean isAnagram(String s1 , String s2){
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);      if(String.valueOf(arr1).equals(String.valueOf(arr2)))
        return true;
        return false;
    }
}