package src;

public interface Tree<E> {
	
	boolean search (E element);
	void insert (TreeNode<E> node);
	void traverse (TreeTraversal<E> traversal);
}
