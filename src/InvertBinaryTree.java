import core.Util;


public class InvertBinaryTree {
	public TreeLinkNode invertTree(TreeLinkNode root) {
		this.invert(root);
		return root;
	}

	private void invert(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		this.invert(root.left);
		this.invert(root.right);
		TreeLinkNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static void main(String[] args) {
		InvertBinaryTree ins = new InvertBinaryTree();
		TreeLinkNode root = new TreeLinkNode(1); 
		root.left = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(3);
		root.left.right = new TreeLinkNode(4); 
		TreeLinkNode expect = new TreeLinkNode(1);
		expect.right = new TreeLinkNode(2);
		expect.right.right = new TreeLinkNode(3);
		expect.right.left = new TreeLinkNode(4);
		Util.printInput(root);
		Util.printResult(ins.invertTree(root), expect);
	}
}


class TreeLinkNode {
	int val;
	TreeLinkNode left;
	TreeLinkNode right;

	TreeLinkNode(int x) {
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
		if (!(oth instanceof TreeLinkNode)) {
			return false;
		}
		TreeLinkNode otherT = (TreeLinkNode) oth;
		
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
		TreeLinkNode clone = new TreeLinkNode(this.val);
		if (this.left != null) {
			clone.left = (TreeLinkNode) this.left.clone();
		}
		if (this.right != null) {
			clone.right = (TreeLinkNode) this.right.clone();
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