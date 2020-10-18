package problems;

import java.util.Scanner;

import src.TraversalInorder;
import src.TraversalPreorder;
import src.TreeNode;
import src.TreeTraversal;

public class Problem5_7 {

	
	static String inorder =  "1 2 3 5 6 9 12 13 14 15 16 17 18";
	static String preorder = "9 5 2 1 3 6 15 13 12 14 17 16 18";
	
	public static void main(String[] args) {
		TreeNode<Integer> tree = constructNode (inorder, preorder);
		TreeTraversal<Integer> treePrinter = new PrintPreorder<Integer> ();
		TreeTraversal<Integer> treePrinter2 = new PrintInorder<Integer> ();

		treePrinter.traversal(tree);
		System.out.println();
		treePrinter2.traversal(tree);
	}
	

	public static TreeNode<Integer> constructNode (String inorder, String preorder) {
		Scanner preorderScanner = new Scanner (preorder);
		String[] inorderStringArray = inorder.split(" ");
		int[] inorderArray = new int[inorderStringArray.length];
		try {
			for (int i = 0; i < inorderStringArray.length; i ++) {
				inorderArray[i] = Integer.parseInt(inorderStringArray[i]);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return constructNode(inorderArray, 0, inorderStringArray.length, preorderScanner, 0);
	}
	
	public static TreeNode<Integer> constructNode (int[] inorderArray, int start, int end, Scanner preorderScanner, int count) {
		if (!preorderScanner.hasNextInt() || end <= start) {
			return null;
		}
		
		Integer midValue = preorderScanner.nextInt();
		TreeNode<Integer> mid = createNode(midValue);
		int midPosition = search(inorderArray, midValue, start, end);		

		//Do the left
		TreeNode<Integer> leftNode = constructNode (inorderArray, start, midPosition, preorderScanner, count+1);
		//Do the right
		TreeNode<Integer> rightNode = constructNode (inorderArray, midPosition + 1, end, preorderScanner, count+1);
		
		mid.left = leftNode;
		mid.right = rightNode;
		return mid;
	}
	
	
	
	private static int search(int[] inorderArray, Integer midValue, int start, int end) {
		for (int i = start; i < end; i ++) {
			if (inorderArray[i] == midValue) {
				return i;
			}
		}
		return -1;
	}


	public static TreeNode<Integer> createNode (int nodeValue) {
			TreeNode<Integer> node = new TreeNode<Integer>();
			node.value = nodeValue;
			
			return node;
	}
}

class PrintPreorder<integer> extends TraversalPreorder<Integer> {

	@Override
	protected void processMidNodeEarly(TreeNode<Integer> root) {
		System.out.print(root.value + " ");
	}

	@Override
	protected void processMidNodeLate(TreeNode<Integer> root) {
		
	}
	

}

class PrintInorder<integer> extends TraversalInorder<Integer> {

	@Override
	protected void processMidNodeEarly(TreeNode<Integer> root) {
		System.out.print(root.value + " ");
	}

	@Override
	protected void processMidNodeLate(TreeNode<Integer> root) {
		
	}
	

}
