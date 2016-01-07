package lobster.algorithms;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author lobster
 *
 */
public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode ptr = head;
		int t = 0;
		while(true) {
			if(l1 == null && l2 == null && t == 0) {
				break;
			}else{
				int v1 = 0,v2 = 0,r=0;
				if(l1 != null) {
					v1=l1.val;
				}
				if(l2 != null) {
					v2=l2.val;
				}
				r=v1+v2+t;
				if(r>9) {
					t=1;
					r=r-10;
				}else{
					t=0;
				}
				ptr.next=new ListNode(r);
				ptr = ptr.next;
			}
			if(l1 != null) {
				l1=l1.next;
			}
			if(l2 != null) {
				l2=l2.next;
			}
		}
		return head.next;
    }
}
