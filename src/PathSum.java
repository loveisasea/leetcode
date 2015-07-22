/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		return this.isSum(root, sum, 0);
	}

	private boolean isSum(TreeNode node, int sum, int tot) {
		if (node == null) {
			return false;
		}
		int newtot = tot + node.val;
		if (node.left == null && node.right == null) {
			return sum == newtot;
		}
		if (node.left != null) {
			boolean succeed = this.isSum(node.left, sum, newtot);
			if (succeed) {
				return true;
			}
		}
		if (node.right != null) {
			boolean succeed = this.isSum(node.right, sum, newtot);
			if (succeed) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
//		PathSum ins = new PathSum();
		

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
