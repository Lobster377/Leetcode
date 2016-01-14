package lobster.algorithms;



/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * @author lobster
 *
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
    	if(head==null||head.next==null){
            return head;  
        }
        ListNode tail=head.next.next;
        ListNode newHead=head.next;
        newHead.next=head;
        head.next=swapPairs(tail);
        return newHead;
    }
    
    public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
    }
}
