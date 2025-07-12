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

    // Store parent and level for both nodes x and y
    static TreeNode xParent, yParent;
    static int xLevel, yLevel;

    // Helper function to traverse the tree and find parent & level of x and y
    public void findNodeInfo(TreeNode current, TreeNode parent, int x, int y, int level) {
        if (current == null) return;

        if (current.val == x) {
            xParent = parent;
            xLevel = level;
        } else if (current.val == y) {
            yParent = parent;
            yLevel = level;
        }

        // Recur for left and right subtrees
        findNodeInfo(current.left, current, x, y, level + 1);
        findNodeInfo(current.right, current, x, y, level + 1);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        // Initialize before use
        xParent = null; yParent = null;
        xLevel = -1; yLevel = -1;

        // Start DFS
        findNodeInfo(root, null, x, y, 0);

        // Cousins: same level, different parents
        return (xLevel == yLevel) && (xParent != yParent);
    }
}