import java.util.Arrays;

import core.Util;

public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length==0){
			return null;
		}
		return this.recurMerge(lists, 0, lists.length-1); 
	}
	
	ListNode recurMerge(ListNode[] lists,int low,int high){
		int step = high - low;
		if (step<0){
			return null;
		}
		else if(step==0){
			return lists[low];
		}
		else if(step==1){
			return this.mergeTwoLists(lists[low], lists[high]);
		}
		else{
			int mid = (low+high)/2;
			ListNode lowNode = this.recurMerge(lists, low, mid);
			ListNode highNode = this.recurMerge(lists, mid+1, high);
			return this.mergeTwoLists(lowNode, highNode);
		}
	}

	ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		else if (l2 == null) {
			return l1;
		}
		ListNode head = null;
		ListNode cur = null;
		ListNode cur1 = null;
		ListNode cur2 = null;
		if (l1.val < l2.val) {
			head = l1;
			cur1 = l1.next;
			cur2 = l2;
		}
		else {
			head = l2;
			cur1 = l1;
			cur2 = l2.next;
		}
		cur = head;
		do {
			if (cur1 == null) {
				cur.next = cur2;
				break;
			}
			else if (cur2 == null) {
				cur.next = cur1;
				break;
			}
			else if (cur1.val < cur2.val) {
				cur.next = cur1;
				cur = cur.next;
				cur1 = cur1.next;

			} else {
				cur.next = cur2;
				cur = cur.next;
				cur2 = cur2.next;
			}
		} while (true);
		return head;
	}

	public static void main(String[] args) {
		MergekSortedLists ins = new MergekSortedLists();
		ListNode[]  input = null;
		ListNode result = null;

		input = new ListNode[3];
		input[0] =  ins.new ListNode(new int[] { 1, 3, 5 });
		input[1] =  ins.new ListNode(new int[] { 3, 9, 11 }); 
		input[2] =  ins.new ListNode(new int[] { 2, 4, 6 }); 
		result = ins.new ListNode(new int[] { 1, 2, 3, 3, 4, 5, 6,9,11 });
		Util.printInput(input);
		Util.printResult(ins.mergeKLists(input), result);
 
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		ListNode(int[] xs) {
			val = xs[0];
			if (xs.length >= 2) {
				this.next = new ListNode(Arrays.copyOfRange(xs, 1, xs.length));
			}
		}

		@Override
		public boolean equals(Object oth) {
			if (oth == null) {
				return false;
			}
			return this.toString().equals(oth.toString());
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			sb.append(val);
			ListNode pNext = this.next;
			while (pNext != null) {
				sb.append(",");
				sb.append(pNext.val);
				pNext = pNext.next;
			}
			sb.append("]");
			return String.format("%s", sb.toString());
		}
	}
}
