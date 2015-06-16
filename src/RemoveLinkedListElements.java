import core.Util;

/*
 * 
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

 */

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode pPrevious = null;
		ListNode pHead = null;
		while (head != null) {
			if (head.val == val) {
				head = head.next;
				if (pPrevious != null) {
					pPrevious.next = head;
				}
				continue;
			}
			else {
				if (pHead == null) {
					pHead = head;
				}
				pPrevious = head;
				head = head.next;
			}
		}
		return pHead;
	}

	public static void main(String[] args) {
		RemoveLinkedListElements ins = new RemoveLinkedListElements();

		Input input = null;
		ListNode result = null;
		Util.printInput(input);
		Util.printResult(ins.removeElements(null, 2), result);

		input = ins.new Input();
		input.val = 1;
		input.head = ins.new ListNode(2);
		result = ins.new ListNode(2);
		Util.printInput(input);
		Util.printResult(ins.removeElements(input.head, input.val), result);

		input = ins.new Input();
		input.val = 2;
		input.head = ins.new ListNode(2);
		result = null;
		Util.printInput(input);
		Util.printResult(ins.removeElements(input.head, input.val), result);

		input = ins.new Input();
		input.val = 2;
		input.head = ins.new ListNode(2);
		input.head.next = ins.new ListNode(1);
		input.head.next.next = ins.new ListNode(2);
		result = ins.new ListNode(1);
		Util.printInput(input);
		Util.printResult(ins.removeElements(input.head, input.val), result);
	}

	class Input {
		ListNode head;
		int val;

		@Override
		public String toString() {
			return String.format("node:%s,val:%s", head.toString(), this.val);
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
