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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int bottomLeft = root.val;

        while (!queue.isEmpty()) {
            int size = queue.size();
            bottomLeft = queue.peek().val;  // First node at this level

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Left child first to maintain left-to-right order
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return bottomLeft;
    }
}
