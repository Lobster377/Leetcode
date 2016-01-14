package lobster.algorithms;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode p1=l1,p2=l2;
    	ListNode ret = new ListNode(0);
    	ListNode p = ret;
    	if(p1 == null) {
    		return p2;
    	}
    	if(p2==null) {
    		return p1;
    	}
    	while(p1 != null || p2 != null) {
    		if(p2 == null) {
    			p.next=p1;
    			break;
    		}
    		if(p1 == null) {
    			p.next=p2;
    			break;
    		}
    		if(p1.val<p2.val) {
    			p.next = p1;
    			p1=p1.next;
    		}else {
    			p.next=p2;
    			p2=p2.next;
    		}
    		p = p.next;
    	}
    	
        return ret.next;
    }
    
    public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
    }
}
