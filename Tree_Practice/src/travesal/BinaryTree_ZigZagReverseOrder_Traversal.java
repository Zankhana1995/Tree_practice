package travesal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Node7 {
	int data;
	Node7 left, right;

	public Node7(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree_ZigZagReverseOrder_Traversal {
	Node7 root;

	public static void main(String[] args) {
		BinaryTree_ZigZagReverseOrder_Traversal tree = new BinaryTree_ZigZagReverseOrder_Traversal();
		tree.root = new Node7(20);
		tree.root.left = new Node7(8);
		tree.root.right = new Node7(22);
		tree.root.right.left = new Node7(21);
		tree.root.right.right = new Node7(23);
		tree.root.left.left = new Node7(4);
		tree.root.left.right = new Node7(12);
		tree.root.left.right.left = new Node7(10);
		tree.root.left.right.right = new Node7(14);
		
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		int current = 1;
		printTreeinReverseOrder(tree.root, current, map);
		int mapSize = map.size();
		int counter = 1;
		for (int i = mapSize; i > 0; i--) {
			List<Integer> lst = map.get(i);

			if (counter % 2 != 0) {
				for (int j : lst) {
					System.out.print(j +" ");
				}
			} else {
				for (int j = lst.size()-1; j >= 0; j--) {
					System.out.print(lst.get(j)+" ");
				}
			}
			counter++;
			System.out.println();
		}
	}

	private static void printTreeinReverseOrder(Node7 root, int current, Map<Integer, List<Integer>> map) {
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
