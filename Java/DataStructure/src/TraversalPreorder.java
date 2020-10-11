package src;

public abstract class TraversalPreorder<E> implements TreeTraversal<E> {

	public TraversalPreorder() {
	}
	
	@Override
	public void traversal(TreeNode<E> root) {
		if (root == null) {
			return;
		}
		processMidNodeEarly (root);
		
		traversal(root.left);
		traversal(root.right);
		
		processMidNodeLate (root);
	}
	
	abstract protected void processMidNodeEarly (TreeNode<E> root);
	abstract protected void processMidNodeLate (TreeNode<E> root);

}
