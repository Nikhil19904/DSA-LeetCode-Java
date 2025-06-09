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
    public ListNode removeZeroSumSublists(ListNode head) {
         // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> prefixMap = new HashMap<>();
        int sum = 0;
        ListNode current = dummy;

        // First pass: Store prefix sums
        while (current != null) {
            sum += current.val;
            prefixMap.put(sum, current);
            current = current.next;
        }

        // Second pass: Remove zero-sum sequences
        sum = 0;
        current = dummy;
        while (current != null) {
            sum += current.val;
            current.next = prefixMap.get(sum).next;
            current = current.next;
        }

        return dummy.next;
    }
}