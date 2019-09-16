package bst;

//given tree is complete binarytree or not ( 0 child or 2 child)
// left node index = 2*index + 1
//right node index = 2*index + 2
class Node2 {
	int data;
	Node2 left, right;

	public Node2(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinarytreeIsCompleteOrNot {
	Node2 root;

	public static void main(String[] args) {
		BinarytreeIsCompleteOrNot tree = new BinarytreeIsCompleteOrNot();
		tree.root = new Node2(1);
		tree.root.left = new Node2(2);
		tree.root.right = new Node2(3);
		tree.root.left.right = new Node2(5);
		tree.root.left.left = new Node2(4);
		tree.root.right.right = new Node2(6);
	//	tree.root.right.left = new Node2(7);
		int totalElements = numberOfElementInTree(tree.root);
		int current = 0;
		boolean result = isCompleteOrNot(totalElements, tree.root, current);
		System.out.println(result);
		// my method easy one
		boolean result1 = isCompleteOrNot1(tree.root);
		System.out.println(result1);

	}

	private static boolean isCompleteOrNot(int totalElements, Node2 root, int current) {
		// An empty tree is complete
		if (root == null) {
			return true;
		}
		if (current >= totalElements) {
			return false;
		}
		return isCompleteOrNot(totalElements, root.left, current * 2 + 1)
				&& isCompleteOrNot(totalElements, root.right, current * 2 + 2);
	}

	// my method (both child are not null or both child are null) if this condition
	// is false than return false
	private static boolean isCompleteOrNot1(Node2 root) {
		if (root == null) {
			return true;
		}
		if (!((root.right != null && root.left != null) || (root.right == null && root.left == null))) {
			return false;
		}
		// both result should be satisfied with && condition bcz we have to see both
		// subtree
		return isCompleteOrNot1(root.left)
				&& isCompleteOrNot1(root.right);

	}
//this is not require for solution 2(my solution)
	private static int numberOfElementInTree(Node2 root) {
		if (root == null) {
			return 0;
		}
		return (1 + numberOfElementInTree(root.left) + numberOfElementInTree(root.right));
	}
}
