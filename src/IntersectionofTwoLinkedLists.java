public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = this.getNodeLen(headA);
		int lenB = this.getNodeLen(headB);
		if (lenA == 0 || lenB == 0) {
			return null;
		}
		int step = lenA - lenB;
		if (step < 0) {
			step = step * -1;
			ListNode tmp = headA;
			headA = headB;
			headB = tmp;
		}
		for (int i = 0; i < step; i++) {
			headA = headA.next;
		}
		while (true) {
			if (headA == headB) {
				return headA;
			}
			if (headA == null || headB == null) {
				return null;
			}
			headA = headA.next;
			headB = headB.next;
		} 
	}

	public int getNodeLen(ListNode node) {
		int len = 0;
		ListNode tmp = node;
		while (tmp != null) {
			tmp = tmp.next;
			len++;
		}
		return len;
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
