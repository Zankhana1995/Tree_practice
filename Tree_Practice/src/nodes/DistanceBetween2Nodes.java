package nodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 8 3 13 1 7 10 14 6 4
class Node4 {
	int data;
	Node4 left, right;

	Node4(int data) {
		this.data = data;
		left = right = null;
	}
}

public class DistanceBetween2Nodes {
	Node4 root;
	static int ancestor = 0;
	static int distanceofn1 = 0;
	static int distanceofn2 = 0;
	static int distanceFromAncestor = 0;

	public static void main(String[] args) {
		DistanceBetween2Nodes tree = new DistanceBetween2Nodes();
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split("\\s+");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < line.length; i++) {
			list.add(Integer.parseInt(line[i]));
		}

		tree.root = new Node4(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			addToTree(tree.root, list.get(i));
		}
		commonAncestor(tree.root, 10, 14);
	//	System.out.println(ancestor);
		int level = 1;
		distanceofn1toroot(tree.root, 10, level);
		distanceofn2toroot(tree.root, 14, level);
		distanceOfAncestorToRoot(tree.root, ancestor, level);
		int distanceBetween2Nodes = distanceofn1 + distanceofn2 - 2 * distanceFromAncestor;
		System.out.println(distanceBetween2Nodes);
		sc.close();
	}

	private static void distanceofn2toroot(Node4 root, int n2, int level) {

		if (root == null) {
			return;
		} else if (root.data == n2) {
			distanceofn2 = level - 1;
		}
		if (n2 < root.data) {
			distanceofn2toroot(root.left, n2, level + 1);
		} else {
			distanceofn2toroot(root.right, n2, level + 1);
		}

	}

	private static void distanceofn1toroot(Node4 root, int n1, int level) {
		if (root == null) {
			return;
		} else if (root.data == n1) {
			distanceofn1 = level - 1;
		}
		if (root.data > n1) {
			distanceofn1toroot(root.left, n1, level + 1);
		} else {
			distanceofn1toroot(root.right, n1, level + 1);
		}
	}

	private static void distanceOfAncestorToRoot(Node4 root, int ancestor, int level) {
		if (root == null) {
			return;
		} else if (root.data == ancestor) {
			distanceFromAncestor = level - 1;
		}
		if (ancestor > root.data) {
			distanceOfAncestorToRoot(root.left, ancestor, level + 1);
		} else {
			distanceOfAncestorToRoot(root.right, ancestor, level + 1);
		}
	}

	private static void commonAncestor(Node4 root, int n1, int n2) {
		if (root.data == n1 || root.data == n2) {
			ancestor = root.data;
		} else if (root.data > n1 && root.data < n2) {
			ancestor = root.data;
		} else if (root.data < n1 && root.data > n2) {
			ancestor = root.data;
		}
		if (root.data > n1 && root.data > n2) {
			commonAncestor(root.left, n1, n2);
		} else if (root.data < n1 && root.data < n2) {
			commonAncestor(root.right, n1, n2);
		}
	}

	private static void addToTree(Node4 root, int number) {
		Node4 newNode = new Node4(number);
		if (root.left == null) {
			if (root.data > number) {
				root.left = newNode;
				return;
			}
		}
		if (root.right == null) {
			if (root.data < number) {
				root.right = newNode;
				return;
			}
		}
		if (root.data > number) {
			addToTree(root.left, number);
		} else {
			addToTree(root.right, number);
		}

	}
}
