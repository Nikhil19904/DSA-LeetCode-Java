/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // Map to count frequency of each subtree serialization
    private Map<String, Integer> map = new HashMap<>();
    // List to store the result
    private List<TreeNode> result = new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }
    
    // Helper method to serialize the subtree rooted at 'node'
    private String serialize(TreeNode node) {
        if (node == null) return "#";  // Use # to represent null
        
        // Serialize current node
        String serial = node.val + "," + serialize(node.left) + "," + serialize(node.right);
        
        // Update frequency in map
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        
        // If frequency becomes 2 (not more), add to result
        if (map.get(serial) == 2) {
            result.add(node);
        }
        
        return serial;
    }
}
