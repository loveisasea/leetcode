import java.util.Arrays;

import core.Util;

/*
 Given a sorted linked list, delete all duplicates such that each 
 element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {  
		ListNode prev = head;
		ListNode curr = head;
		while (curr != null) {
			if (curr.val != prev.val) { 
				prev.next=curr;
				prev = curr;
			}  
			curr = curr.next;
			prev.next = null; 
		} 
		return head;
	}
	
	public static void main(String[] args){
		RemoveDuplicatesfromSortedList ins = new RemoveDuplicatesfromSortedList();
		ListNode input = null;
		ListNode result = null;
		
		input = ins.new ListNode(new int[]{1});
		result = ins.new ListNode(new int[]{1});
		Util.printInput(input);
		ins.deleteDuplicates(input);
		Util.printResult(input, result);
		
		input = ins.new ListNode(new int[]{1,2,2,2,2});
		result = ins.new ListNode(new int[]{1,2});
		Util.printInput(input);
		ins.deleteDuplicates(input);
		Util.printResult(input, result);
		
		input = ins.new ListNode(new int[]{1,2,2,2,3});
		result = ins.new ListNode(new int[]{1,2,3});
		Util.printInput(input);
		ins.deleteDuplicates(input);
		Util.printResult(input, result);
		
		
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
