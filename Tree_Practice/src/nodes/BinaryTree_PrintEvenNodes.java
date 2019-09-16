package nodes;

import java.util.ArrayList;
import java.util.List;

class Node2 {
	int data;
	Node2 right, left;

	public Node2(int data) {
		this.data = data;
		right = left = null;
	}
}

public class BinaryTree_PrintEvenNodes {
	Node2 root;

	public static void main(String[] args) {
		BinaryTree_PrintEvenNodes tree = new BinaryTree_PrintEvenNodes();
		tree.root = new Node2(20);
		tree.root.left = new Node2(8);
		tree.root.right = new Node2(22);
		tree.root.left.left = new Node2(3);
		tree.root.left.right = new Node2(12);
		tree.root.left.right.left = new Node2(11);
		tree.root.left.right.right = new Node2(14);
		List<Integer> evenlist = new ArrayList<>();
		printevenNodes(tree.root,evenlist);
		System.out.println(evenlist);
	}
	

	private static void printevenNodes(Node2 root, List<Integer> evenlist) {
		if(root==null)
		{
			return;
		}
		if(root.data%2==0)
		{
			evenlist.add(root.data);
		}
		printevenNodes(root.left, evenlist);
		printevenNodes(root.right, evenlist);
	}
}
