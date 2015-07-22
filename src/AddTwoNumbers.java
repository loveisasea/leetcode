import java.util.Arrays;

import core.Util;

/*
 You are given two linked lists representing two non-negative numbers. 
 The digits are stored in reverse order and each of their nodes contain a 
 single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {  
        boolean step=false;
        ListNode head = null;
        ListNode curr = null; 
        while(true){  
        	ListNode tmp = new ListNode(0); 
        	boolean shouldAdd = false;
        	if(l1!=null){
        		tmp.val += l1.val;
        		l1 = l1.next;
        		shouldAdd=true;
        	}
        	if(l2!=null){
        		tmp.val += l2.val;
        		l2 = l2.next;
        		shouldAdd=true;
        	}
        	if(step){
        		tmp.val++;
        		shouldAdd=true;
        	}  
        	
        	if(shouldAdd){
        		if(tmp.val>=10){
            		tmp.val -=10;
            		step = true;
            	}
            	else{
            		step = false;
            	}
        		if(curr==null){
            		curr = tmp;
            		head = tmp;
            	}
            	else{
            		curr.next = tmp;
                	curr = curr.next; 
            	}
        	}
        	else{
        		 return head;
        	} 
        }  
    }
	
	public static void main(String[] args){
		AddTwoNumbers ins = new AddTwoNumbers();
		Input input = null;
		ListNode result = null;
		
		input = ins.new Input(ins.new ListNode(new int[]{0}),ins.new ListNode(new int[]{0}));
		result = ins.new ListNode(new int[]{0});
		Util.printInput(input);
		Util.printResult(ins.addTwoNumbers(input.l1, input.l2), result);
	}
	
	class Input{
		ListNode l1;
		ListNode l2;
		
		public Input(ListNode l1, ListNode l2){
			this.l1 = l1;
			this.l2 = l2;
		}
		
		@Override
		public String toString(){
			return String.format("l1:%s, l2:%s", this.l1,this.l2);
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
