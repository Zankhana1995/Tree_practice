package travesal;

class Node4 {
	int data;
	Node4 right, left;

	public Node4(int data) {
		this.data = data;
	}
}

public class BinaryTree_LevelOrderTravesal {
	Node4 root;

	public static void main(String[] args) {
		BinaryTree_LevelOrderTravesal tree = new BinaryTree_LevelOrderTravesal();
		tree.root = new Node4(20);
		tree.root.left = new Node4(8);
		tree.root.right = new Node4(22);
		tree.root.left.left = new Node4(4);
		tree.root.left.right = new Node4(12);
		tree.root.left.right.left = new Node4(10);
		tree.root.left.right.right = new Node4(14);
	//	int current = 1;
		printLevelBylevelNodes(tree.root);
	}

	private static void printLevelBylevelNodes(Node4 root) {
		if (root == null) {
			return;
		}
		int height = heightOfTree(root);
		for (int i = 1; i <= height; i++) {
			printLevelOrdernodes(root, i);
			System.out.println();
		}
	}

	private static void printLevelOrdernodes(Node4 root, int i) {
		if (root == null) {
			return;
		}
		if (i == 1)
			System.out.print(root.data);
		else if (i > 1) {
			printLevelOrdernodes(root.left, i - 1);
			printLevelOrdernodes(root.right, i - 1);
		}
	}

	private static int heightOfTree(Node4 root) {
		int leftheight = 1;
		int rightheight = 1;
		if (root == null) {
			return 0;
		}
		leftheight += heightOfTree(root.left);
		rightheight += heightOfTree(root.right);
		return Math.max(leftheight-1, rightheight-1);

	}
}
