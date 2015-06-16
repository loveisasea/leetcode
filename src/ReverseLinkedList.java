import core.Util;

public class ReverseLinkedList { 
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pNext = head.next;
		ListNode pPrevious = null;
		while (head != null) {
			pNext = head.next;
			head.next = pPrevious;
			pPrevious = head;
			head = pNext;
		}
		return pPrevious;
	}

	public static void main(String[] args) {
		ReverseLinkedList ins = new ReverseLinkedList();

		ListNode input = null;
		ListNode result = null;
		Util.printInput(input);
		Util.printResult(ins.reverseList(input), result);

		input = ins.new ListNode(1);
		result = ins.new ListNode(1); 
		Util.printInput(input);
		Util.printResult(ins.reverseList(input), result);
		
		input = ins.new ListNode(1);
		input.next = ins.new ListNode(2);
		result = ins.new ListNode(2); 
		result.next = ins.new ListNode(1);
		Util.printInput(input);
		Util.printResult(ins.reverseList(input), result);
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


