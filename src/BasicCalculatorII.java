import java.util.Stack;

import core.Util;

public class BasicCalculatorII {

	public int calculate(String s) {
		char[] chars = s.toCharArray();
		int i = 0;
		int len = chars.length;
		int iLeft = -1, lenLeft = 0;
		TreeNode root = new TreeNode(null);
		root.op = '+';
		root.left = new TreeNode(root);
		root.left.val = 0;
		TreeNode curr = root;
		while (i < len) {
			char ch = chars[i];
			if (ch >= '0' && ch <= '9') {
				if (iLeft == -1) {
					iLeft = i;
				}
				lenLeft++;
			}
			else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				int num = this.getInt(chars, iLeft, lenLeft);
				iLeft = -1;
				lenLeft = 0;
				curr.right = new TreeNode(curr);
				curr.right.val = num;
				while (true) {
					if (curr == null) {
						break;
					}
					if (!this.ishigher(curr.op,ch  )) {
						break;
					}
					curr = curr.parent;
				}
				if (curr != null) {
					TreeNode oldRight = curr.right;
					TreeNode newRight = new TreeNode(curr);
					curr.right = newRight;
					newRight.op = ch;
					newRight.left = oldRight;
					oldRight.parent = newRight;
					curr = newRight;
				} else {
					TreeNode oldRoot = root;
					TreeNode newRoot = new TreeNode(null);
					newRoot.op = ch;
					newRoot.left = oldRoot;
					oldRoot.parent = newRoot;
					curr = newRoot;
					root = newRoot;
				}
			}
			i++;
		}
		int num = this.getInt(chars, iLeft, lenLeft);
		curr.right = new TreeNode(curr);
		curr.right.val = num;

		return (int) this.calculate(root);
	}

	public boolean ishigher(char op1, char op2) {
		if ((op1 == '+') || (op1 == '-') && (op2 == '*' || op2 == '/')) {
			return false;
		}
		return true;
	}

	public long calculate(TreeNode root) { 
		Stack<S> stack = new Stack<S>();
		TreeNode head = root; 
		do {
			if (head.left != null) {
				stack.push(new S(head,0,0));
				head = head.left;
				continue;
			}  
			else {
				while(stack.size()>0){
					if(stack.peek().node.right ==head)
					{
						S pop = stack.pop();
						pop.right=head.val;
						pop.node.val = this.calculate(pop.node.op, pop.left, pop.right); 
						head = pop.node;
					}
					else{
						break;
					}					
				}
				if(stack.size()==0){
					return head.val;
				}
				if(stack.peek().node.left ==head){
					stack.peek().left=head.val;
					head = head.parent.right;
					continue;
				} 
			}
		} while (true); 
	}

	public long calculate(char op, long left, long right) {
		if (op == '+') {
			return left + right;
		}
		else if (op == '-') {
			return left - right;
		}
		else if (op == '*') {
			return left * right;
		}
		else {
			return left / right;
		}
	}

	private int getInt(char[] chars, int srt, int len) {
		int i = srt;
		int ret = 0;
		int end = srt + len;
		while (i != end) {
			ret = ret * 10 + (chars[i] - '0');
			i++;
		}
		return ret;
	}

	public static void main(String[] args) {
		BasicCalculatorII ins = new BasicCalculatorII();
		String input = null;

//		input = "3+2*2";
//		Util.printInput(input);
//		Util.printResult(ins.calculate(input), 7);
//
//		input = " 3/2 ";
//		Util.printInput(input);
//		Util.printResult(ins.calculate(input), 1);
//
//		input = " 3+5 / 2 ";
//		Util.printInput(input);
//		Util.printResult(ins.calculate(input), 5);
//
//		input = "1+2*3-4/5*6+7-8";
//		Util.printInput(input);
//		Util.printResult(ins.calculate(input), 6);
//
//		input = "3+2*2";
//		Util.printInput(input);
//		Util.printResult(ins.calculate(input), 7);
		
		input = "100000000/1/2/3/4/5/6/7/8/9/10";
		Util.printInput(input);
		Util.printResult(ins.calculate(input), 7);

	}
	
	class S{
		TreeNode node;
		long left;
		long right;
		
		public S(TreeNode node,long left,long right){
			this.node = node;
			this.left=left;
			this.right=right;
		}
	}

	class TreeNode {
		long val;
		char op;
		TreeNode parent;
		TreeNode left;
		TreeNode right;

		public TreeNode(TreeNode parent) {
			this.parent = parent;
		}

		@Override
		public String toString() {
			if (this.op == 0x00000000) {
				return String.valueOf(this.val);
			} else {
				return String.format("(%s %s %s)",
						this.left == null ? "?" : this.left.toString(),
						this.op,
						this.right == null ? "?" : this.right.toString());
			}
		}

	}
}
