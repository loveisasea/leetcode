import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
 
import core.Util;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) { 
		List<Integer> ret = new ArrayList<Integer>(); 
		if (root==null){
			return ret;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode head = root;
		do{ 
			ret.add(head.val);
			if(head.left!=null){ 
				stack.push(head);
				head = head.left;
			}
			else{ 
				if(head.right!=null){ 
					head = head.right; 
				}
				else{  
					do{
						if(stack.size()==0){
							break;
						}
						head = stack.pop(); 
					}while(head.right==null); 
					if(head.right==null){
						break;
					}
					head = head.right;
				} 
			}
		}while(stack.size()>=0);
		
		return ret;
	}
	
	public static void main(String[] args) {
		BinaryTreePreorderTraversal ins = new BinaryTreePreorderTraversal();
		TreeNode input = ins.new TreeNode(1);
		input.left = ins.new TreeNode(2);
		input.left.right = ins.new TreeNode(3);
		input.left.right.left = ins.new TreeNode(4);
		input.right = ins.new TreeNode(5); 
		input.right.left = ins.new TreeNode(6); 
		input.right.right = ins.new TreeNode(7); 
		String result = "[1,2,3,4,5,6,7]";
		Util.printInput(input); 
		Util.printResult(ins.listToString(ins.preorderTraversal(input)), result);
	}
	
	private <T> String listToString(List<T> list){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++){
			sb.append(list.get(i));
			if(i<list.size()-1){
				sb.append(",");
			}
		}
		return '[' + sb.toString() + ']';
		
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public boolean equals(Object oth) {
			if (oth == null) {
				return false;
			}
			if (oth == this) {
				return true;
			}
			if (!(oth instanceof TreeNode)) {
				return false;
			}
			TreeNode otherT = (TreeNode) oth;

			return this.toString().equals(otherT.toString());
			// if (this.val != otherT.val) {
			// return false;
			// }
			// if (this.left == null && otherT.left != null) {
			// return false;
			// }
			// if (this.left != null && !this.left.equals(otherT.left)) {
			// return false;
			// }
			// if (this.right == null && otherT.right != null) {
			// return false;
			// }
			// if (this.right != null && !this.right.equals(otherT.right)) {
			// return false;
			// }
			// return true;
		}

		@Override
		public Object clone() {
			TreeNode clone = new TreeNode(this.val);
			if (this.left != null) {
				clone.left = (TreeNode) this.left.clone();
			}
			if (this.right != null) {
				clone.right = (TreeNode) this.right.clone();
			}
			return clone;
		}

		@Override
		public String toString() {
			return String.format("[%s,l:%s,r:%s]",
					val,
					this.left != null ? this.left.toString() : "null",
					this.right != null ? this.right.toString() : "null");
		}
	}
}
