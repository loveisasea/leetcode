import java.util.List;

/*
 Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		if(root==null){
			return;
		}
		if (root.right != null) {
			this.recurseRightConnect(root.right, root);
		}
		if (root.left != null) {
			this.recurseLeftConnect(root.left, root);
		}
	}
	
	void recurseRightConnect(TreeLinkNode node, TreeLinkNode parent) {
		while (true) {
			parent = parent.next;
			if (parent == null) {
				break;
			} 
			if (parent.left != null) {
				node.next = parent.left;
				break;
			}
			else if (parent.right != null) {
				node.next = parent.right;
				break;
			}
		}
		if (node.right != null) {
			this.recurseRightConnect(node.right, node);
		}
		if (node.left != null) {
			this.recurseLeftConnect(node.left, node);
		}

	}
	

	void recurseLeftConnect(TreeLinkNode node, TreeLinkNode parent) {
		if (parent.right != null) {
			node.next = parent.right;
		}
		else {
			while (true) {
				parent = parent.next;
				if (parent == null) {
					break;
				} 
				if (parent.left != null) {
					node.next = parent.left;
					break;
				}
				else if (parent.right != null) {
					node.next = parent.right;
					break;
				}
			}
		}
		if (node.right != null) {
			this.recurseRightConnect(node.right, node);
		}
		if (node.left != null) {
			this.recurseLeftConnect(node.left, node);
		}

	}

	
	public static void main(String[] args){
		PopulatingNextRightPointersinEachNodeII ins  = new PopulatingNextRightPointersinEachNodeII();
		TreeLinkNode root = ins.new TreeLinkNode(1);
		root.left = ins.new TreeLinkNode(2);
		root.right = ins.new TreeLinkNode(3);
		root.left.left = ins.new TreeLinkNode(4);
		root.right.right = ins.new TreeLinkNode(5);
		
		ins.connect(root);
	}

	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
	
	
}

// Definition for binary tree with next pointer.

