

public class ImplementStackusingQueues {
	Node top; 
	public void push(int x) {
		Node newTop = new Node(x);
		newTop.next = this.top;
		this.top = newTop; 
	}

	public void pop() {
		if(this.top==null){
			return;
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
 
    public boolean empty() {
        return top==null;
    }

	class Node {
		int val;
		Node next;

		Node(int x) {
			val = x;
		}
	}
}
