package topView;

import java.util.Scanner;

//20 8 22 4 12 10 14 26
class Node3 {
	int data;
	Node3 right, left;

	public Node3(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree_TopView {
	Node3 root;
	static int min, max = 0;

	public static void main(String[] args) {
		BinaryTree_TopView tree = new BinaryTree_TopView();
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split("\\s+");
		tree.root = new Node3(Integer.parseInt(line[0]));
		for (int i = 1; i < line.length; i++) {
			insertIntotree(tree.root, Integer.parseInt(line[i]));
		}
		printInOrder(tree.root);
		findHorizontallength(tree.root, 0);
		topView(tree.root);
		sc.close();
	}

	private static void topView(Node3 root) {
		for (int i = min; i <= max; i++) {
			printTopView(root, i, 0);
			System.out.println();
		}
	}

	private static void printTopView(Node3 root, int i, int current) {
		if (root == null) {
			return;
		}
		if (i == current) {
			System.out.print(root.data);
			return;
		}
		printTopView(root.left, i, current - 1);
		printTopView(root.right, i, current + 1);
	}

	private static void printInOrder(Node3 root) {
		if (root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.println(root.data);
		printInOrder(root.right);
	}

	private static void insertIntotree(Node3 root, int element) {
		Node3 newNode = new Node3(element);
		if (root.left == null) {
			if (root.data > element) {
				root.left = newNode;
				return;
			}
		}
		if (root.right == null) {
			if (root.data < element) {
				root.right = newNode;
				return;
			}
		}
		if (root.data > element) {
			insertIntotree(root.left, element);

		} else if (root.data < element) {
			insertIntotree(root.right, element);

		}
	}

	private static void findHorizontallength(Node3 root, int current) {
		if (root == null) {
			return;
		}
		if (current < min) {
			min = current;
		} else if (current > max) {
			max = current;
		}
		findHorizontallength(root.left, current - 1);
		findHorizontallength(root.right, current + 1);

	}
}
