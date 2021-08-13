/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        int carry=0;
        ListNode output=new ListNode(0),out=output;
        while(l1!=null&&l2!=null){
            int sum=l1.val+l2.val+carry;
            out.next=new ListNode(sum%10);
            out=out.next;
            carry=sum/10;
            l1=l1.next;
            l2=l2.next;
        }
         while(l1!=null){
            int sum=l1.val+carry;
            out.next=new ListNode(sum%10);
            out=out.next;
            carry=sum/10;
            l1=l1.next;
        }
         while(l2!=null){
            int sum=l2.val+carry;
            out.next=new ListNode(sum%10);
            out=out.next;
            carry=sum/10;
            l2=l2.next;
        }
        if(carry==1)
            out.next=new ListNode(1);
        return reverse(output.next);
    }
    public ListNode reverse(ListNode node){
        ListNode curr=node,next=null,prev=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
