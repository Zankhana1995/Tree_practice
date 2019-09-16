package nodes;

import java.util.ArrayList;
import java.util.List;

//print internal nodes of binarytree and count of internal nodes also
class Node {
	int root;
	Node left, right;

	Node(int data) {
		root = data;
		left = right = null;
	}
}

public class BinaryTreeInternalnodes {
	Node root;
	public static void main(String[] args) {
		BinaryTreeInternalnodes bt = new BinaryTreeInternalnodes();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.root.right.left.right = new Node(8);
		bt.root.right.right.right = new Node(9);
		List<Integer> list = new ArrayList<>();
		printInternalNode(bt.root,list);
		System.out.println(list);
		System.out.println("Number of Internal Nodes "+list.size());
	}
	private static void printInternalNode(Node root, List<Integer> list) {
		if(root==null)
		{
			return;
		}
		if(root.left!=null && root.right!=null)
		{
			list.add(root.root);
		}
		printInternalNode(root.left, list);
		printInternalNode(root.right, list);
	}
}
