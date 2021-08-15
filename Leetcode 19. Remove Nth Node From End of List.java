/**
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int c = 0;
		ListNode t = head;
		while (t != null) {
			c++;
			t = t.next;
		}
		if (c == n) {
			return head.next;
		}
		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		ListNode temp = slow.next;
		slow.next = temp.next;
		return head;
	}
}
