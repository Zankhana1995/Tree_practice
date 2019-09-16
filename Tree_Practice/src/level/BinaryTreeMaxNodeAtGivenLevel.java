package level;

class Node1 {
	int data;
	Node1 left, right;

	public Node1(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTreeMaxNodeAtGivenLevel {
	Node1 root;
	static int max = 0;
	public static void main(String[] args) {
		BinaryTreeMaxNodeAtGivenLevel bt1 = new BinaryTreeMaxNodeAtGivenLevel();
		bt1.root = new Node1(1);
		bt1.root.left = new Node1(2);
		bt1.root.right = new Node1(3);
		bt1.root.left.left = new Node1(4);
		bt1.root.left.right = new Node1(5);
		bt1.root.right.left = new Node1(6);
		bt1.root.right.right = new Node1(7);
		bt1.root.right.left.right = new Node1(8);
		int level = 3;
		int current = 1;
		
		System.out.println(getMaxAtlevel(bt1.root, level, current));
	}

	private static int getMaxAtlevel(Node1 root, int level, int current) {
		
		if (root == null) {
			return 0;
		}
		if (level == current) {
			if (root.data > max) {
				max = root.data;
			}
		}
		getMaxAtlevel(root.left, level, current + 1);
		getMaxAtlevel(root.right, level, current + 1);
		return max;
	}
}
