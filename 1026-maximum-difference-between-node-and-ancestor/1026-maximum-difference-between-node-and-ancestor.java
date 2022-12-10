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
    private int helper(TreeNode root, int minVal, int maxVal){
        if(root == null) return maxVal - minVal;
        minVal = Math.min(minVal, root.val);
        maxVal = Math.max(maxVal, root.val);
        return Math.max(helper(root.left, minVal, maxVal), helper(root.right, minVal, maxVal));
    }
    public int maxAncestorDiff(TreeNode root) {
        int minVal = 10000, maxVal = 0;
        return helper(root, minVal, maxVal);
    }
}