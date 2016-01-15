package lobster.algorithms;

import java.util.Stack;


/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * @author lobster
 *
 */
public class ReverseNodesInKGroup {
	//待优化
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(k==1 || head == null) {
    		return head;
    	}
    	Stack<ListNode> st = new Stack<ListNode>();
    	ListNode p = head;
    	ListNode h = null;
    	int n = 0;
    	while(n!=k) {
    		if(p == null) {
    			return head;
    		}
    		st.push(p);
    		p=p.next;
    		n++;
    	}
    	h=new ListNode(0);
    	ListNode pr = h;
    	while(!st.isEmpty()) {
    		pr.next=st.pop();
    		pr=pr.next;
    	}
    	pr.next=reverseKGroup(p,k);
    	return h.next;
    }
    public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
    }
    
    public static void main(String[] args) {
    	ListNode node = new ReverseNodesInKGroup().new ListNode(1);
    	node.next=new ReverseNodesInKGroup().new ListNode(2);
    	node.next.next=new ReverseNodesInKGroup().new ListNode(3);
    	node.next.next.next=new ReverseNodesInKGroup().new ListNode(4);
    	node.next.next.next.next=new ReverseNodesInKGroup().new ListNode(5);
		ListNode listNode = new ReverseNodesInKGroup().reverseKGroup(node, 2);
		System.out.println(listNode);
	}
}
