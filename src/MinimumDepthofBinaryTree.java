import java.util.Stack;

import core.Util;

/*
 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root 
 node down to the nearest leaf node.
 */

public class MinimumDepthofBinaryTree {

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int depth = 1;
		Stack<NodeDept> stack = new Stack<NodeDept>();
		TreeNode head = root;
		do {
			if (head.left != null) {
				stack.push(new NodeDept(head, depth));
				depth++;
				head = head.left;
			}
			else if (head.right != null) {
				depth++;
				head = head.right;
			}
			else {
				min = min < depth ? min : depth;
				do {
					if (stack.size() == 0) {
						break;
					}
					NodeDept nodedept = stack.pop();
					depth = nodedept.depth;
					head = nodedept.node;
				} while (head.right == null);
				if (head.right == null) {
					break;
				}
				depth++;
				head = head.right;
			}
		} while (stack.size() >= 0);

		return min;
	}

	class NodeDept {
		TreeNode node;
		int depth;

		public NodeDept(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	// recursive method
	// public int minDepth(TreeNode root) {
	// if(root==null){
	// return 0;
	// }
	// return this.getMinDepth(root, 0);
	// }
	//
	// private int getMinDepth(TreeNode node, int tot) {
	// tot++;
	// if(node.left==null && node.right==null){
	// return tot;
	// }
	// int min = Integer.MAX_VALUE;
	// if (node.left != null) {
	// int mt = this.getMinDepth(node.left, tot);
	// min = min < mt ? min : mt;
	// }
	// if (node.right != null) {
	// int mt = this.getMinDepth(node.left, tot);
	// min = min < mt ? min : mt;
	// }
	// return min;
	// }

	public static void main(String[] args) {
		MinimumDepthofBinaryTree ins = new MinimumDepthofBinaryTree();

		TreeNode input = null;

		input = ins.new TreeNode(1);
		input.left = ins.new TreeNode(2);
		input.left.right = ins.new TreeNode(3);
		input.left.right.left = ins.new TreeNode(4);
		input.left.right.right = ins.new TreeNode(5);
		input.right = ins.new TreeNode(6);
		Util.printInput(input);
		Util.printResult(ins.minDepth(input), 2);

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
