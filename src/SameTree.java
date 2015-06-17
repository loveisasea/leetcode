/*
 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 */

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return this.recursiveSame(p, q);
	}

	public boolean recursiveSame(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null && q != null) {
			return false;
		} else if (p != null && q == null) {
			return false;
		}
		else if (p.val != p.val) {
			return false;
		}
		else if (!this.recursiveSame(p.left, q.left)) {
			return false;
		}
		else if (!this.recursiveSame(p.right, q.right)) {
			return false;
		}
		return true;
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
