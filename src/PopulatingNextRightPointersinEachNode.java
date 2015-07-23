/*
 Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
import java.util.List;

import core.Util;

public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			this.recurseRightConnect(root.right, root);
			this.recurseLeftConnect(root.left, root);
		}
	}

	void recurseRightConnect(TreeLinkNode node, TreeLinkNode parent) {
		parent = parent.next;
		if (parent == null) {
		}
		else {
			node.next = parent.left;
		}
		if (node.left != null) {
			this.recurseRightConnect(node.right, node);
			this.recurseLeftConnect(node.left, node);
		}
	}

	void recurseLeftConnect(TreeLinkNode node, TreeLinkNode parent) {
		node.next = parent.right;
		if (node.left != null) {
			this.recurseRightConnect(node.right, node);
			this.recurseLeftConnect(node.left, node);
		}
	}

	public static void main(String[] args) {
		PopulatingNextRightPointersinEachNode ins = new PopulatingNextRightPointersinEachNode();
		TreeLinkNode input = ins.new TreeLinkNode(1);
		input.left = ins.new TreeLinkNode(2);
		input.left.right = ins.new TreeLinkNode(3);
		input.left.right.left = ins.new TreeLinkNode(4);
		input.right = ins.new TreeLinkNode(5);
		input.right.left = ins.new TreeLinkNode(6);
		input.right.right = ins.new TreeLinkNode(7);
		String result = "[1,2,3,4,5,6,7]";
		Util.printInput(input);
		ins.connect(input);
		// Util.printResult(ins.listToString(ins.preorderTraversal(input)),
		// result);
	}

	private <T> String listToString(List<T> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if (i < list.size() - 1) {
				sb.append(",");
			}
		}
		return '[' + sb.toString() + ']';

	}

	class TreeLinkNode {
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;

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
}
