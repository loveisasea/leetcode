import core.Util;


public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		this.invert(root);
		return root;
	}

	private void invert(TreeNode root) {
		if (root == null) {
			return;
		}
		this.invert(root.left);
		this.invert(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static void main(String[] args) {
		InvertBinaryTree ins = new InvertBinaryTree();
		TreeNode root = new TreeNode(1); 
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4); 
		TreeNode expect = new TreeNode(1);
		expect.right = new TreeNode(2);
		expect.right.right = new TreeNode(3);
		expect.right.left = new TreeNode(4);
		Util.printInput(root);
		Util.printResult(ins.invertTree(root), expect);
	}
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
//		if (this.val != otherT.val) {
//			return false;
//		}
//		if (this.left == null && otherT.left != null) {
//			return false;
//		}
//		if (this.left != null && !this.left.equals(otherT.left)) {
//			return false;
//		}
//		if (this.right == null && otherT.right != null) {
//			return false;
//		}
//		if (this.right != null && !this.right.equals(otherT.right)) {
//			return false;
//		}
//		return true;
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