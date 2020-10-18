package src;

public abstract class TraversalPostorder<E> implements TreeTraversal<E> {

	public TraversalPostorder() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void traversal(TreeNode<E> root) {
		if (root == null) {
			return;
		}
		
		traversal(root.left);
		traversal(root.right);
		processMidNodeEarly (root);
		
		processMidNodeLate (root);
	}
	
	abstract protected void processMidNodeEarly (TreeNode<E> root);
	abstract protected void processMidNodeLate (TreeNode<E> root);
}
