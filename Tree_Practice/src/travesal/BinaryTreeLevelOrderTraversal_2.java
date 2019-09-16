package travesal;

//Level Order Tree Traversal
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTreeLevelOrderTraversal_2 {
	Node root;

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal_2 tree = new BinaryTreeLevelOrderTraversal_2();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder(tree.root);
	}

	private void printLevelOrder(Node root) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int current = 0;
		getlevel(root, current, map);
		for (Entry<Integer, List<Integer>> e : map.entrySet()) {
			for (Integer i : e.getValue()) {
				System.out.print(i);
			}
		}

	}

	private void getlevel(Node root, int current, Map<Integer, List<Integer>> map) {
		if (root == null) {
			return;
		} else if (current == 0) {
			List<Integer> list = new ArrayList<>();
			list.add(root.data);
			map.put(current, list);
		} else {
			if (map.containsKey(current)) {
				List<Integer> li = map.get(current);
				li.add(root.data);
				map.put(current, li);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(root.data);
				map.put(current, list);
			}
		}
		getlevel(root.left, current + 1, map);
		getlevel(root.right, current + 1, map);
	}
}
