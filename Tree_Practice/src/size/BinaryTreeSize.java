package size;
//get the size of binary Tree (total element)
class Node {
	int root;
	Node left, right;

	Node(int data) {
		root = data;
		left = right = null;
	}
}

public class BinaryTreeSize {
	Node root;
	static int count=0;
	public static void main(String[] args) {
		BinaryTreeSize bt = new BinaryTreeSize();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.root.right.left.right = new Node(8);
		bt.root.right.right.right = new Node(9);
		System.out.println(getSizeCount(bt.root));
	}
	private static int getSizeCount(Node root) {
		
		if(root==null)
		{
			return 0;
		}
		count++;
		getSizeCount(root.left);
		getSizeCount(root.right);
		//return (1+getSizeCount(root.left)+getSizeCount(root.right))
		return count;
	}
}
