Question Link : https://leetcode.com/problems/reverse-linked-list-ii/
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left==right) return head;
        ListNode cur = head;
        ListNode curl = head;
        int i = 1;
        if(left!=1){
            while(i<left-1){
                cur = cur.next;
                i++;
            }
            curl = cur.next;
        }
        ListNode curR = curl;
        while(left!=1?i<right-1:i<right){
            curR = curR.next;
            i++;
        }
        //cur.next = null;
        ListNode last = curR.next;
            curR.next = null;
        ListNode rev = reverse(curl);
        if(left==1){
            head = rev;
        }else{
        cur.next = rev;
        }
        ListNode temp1 = rev;
        while(temp1.next!=null) temp1 = temp1.next;
        temp1.next = last;
        return head;
    }
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode fn = cur.next;
            cur.next = prev;
            prev = cur;
            cur = fn;
        }
        head = prev;
        return head;
    }
}
