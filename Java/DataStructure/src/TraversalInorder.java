package src;

public abstract class TraversalInorder<E> implements TreeTraversal<E> {

	public TraversalInorder() {
	}
	
	@Override
	public void traversal(TreeNode<E> root) {
		if (root == null) {
			return;
		}
		
		traversal(root.left);
		
		processMidNodeEarly (root);
		
		traversal(root.right);
		
		processMidNodeLate (root);
	}
	
	abstract protected void processMidNodeEarly (TreeNode<E> root);
	abstract protected void processMidNodeLate (TreeNode<E> root);

}
