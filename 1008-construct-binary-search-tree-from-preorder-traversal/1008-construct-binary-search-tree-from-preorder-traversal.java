/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root= new TreeNode( preorder[0] );
        for(int i: preorder) {
            createTree(i, root);
        }
        return root;
    }
    
    public TreeNode createTree(int i, TreeNode root) {
        if(root == null) {
            root= new TreeNode(i);
            return root;
        }
        if(root.val > i) {
            root.left= createTree(i, root.left);
        }
        if(root.val < i) {
            root.right= createTree(i, root.right);
        }
        return root;
    }
}