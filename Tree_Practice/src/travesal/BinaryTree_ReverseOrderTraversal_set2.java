package travesal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Node6 {
	int data;
	Node6 left, right;

	public Node6(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree_ReverseOrderTraversal_set2 {
	Node6 root;

	public static void main(String[] args) {
		BinaryTree_ReverseOrderTraversal_set2 tree = new BinaryTree_ReverseOrderTraversal_set2();
		tree.root = new Node6(20);
		tree.root.left = new Node6(8);
		tree.root.right = new Node6(22);
		tree.root.left.left = new Node6(4);
		tree.root.left.right = new Node6(12);
		tree.root.left.right.left = new Node6(10);
		tree.root.left.right.right = new Node6(14);
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		int current = 1;
		printTreeinReverseOrder(tree.root, current, map);
		int mapSize = map.size();
		for (int i = mapSize; i > 0; i--) {
			List<Integer> lst = map.get(i);
			for (int j : lst) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

	private static void printTreeinReverseOrder(Node6 root, int current, Map<Integer, List<Integer>> map) {
		if (root == null) {
			return;
		}
		if (current == 1) {
			List<Integer> li = new ArrayList<>();
			li.add(root.data);
			map.put(current, li);
		} else if (map.containsKey(current)) {
			List<Integer> li = map.get(current);
			li.add(root.data);
			map.put(current, li);
		} else {
			List<Integer> li = new ArrayList<>();
			li.add(root.data);
			map.put(current, li);
		}
		printTreeinReverseOrder(root.left, current + 1, map);
		printTreeinReverseOrder(root.right, current + 1, map);
	}
}
