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
    int findLength(ListNode head){
        if(head==null)
            return 0;
        return 1+findLength(head.next);
    }
    public ListNode swapNodes(ListNode head, int k) {
        ListNode Kfirst=null;
        ListNode Klast=null;
        int length=findLength(head);
        int l=1;
        ListNode temp=head;
        while(head!=null){
            if(l==k)
                Kfirst=head;
            if(l==(length-k+1))
                Klast=head;
            l++;
            head=head.next;
        }
        int t=Kfirst.val;
        Kfirst.val=Klast.val;
        Klast.val=t;
        return temp;
    }
}