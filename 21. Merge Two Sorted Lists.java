/**
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode();
        ListNode head=ln;
    ListNode temp1=l1;
     ListNode temp2=l2;
     while(temp1!=null && temp2!=null)
     {
         if(temp1.val>temp2.val)
         {
             ln.next=temp2;
             temp2=temp2.next;
         }
         else{
             ln.next=temp1;
             temp1=temp1.next;
         }
          ln=ln.next;
     }
       
     if(temp1!=null)
     {
         ln.next=temp1;
     }
     else
     {
         ln.next=temp2;
     }
     return head.next;
    }
}
