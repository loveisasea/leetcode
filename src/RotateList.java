import java.util.Arrays;

import core.Util;

/*
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		int i = 0;
		ListNode node = head;
		ListNode ntail = head;
		ListNode tail = null;
		while (true) {
			if (i > k) {
				ntail = ntail.next;
			}
			if (node.next == null) {
				tail = node;
				node.next = head;
				if (k > i) {
					k = k % (i + 1);
					i = -1;
				}
			}
			if (i > k && tail == node) {
				ListNode nhead = ntail.next;
				ntail.next = null;
				return nhead;
			}
			node = node.next;
			i++;
		}
	}

	// old implementation
	// public ListNode rotateRight(ListNode head, int k) {
	// int len = 0;
	// ListNode tail = head;
	// if (tail == null) {
	// len = 0;
	// return head;
	// } else {
	// len = 1;
	// while (tail.next != null) {
	// len++;
	// tail = tail.next;
	// }
	// }
	// while (k >= len) {
	// k = k - len;
	// }
	// if (k == 0) {
	// return head;
	// }
	// int offset = len - k;
	// int i = 0;
	// ListNode newTail = head;
	// while (i < offset - 1) {
	// newTail = newTail.next;
	// i++;
	// }
	// ListNode newHead = newTail.next;
	// tail.next = head;
	// newTail.next = null;
	// return newHead;
	// }

	public static void main(String[] args) {
		RotateList ins = new RotateList();
		Input input = null;
		ListNode result = null;

		input = ins.new Input(ins.new ListNode(new int[] { 1 }), 2);
		result = ins.new ListNode(new int[] { 1 });
		Util.printInput(input);
		Util.printResult(ins.rotateRight(input.head, input.k), result);

		input = ins.new Input(ins.new ListNode(new int[] { 1, 2, 3, 4, 5 }), 2);
		result = ins.new ListNode(new int[] { 4, 5, 1, 2, 3 });
		Util.printInput(input);
		Util.printResult(ins.rotateRight(input.head, input.k), result);

		input = ins.new Input(ins.new ListNode(new int[] { 1, 2, 3, 4, 5 }), 7);
		result = ins.new ListNode(new int[] { 4, 5, 1, 2, 3 });
		Util.printInput(input);
		Util.printResult(ins.rotateRight(input.head, input.k), result);

		input = ins.new Input(ins.new ListNode(new int[] { 1, 2, 3, 4, 5 }), 12);
		result = ins.new ListNode(new int[] { 4, 5, 1, 2, 3 });
		Util.printInput(input);
		Util.printResult(ins.rotateRight(input.head, input.k), result);

		input = ins.new Input(ins.new ListNode(new int[] { 1, 2, 3, 4, 5, 6 }), 1);
		result = ins.new ListNode(new int[] { 6, 1, 2, 3, 4, 5 });
		Util.printInput(input);
		Util.printResult(ins.rotateRight(input.head, input.k), result);

		input = ins.new Input(ins.new ListNode(new int[] { 1, 2, 3, 4, 5, 6 }), 2);
		result = ins.new ListNode(new int[] { 5, 6, 1, 2, 3, 4 });
		Util.printInput(input);
		Util.printResult(ins.rotateRight(input.head, input.k), result);

		input = ins.new Input(ins.new ListNode(new int[] { 1, 2, 3, 4, 5, 6 }), 6);
		result = ins.new ListNode(new int[] { 1, 2, 3, 4, 5, 6 });
		Util.printInput(input);
		Util.printResult(ins.rotateRight(input.head, input.k), result);

		input = ins.new Input(ins.new ListNode(new int[] { 1, 2, 3 }), 2000000000);
		result = ins.new ListNode(new int[] { 2, 3, 1 });
		Util.printInput(input);
		Util.printResult(ins.rotateRight(input.head, input.k), result);
	}

	class Input {
		ListNode head;
		int k;

		public Input(ListNode head, int k) {
			this.head = head;
			this.k = k;
		}

		@Override
		public String toString() {
			return String.format("head:%s, l2:%s", this.head, this.k);
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
