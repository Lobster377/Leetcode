package lobster.algorithms;

import java.util.PriorityQueue;

import lobster.struct.MinHeap;




public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length==0) {
			return null;
		}
		ListNode list = new ListNode(0);
		ListNode h = list;
		PriorityQueue<Integer> l = new PriorityQueue<Integer>();
		for(int i = 0;i<lists.length;i++) {
			ListNode p = lists[i];
			while(p!=null) {
				l.add(p.val);		
				p=p.next;
			}
		}
		Integer s = l.poll();
		while(s != null) {
			h.next=new ListNode(s);
			h=h.next;
			s=l.poll();
		}
		return list.next;
	}
	
	public ListNode mergeKLists_2(ListNode[] lists) {
		if(lists.length==0) {
			return null;
		}
		ListNode list = new ListNode(0);
		ListNode h = list;
		MinHeap<Integer> l = new MinHeap<Integer>(10000);
		for(int i = 0;i<lists.length;i++) {
			ListNode p = lists[i];
			while(p!=null) {
				l.insert(p.val);		
				p=p.next;
			}
		}
		Integer s = l.top();
		while(s != null) {
			h.next=new ListNode(s);
			h=h.next;
			s=l.top();
		}
		return list.next;
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		ListNode node1 = new MergeKSortedLists().new ListNode(1);
		ListNode node2 = new MergeKSortedLists().new ListNode(0);
		ListNode[] l = new ListNode[]{node1,node2};
		ListNode node = new MergeKSortedLists().mergeKLists_2(l);
		System.out.println(node);
	}
}
