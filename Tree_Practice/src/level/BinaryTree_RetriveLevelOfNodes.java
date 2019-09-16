package level;

//retrive level of all nodes of BinaryTree
class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree_RetriveLevelOfNodes {
	Node root;

	public static void main(String[] args) {
		BinaryTree_RetriveLevelOfNodes tree = new BinaryTree_RetriveLevelOfNodes();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		getlevelUtil(tree.root, 5, 1); // here 5 is node and 1 is 1st level (it'll retrive level of node 5
	}

	private static void getlevelUtil(Node root, int node, int level) {
		if (root == null) {
			return;
		} else if (root.data == node) {
			System.out.println("level of node " + node + " is " + level);
		}
		getlevelUtil(root.left, node, level+1);
		getlevelUtil(root.right, node, level+1);
	}

}
