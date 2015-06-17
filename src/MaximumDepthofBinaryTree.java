
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null){
        	return 0;
        }
        Depth dep = new Depth();
        dep.val = 1;
        dep.max = 1;        
        this.recurDepth(root, dep);
        return dep.max;
    }
    
    public void recurDepth(TreeNode node,Depth dep){
    	if(node.left!=null){
    		dep.val ++;
    		if(dep.val>dep.max){
    			dep.max=dep.val;
    		}
    		this.recurDepth(node.left, dep);
    		dep.val--;
    	}
    	if(node.right!=null){
    		dep.val ++;
    		if(dep.val>dep.max){
    			dep.max=dep.val;
    		}
    		this.recurDepth(node.right, dep);
    		dep.val--;
    	}
    }
    
    class Depth{
    	int val;
    	int max;
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
//    		if (this.val != otherT.val) {
//    			return false;
//    		}
//    		if (this.left == null && otherT.left != null) {
//    			return false;
//    		}
//    		if (this.left != null && !this.left.equals(otherT.left)) {
//    			return false;
//    		}
//    		if (this.right == null && otherT.right != null) {
//    			return false;
//    		}
//    		if (this.right != null && !this.right.equals(otherT.right)) {
//    			return false;
//    		}
//    		return true;
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
