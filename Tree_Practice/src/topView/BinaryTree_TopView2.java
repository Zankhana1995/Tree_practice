package topView;
//Print a Binary Tree in Vertical Order | Set 1
class Node1 {
	int data;
	Node1 left, right;

	public Node1(int data) {
		this.data = data;
		left = right = null;
	}
}
class values
{
	int min,max;
}

public class BinaryTree_TopView2 {
	Node1 root;
	values val = new values();

	public static void main(String[] args) {
		BinaryTree_TopView2 bt1 = new BinaryTree_TopView2();		
		bt1.root = new Node1(1);
		bt1.root.left = new Node1(2);
		bt1.root.right = new Node1(3);
		bt1.root.left.left = new Node1(4);
		bt1.root.left.right = new Node1(5);
		bt1.root.right.left = new Node1(6);
		bt1.root.right.right = new Node1(7);
		bt1.root.right.left.right = new Node1(8);
		bt1.root.right.right.right = new Node1(9);
		bt1.verticleOrder(bt1.root);
	}

	private void verticleOrder(Node1 root) {
		findMinMax(root, val , val, 0);
		for (int i = val.min; i <= val.max; i++) {
			printVertical(root, i, 0);
			System.out.println();
		}

	}
	private void printVertical(Node1 root, int i, int current) {
		if (root == null) {
			return;
		}
		if(i==current)
		{
			System.out.print(root.data);
		}
		printVertical(root.left, i, current-1);
		printVertical(root.right, i, current+1);
	}
	private void findMinMax(Node1 root,values min, values max, int current) {
		if (root == null) {
			return;
		}
		if (current < min.min) {
			min.min = current;
		} else if (current > max.max) {
			max.max = current;
		}
		findMinMax(root.left, min, max, current - 1);
		findMinMax(root.right, min, max, current + 1);
	}
}
