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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();  
        helper(root, targetSum, list, list2);
        return list; 
    }

    private void helper(TreeNode root, int targetSum, List<List<Integer>> list, List<Integer> list2) {
        if (root == null) {
            return;  
        }

        list2.add(root.val);  

        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                list.add(new ArrayList<>(list2));  
            }
        }

        int remainingSum = targetSum - root.val;

        helper(root.left, remainingSum, list, list2);   
        helper(root.right, remainingSum, list, list2);  

        list2.remove(list2.size() - 1); 
    }
}