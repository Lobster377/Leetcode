package lobster.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 *   Given linked list: 1->2->3->4->5, and n = 2.
 *   After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * @author lobster
 *
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	Queue<ListNode> queue = new LinkedList<ListNode>();
    	ListNode node = head;
    	queue.add(node);
    	ListNode pre = null;
    	while(node.next !=null) {
    		node = node.next;
    		if(queue.size()==n) {
    			pre = queue.poll();
    			queue.add(node);
    		}else {
    			queue.add(node);
    		}
    	}
    	queue.poll();
    	if(pre != null) {
    		pre.next=queue.poll();
    	}else {
    		head = queue.poll();
    	}
    	return head;
    }
    
     public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
    }
     
}
