package bst;

// In Order, PreOrder, PostOrder traversal of binary tree
class Node3 {
	int data;
	Node3 left, right;

	public Node3(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTreeOrders {
	Node3 root;

	public static void main(String[] args) {
		BinaryTreeOrders tree = new BinaryTreeOrders();
		tree.root = new Node3(1);
		tree.root.left = new Node3(2);
		tree.root.right = new Node3(3);
		tree.root.left.right = new Node3(5);
		tree.root.left.left = new Node3(4);
		tree.root.right.right = new Node3(6);
		tree.root.right.left = new Node3(7);
		System.out.println("PreOrder Traversal");
		preOrder(tree.root);
		System.out.println("\nPostOrder Traversal");
		postOrder(tree.root);
		System.out.println("\nInOrder Traversal");
		inOrder(tree.root);
	}

	private static void inOrder(Node3 root) {
		if (root == null) {
			return;
		} else {
			inOrder(root.left);
			System.out.print(root.data);
			inOrder(root.right);
		}
	}

	private static void postOrder(Node3 root) {
		if (root == null) {
			return;
		} else {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data);
		}
	}

	private static void preOrder(Node3 root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.data);
			preOrder(root.left);			
			preOrder(root.right);
			
		}
	}
}
