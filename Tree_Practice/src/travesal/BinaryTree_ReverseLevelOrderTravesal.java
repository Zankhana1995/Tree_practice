package travesal;

class Node5 {
	int data;
	Node5 left, right;

	public Node5(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree_ReverseLevelOrderTravesal {
	Node5 root;

	public static void main(String[] args) {
		BinaryTree_ReverseLevelOrderTravesal tree = new BinaryTree_ReverseLevelOrderTravesal();
		tree.root = new Node5(20);
		tree.root.left = new Node5(8);
		tree.root.right = new Node5(22);
		tree.root.left.left = new Node5(4);
		tree.root.left.right = new Node5(12);
		tree.root.left.right.left = new Node5(10);
		tree.root.left.right.right = new Node5(14);
		int height = findheight(tree.root);
		printReverseOrderTraversal(tree.root, height);
	}

	private static void printReverseOrderTraversal(Node5 root, int height) {
		if (root == null) {
			return;
		}
		for (int i = height; i > 0; i--) {
			recursiveMethod(i, root);
			System.out.println();
		}
	}

	private static void recursiveMethod(int i, Node5 root) {
		if (root == null) {
			return;
		}
		if (i == 1) {
			System.out.print(root.data);
		}
		recursiveMethod(i - 1, root.left);
		recursiveMethod(i - 1, root.right);
	}

	private static int findheight(Node5 root) {
		int leftHeight = 1;
		int rightheight = 1;
		if (root == null) {
			return 0;
		}
		leftHeight += findheight(root.left);
		rightheight += findheight(root.right);
		return Math.max(leftHeight, rightheight);
	}
}
