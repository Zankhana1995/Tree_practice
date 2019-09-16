package insertion;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
	}
}

public class BinaryTree_Node_Search_Insertion {
	Node root;

	public static void main(String[] args) {
		BinaryTree_Node_Search_Insertion tree = new BinaryTree_Node_Search_Insertion();
		tree.root = new Node(50);
		insertIntoTree(tree.root, 30);
		insertIntoTree(tree.root, 35);
		insertIntoTree(tree.root, 15);
		insertIntoTree(tree.root, 60);
		printInOrder(tree.root);
	}

	private static void printInOrder(Node root) {
		if (root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.println(root.data);
		printInOrder(root.right);
	}

	private static void insertIntoTree(Node root, int element) {
		Node newNode = new Node(element);
		if (root.left == null) {
			if (root.data > element) {
				root.left = newNode;
			}
		}
		if (root.right == null) {
			if (root.data < element) {
				root.right = newNode;
			}
		}
		if (root.data > element) {
			insertIntoTree(root.left, element);

		} else if (root.data < element) {
			insertIntoTree(root.right, element);

		}
	}
}
