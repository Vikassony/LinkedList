/**

Given the head of a singly linked list, return true if it is a palindrome.
Example 1:
Input: head = [1,2,2,1]
Output: true

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
        ListNode s=head;
        ListNode f=head;
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
            return head;
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=null)
        {
            ListNode n=cur.next;
            cur.next=pre;
            pre=cur;
            cur=n;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next==null)
            return true;
        ListNode mid=getMid(head);
        ListNode reversedNode=reverse(mid.next);
        mid.next=null;
        ListNode cur1=head;
        ListNode cur2=reversedNode;
        while(cur1!=null && cur2!=null)
        {
            if(cur2.val==cur1.val)
            {
                cur2=cur2.next;
                cur1=cur1.next;
            }
            else
                return false;
        }
        return true;
    }
}
