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
    public ListNode[] splitListToParts(ListNode head, int k) {
         ListNode[] result = new ListNode[k];

        // Step 1: Count total nodes
        int totalLength = 0;
        ListNode temp = head;
        while (temp != null) {
            totalLength++;
            temp = temp.next;
        }

        // Step 2: Calculate base size and extra
        int partSize = totalLength / k;
        int extra = totalLength % k;

        // Step 3: Split list
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            int currentPartSize = partSize + (extra > 0 ? 1 : 0);
            extra--;

            // Move to the last node of current part
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) current = current.next;
            }

            // Cut the part from the original list
            if (current != null) {
                ListNode next = current.next;
                current.next = null;
                current = next;
            }

            result[i] = partHead;
        }

        return result;
    }
}