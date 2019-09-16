package insertion;

import java.util.LinkedList;
import java.util.Queue;

//Given a binary tree and a key, insert the key into the binary tree at 
//first position available in level order.
class Node2 {
	int data;
	Node2 left, right;

	public Node2(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree_LevelOrder_Insertion {
	Node2 root;

	public static void main(String[] args) {
		BinaryTree_LevelOrder_Insertion tree = new BinaryTree_LevelOrder_Insertion();
		tree.root = new Node2(20);
		tree.root.left = new Node2(8);
		tree.root.right = new Node2(22);
		tree.root.left.left = new Node2(4);
		tree.root.left.right = new Node2(12);
		tree.root.right.right = new Node2(25);
		// tree.root.right.left = new Node2(21);
		int nodevalue = 21;
		insertLevelorderIntoTree(tree.root, nodevalue);
		printInOrder(tree.root);
	}

	private static void printInOrder(Node2 root) {
		if (root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.println(root.data);
		printInOrder(root.right);
	}

	private static void insertLevelorderIntoTree(Node2 root, int nodevalue) {

		Node2 newNode = new Node2(nodevalue);
		Queue<Node2> q = new LinkedList<Node2>();
		q.add(root);
		while (q.size() != 0) {
			root = q.poll();
			if (root.left == null) {
				root.left = newNode;
				break;
			} else {
				q.add(root.left);
			}
			if (root.right == null) {
				root.right = newNode;
				break;
			} else {
				q.add(root.right);
			}
		}
	}
}
