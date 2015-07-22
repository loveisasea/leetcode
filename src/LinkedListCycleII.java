import core.Util;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		int pathLength = 0;
		
		ListNode prev = head;
		ListNode curr = head.next;
		//reverse linklist to findout whether it is a cycle link and the path length;
		while (curr != null) {
			pathLength++;
			if (curr == head) {
				break;
			}
			ListNode tmp = prev;
			prev = curr;
			curr = curr.next;
			prev.next = tmp;
		} 
		//not cycle link, return null
		if(curr==null){
			return null;
		}
		
		//cycle link, findout some listnode inside the cycle.
		int halfpathLength = pathLength/2;
		ListNode cycleNode= head;
		while(halfpathLength>0){
			cycleNode = cycleNode.next;
			halfpathLength--;
		} 
		
		//caculate the cycle length
		ListNode tmp = cycleNode.next;
		int cycleLength = 1;
		while(tmp!=cycleNode){
			tmp = tmp.next;
			cycleLength++;
		}
		
		
		int position = (pathLength-cycleLength)/2;
		ListNode retNode = head;
		while(position>0){
			retNode = retNode.next;
			position--;
		} 
		return retNode;
	}

	public static void main(String[] args) {
		LinkedListCycleII ins = new LinkedListCycleII();
		ListNode input = ins.new ListNode(3);
		input.next = ins.new ListNode(2);
		input.next.next = ins.new ListNode(0);
		input.next.next.next = ins.new ListNode(-4);
		input.next.next.next.next = input.next.next.next; 
		Util.printResult(ins.detectCycle(input).val, -4);

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
