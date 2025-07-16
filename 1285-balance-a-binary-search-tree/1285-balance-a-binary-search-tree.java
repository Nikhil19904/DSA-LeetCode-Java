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
    // Step 1: Store nodes in sorted order (in-order traversal)
    private List<TreeNode> nodes = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        // Fill the nodes list with in-order traversal
        inOrder(root);

        // Step 2: Build balanced BST from sorted list
        return buildBalancedTree(0, nodes.size() - 1);
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        nodes.add(node);  // Store reference to the original node
        inOrder(node.right);
    }

    private TreeNode buildBalancedTree(int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = nodes.get(mid);

        // Disconnect previous links to avoid cycles
        root.left = buildBalancedTree(start, mid - 1);
        root.right = buildBalancedTree(mid + 1, end);

        return root;
    }
}
