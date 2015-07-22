 

public class MinStack {
	Node top;
	int minValue = Integer.MAX_VALUE;
	public void push(int x) {
		Node newTop = new Node(x);
		newTop.next = this.top;
		this.top = newTop;
		if (x<minValue){
			this.minValue = x;
		}
	}

	public void pop() {
		if(this.top==null){
			return;
		}
		if(this.top.val<=this.minValue){
			this.minValue=Integer.MAX_VALUE;
			Node curr = this.top.next;  
			while(curr!=null){
				if(curr.val<this.minValue){
					this.minValue = curr.val;
				}
				curr = curr.next; 
			}
		}
		this.top = this.top.next;
	}

	public int top() {
		if(this.top==null){
			return 0;
		}
		else{
			return top.val;
		}
	}

	public int getMin() {
		return this.minValue;
	}

	class Node {
		int val;
		Node next;

		Node(int x) {
			val = x;
		}
	}
	
	
}
