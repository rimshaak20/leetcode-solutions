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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp=head;
        int c=1;
        ListNode dummy1=new ListNode(0);
        ListNode a=dummy1;
        ListNode dummy2=new ListNode(0);
        ListNode b=dummy2;
        
        while(temp != null){
            if(c%2==1){
                a.next=new ListNode(temp.val);
                a=a.next;
            }
            else{
                b.next=new ListNode(temp.val);
                b=b.next;
            }
            c++;
            temp=temp.next;
        }
        a.next=dummy2.next;
        return dummy1.next;


    }
}