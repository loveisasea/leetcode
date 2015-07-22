import java.util.Arrays;

import core.Util;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes 
 * of the first two lists.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
		MergeTwoSortedLists ins = new MergeTwoSortedLists();
		Input input = null;
		ListNode result = null;

		ListNode l1 = ins.new ListNode(new int[] { 1, 3, 5 });
		ListNode l2 = ins.new ListNode(new int[] { 2, 4, 6, 7 });
		input = ins.new Input(l1, l2);
		result = ins.new ListNode(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		Util.printInput(input);
		Util.printResult(ins.mergeTwoLists(input.l1, input.l2), result);
		
		input = ins.new Input(ins.new ListNode(1), ins.new ListNode(2));
		result = ins.new ListNode(new int[] { 1, 2 });
		Util.printInput(input);
		Util.printResult(ins.mergeTwoLists(input.l1, input.l2), result);
	}

	class Input {
		ListNode l1;
		ListNode l2;

		public Input(ListNode l1, ListNode l2) {
			this.l1 = l1;
			this.l2 = l2;
		}

		@Override
		public String toString() {
			return String.format("l1:%s,l2%s", this.l1, this.l2);
		}
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
