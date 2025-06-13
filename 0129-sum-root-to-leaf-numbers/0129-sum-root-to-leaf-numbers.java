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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    // Helper function to perform DFS
    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;
        
        // Update the current sum
        currentSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the current sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recur for left and right children
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);

        return leftSum + rightSum;
    }
}
