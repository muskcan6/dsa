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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        solve(dummy, list1, list2);

        return head.next;
    }

    public void solve(ListNode temp, ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return;

        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = new ListNode(l1.val);
                solve(temp.next, l1.next, l2);
            } else {
                temp.next = new ListNode(l2.val);
                solve(temp.next, l1, l2.next);
            }
        } else if (l1 != null) {
            temp.next = new ListNode(l1.val);
            solve(temp.next, l1.next, l2);
        } else {
            temp.next = new ListNode(l2.val);
            solve(temp.next, l1, l2.next);
        }
    }
}
