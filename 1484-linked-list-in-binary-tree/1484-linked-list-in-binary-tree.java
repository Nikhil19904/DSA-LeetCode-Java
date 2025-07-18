/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        // Check if match starts from current root or explore left/right
        return dfs(head, root) || 
               isSubPath(head, root.left) || 
               isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode node) {
        // Entire linked list matched
        if (head == null) return true;
        // Tree node ends before list ends
        if (node == null) return false;
        // Values must match
        if (node.val != head.val) return false;

        // Recurse into left or right subtree
        return dfs(head.next, node.left) || dfs(head.next, node.right);
    }
}
