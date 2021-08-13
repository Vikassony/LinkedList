/*Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed. 
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]*/
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
    ListNode th=null,tt=null;
void addFirstNode(ListNode head)
{
    if(th==null)
    {
        th=head;
        tt=head;
    }
    else
    {
        head.next=th;
        th=head;
    }
}
int size(ListNode head)
{
    ListNode cur=head;
    int count=0;
    while(cur!=null)
    {
        count++;
        cur=cur.next;
    }
    return count;
}
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        ListNode ot=null,oh=null;
        ListNode cur=head;
        int size=size(head);
        while(size>=k)
        {
            int len=k;
            while(len-->0)
            {
                 ListNode f=cur.next;
                cur.next=null;
                addFirstNode(cur);
                cur=f;
            }
            if(oh==null)
            {
                oh=th;
                ot=tt;
            }
            else
            {
                ot.next=th;
                ot=tt;
            }
            th=null;
            tt=null;
            size-=k;
            
        }
        ot.next=cur;
        return oh;
    }
}
