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

    //tc = o(m+n) // basically iterating over both lists once
    // sc (m+n) stack space for recursion -- use iteration to reduce this to constant

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return solve(list1, list2);
    }

    public ListNode solve(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = solve(l1.next, l2);
            return l1;
        } else {
            l2.next = solve(l1, l2.next);
            return l2;
        }
    }
}
