/*
Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.

Example 1:

Input:
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output: 8
Explanation: In the first example, there
are 9 nodes in linked list and we need
to find 2nd node from end. 2nd node
from end os 8.  
*/
class GfG
{
    int getNthFromLast(Node head, int n)
    {
      int count=0;
      Node temp=head;
      while(temp!=null)
      {
          count++;
          temp=temp.next;
      }
      if(n>count)
      return -1;
       Node fast=head;
       Node slow=head;
      
       for(int i=0;i<n-1;i++)
       {fast=fast.next;
         
       }
       
       while(fast.next!=null)
       {
           slow=slow.next;
           fast=fast.next;
          
       }

       return slow.data;
    }
}
