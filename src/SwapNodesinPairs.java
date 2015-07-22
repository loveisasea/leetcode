import java.util.Arrays;

import core.Util;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} 
		ListNode n2 = head;
		ListNode n1 = head.next;
		ListNode n3 = head.next.next;  
		n1.next=n2;
		n2.next=n3; 
		head = n1;
		
		do{  
			if (n3 == null) {
				break;
			}
			if (n3.next == null) {
				break;
			}
			ListNode oldn2 = n2;
			n1 = n3.next;
			n2 = n3;
			n3 = n3.next.next;
			oldn2.next = n1;
			n1.next = n2;
			n2.next = n3; 
		}while(true);
		return head;
	}

	public static void main(String[] args) {
		SwapNodesinPairs ins = new SwapNodesinPairs();
		ListNode input = null;
		ListNode result = null;
 
		input = ins.new ListNode(new int[] { 1 });
		result = ins.new ListNode(new int[] { 1 });
		Util.printInput(input);
		Util.printResult(ins.swapPairs(input), result);
		
		input = ins.new ListNode(new int[] { 1,2 });
		result = ins.new ListNode(new int[] { 2,1 });
		Util.printInput(input);
		Util.printResult(ins.swapPairs(input), result);
		
		input = ins.new ListNode(new int[] { 1,2,3 });
		result = ins.new ListNode(new int[] { 2,1,3 });
		Util.printInput(input);
		Util.printResult(ins.swapPairs(input), result);
		
		input = ins.new ListNode(new int[] { 1,2,3,4 });
		result = ins.new ListNode(new int[] { 2,1,4,3 });
		Util.printInput(input);
		Util.printResult(ins.swapPairs(input), result);
		
		input = ins.new ListNode(new int[] { 1,2,3,4,5 });
		result = ins.new ListNode(new int[] { 2,1,4,3,5 });
		Util.printInput(input);
		Util.printResult(ins.swapPairs(input), result);
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
