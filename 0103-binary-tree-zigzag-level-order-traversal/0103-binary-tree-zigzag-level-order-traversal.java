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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (root == null)
            return ans;

        final Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int level = 0;

        while (!queue.isEmpty()) {
            final int sizeQ = queue.size();
            final List<Integer> intermediate = new ArrayList<>();

            for (int i = 0; i < sizeQ; ++i) {
                final TreeNode cur = queue.removeFirst();
                intermediate.add(cur.val);

                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            if (level % 2 != 0) Collections.reverse(intermediate);
            ++level;
            ans.add(new ArrayList<>(intermediate));
        }

        return ans;
    }
}
