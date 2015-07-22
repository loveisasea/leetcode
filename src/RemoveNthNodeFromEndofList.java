import core.Util;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		else if (n == 0) {
			return head;
		}
		ListNode curr = head;
		int i = 1;
		while (curr != null) {
			if (i >= n) {
				break;
			}
			i++;
			curr = curr.next;
		}
		if (curr == null) {
			return null;
		}

		ListNode nPrev = null;
		curr = curr.next;
		if (curr == null) {
			return head.next;
		} 
		nPrev = head; 
		
		do {
			curr = curr.next;
			if (curr == null) {
				break;
			} 
			nPrev = nPrev.next; 
		} while (true);
		if (nPrev == null) {
			return head.next;
		} else {
			nPrev.next = nPrev.next.next;
			return head;
		}
	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndofList ins = new RemoveNthNodeFromEndofList();
		Input input = null;
		ListNode result = null;

		input = ins.new Input(null, 2);
		input.head = ins.new ListNode(1);
		input.head.next = ins.new ListNode(2);
		input.head.next.next = ins.new ListNode(3);
		input.head.next.next.next = ins.new ListNode(4);
		input.head.next.next.next.next = ins.new ListNode(5);
		input.head.next.next.next.next.next = ins.new ListNode(6);
		input.head.next.next.next.next.next.next = ins.new ListNode(7);
		result = ins.new ListNode(1);
		result.next = ins.new ListNode(2);
		result.next.next = ins.new ListNode(3);
		result.next.next.next = ins.new ListNode(4);
		result.next.next.next.next = ins.new ListNode(5);
		result.next.next.next.next.next = ins.new ListNode(7);
		Util.printInput(input);
		Util.printResult(ins.removeNthFromEnd(input.head, input.n), result);

		input = ins.new Input(null, 2);
		input.head = ins.new ListNode(1);
		result = null;
		Util.printInput(input);
		Util.printResult(ins.removeNthFromEnd(input.head, input.n), result);

		input = ins.new Input(null, 2);
		input.head = ins.new ListNode(1);
		input.head.next = ins.new ListNode(2);
		result = ins.new ListNode(2);
		Util.printInput(input);
		Util.printResult(ins.removeNthFromEnd(input.head, input.n), result);

	}

	class Input {
		ListNode head;
		int n;

		public Input(ListNode head, int n) {
			this.head = head;
			this.n = n;
		}

		public String toString() {
			return String.format("head:%s,n:%s", this.head, this.n);
		}
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
