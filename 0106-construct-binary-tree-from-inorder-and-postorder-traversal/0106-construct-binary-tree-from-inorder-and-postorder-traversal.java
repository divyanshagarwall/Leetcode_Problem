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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    
    private TreeNode helper(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder){
        
        if (postEnd < 0 || inStart > inEnd) return null;
        
        TreeNode cur = new TreeNode(postorder[postEnd]);
        
        int inPivot = 0;
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == postorder[postEnd]){
                inPivot = i;
                break;
            }
        }
        cur.left  = helper(postEnd + inPivot - inEnd - 1, inStart, inPivot - 1, inorder, postorder);
        cur.right = helper(postEnd - 1, inPivot + 1, inEnd, inorder, postorder);
        return cur;
    }
}