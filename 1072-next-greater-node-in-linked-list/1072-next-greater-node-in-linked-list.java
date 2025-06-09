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
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int[] result = new int[values.size()];
        Stack<Integer> stack = new Stack<>();  // stores indices

        for(int i =0;i <values.size();i++) {
            while(!stack.isEmpty() && values.get(i)>values.get(stack.peek())) {
                int idx = stack.pop();
                result[idx] = values.get(i);  // found next greater
            }
            stack.push(i);
        }

        // Remaining elements have no next greater → leave as 0
        return result;
    }
}