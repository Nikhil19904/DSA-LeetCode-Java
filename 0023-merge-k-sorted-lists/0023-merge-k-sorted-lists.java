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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < lists.length; i++){
            ListNode curr = lists[i];
            while(curr != null){
                System.out.print(curr.val+" ");
                pq.add(curr.val);
                curr = curr.next;
            }
        }
    
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
           tail.next = new ListNode(pq.poll());
           tail = tail.next;
        }
        return dummy.next; 
    }
}