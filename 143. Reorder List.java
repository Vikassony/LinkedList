/**
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
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
    ListNode getMid(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        ListNode s=head,f=head;
        while(f.next!=null && f.next.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
    ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode cur=head,prev=null;
        while(cur!=null)
        {
            ListNode n=cur.next;
            cur.next=prev;
            prev=cur;
            cur=n;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return ;
        ListNode mid=getMid(head);
        ListNode reverseNode = reverse(mid.next);
        mid.next=null;
        
        ListNode c1=head,c2=reverseNode,f1=null,f2=null;
        while(c2!=null)
        {
            f1=c1.next;
            f2=c2.next;
            c1.next=c2;
            c2.next=f1;
            c1=f1;
            c2=f2;
        }
        
    }
}
