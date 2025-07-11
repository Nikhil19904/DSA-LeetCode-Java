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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;
        //Append the current node's value to the path.
        path += node.val;

        //If it's a leaf node, add the path to the result list.
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            path += "->";// Separate nodes in the path.
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
    }
}