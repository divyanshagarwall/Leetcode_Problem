//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            Solution gfg = new Solution();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        }
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int find(int a[],int lo,int hi,int key)
    {
        for(int i=lo;i<=hi;i++)
        {
        if(a[i]==key)
        return i;
        }
        return -1;
    }
    public Node construct(int pre[],int preM[],int lo,int hi,int l,int h)
    {
        if(lo>hi)
        return null;
        Node root=new Node(pre[lo]);
        if(lo==hi)
        return root;
        int x=find(pre,lo+1,hi,preM[l+1]);
        root.left=construct(pre,preM,lo+1,x-1,l+(hi-x+1)+1,h);
        root.right=construct(pre,preM,x,hi,l+1,l+(hi-x+1));
        return root;
    }
    public Node constructBTree(int pre[], int preM[], int size)
    {
        return construct(pre,preM,0,size-1,0,size-1);
        // your code here
    }
    
}