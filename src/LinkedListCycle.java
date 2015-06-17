import core.Util;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode prev = head;
		ListNode curr = head.next;
		while (curr != null) {
			if (curr == head) {
				return true;
			}
			ListNode tmp = prev;
			prev = curr;
			curr = curr.next;
			prev.next = tmp;
		}
		return false;
	}

	// public boolean hasCycle(ListNode head) {
	// if (head == null) {
	// return false;
	// }
	// ListNode prev = head;
	// ListNode movinghead = null;
	// ListNode curr = head.next;
	// while (curr != null) {
	// if (hasInClude(movinghead, curr)) {
	// return true;
	// }
	// movinghead = curr;
	// curr = curr.next;
	// movinghead.next = prev;
	// if(prev==head){
	// prev.next=null;
	// }
	// prev = movinghead;
	// }
	// return false;
	// }
	//
	// private boolean hasInClude(ListNode root, ListNode other) {
	// if (root == null) {
	// return false;
	// }
	// ListNode curr = root;
	// while (curr != null) {
	// if (curr == other) {
	// return true;
	// }
	// curr = curr.next;
	// }
	// return false;
	// }

	public static void main(String[] args) {
		LinkedListCycle ins = new LinkedListCycle();
		ListNode input = ins.new ListNode(3);
		input.next = ins.new ListNode(2);
		input.next.next = ins.new ListNode(0);
		input.next.next.next = ins.new ListNode(-4);
		input.next.next.next.next = input.next.next;
		// Util.printInput(input);
		Util.printResult(ins.hasCycle(input), true);

	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
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
