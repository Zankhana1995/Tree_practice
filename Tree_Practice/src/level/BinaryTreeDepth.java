package level;
//find depth of binary tree from any side(left or right) which one is max
class Node2 {
	int data;
	Node2 left, right;

	public Node2(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTreeDepth {
	Node2 root;

	public static void main(String[] args) {

		BinaryTreeDepth bt2 = new BinaryTreeDepth();
		bt2.root = new Node2(1);
		bt2.root.left = new Node2(2);
		bt2.root.right = new Node2(3);
		bt2.root.left.left = new Node2(4);
		bt2.root.left.right = new Node2(5);
		bt2.root.left.left.left = new Node2(7);
		System.out.println(findDepth(bt2.root));
	}

	private static int findDepth(Node2 root) {
		int leftdepth = 1;
		int rightDepth = 1;
		if (root == null) {
			return 0;
		}
		leftdepth += findDepth(root.left);
		rightDepth += findDepth(root.right);
		return Math.max(leftdepth, rightDepth);
	}
}
