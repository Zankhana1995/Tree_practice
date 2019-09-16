package ancestor_successor;

class Node5 {
	int data;
	Node5 left, right;

	public Node5(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree_lowestCommomAncestor {
	Node5 root;

	public static void main(String[] args) {
		BinaryTree_lowestCommomAncestor tree = new BinaryTree_lowestCommomAncestor();
		tree.root = new Node5(20);
		tree.root.left = new Node5(8);
		tree.root.right = new Node5(22);
		tree.root.left.left = new Node5(4);
		tree.root.left.right = new Node5(12);
		tree.root.left.right.left = new Node5(10);
		tree.root.left.right.right = new Node5(14);
		int n1 = 12;
		int n2 = 4;
		findLowestcommomAncestor(n1, n2, tree.root);
		// System.out.println(ancestor);

	}

	private static void findLowestcommomAncestor(int n1, int n2, Node5 root) {
		if (n1 == root.data || n2 == root.data) {
			System.out.println(root.data);
			return;
		} else if (n1 < root.data && n2 > root.data) {
			System.out.println(root.data);
			return;
		} else if (n1 > root.data && n2 < root.data) {
			System.out.println(root.data);
			return;
		}
		if (n1 < root.data && n2 < root.data) {
			findLowestcommomAncestor(n1, n2, root.left);
		} else if (n1 > root.data && n2 > root.data) {
			findLowestcommomAncestor(n1, n2, root.right);
		}
	}
}
