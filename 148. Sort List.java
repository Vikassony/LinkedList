/**

Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:
Input: head = []
Output: []
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
