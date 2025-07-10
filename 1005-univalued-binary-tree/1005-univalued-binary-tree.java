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
    public boolean isUnivalTree(TreeNode root) {
        int val1 = root.val;
        return find(root,val1);
    }
    public boolean find(TreeNode root, int val1){
        if(root==null){
            return true;
        }
        if(root.val!=val1){
            return false;
        }
        boolean left = find(root.left,val1);
        boolean right = find(root.right,val1);
        return left && right;
    }
}