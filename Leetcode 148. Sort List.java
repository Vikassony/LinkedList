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
class Solution
{
    
     ListNode sortList(ListNode head)
    {
        if(head==null || head.next==null)
        return head;
        
        ListNode mid=getMid(head);
        ListNode newHead=mid.next;
        mid.next=null;
        ListNode left = sortList(head);
        ListNode right=sortList(newHead);
        return merge(left,right);
    }
     ListNode getMid(ListNode head)
    {
        if(head==null || head.next==null)
        return head;
        ListNode f=head;
        ListNode s=head;
        while(f.next!=null && f.next.next!=null)
        {
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
     ListNode merge(ListNode left, ListNode right)
    {
       if(left==null || right==null)
       {
           return left!=null?left:right;
       }
       ListNode n1= new ListNode(-1);
       ListNode n2=n1;
       while(left!=null && right!=null)
       {
           if(left.val<right.val)
           {
               n2.next=left;
               left=left.next;
           }
           else
           {
               n2.next=right;
               right=right.next;
           }
           n2=n2.next;
       }
       if(left!=null)
       n2.next=left;
       else
       n2.next=right;
       return n1.next;
    }
    
}
