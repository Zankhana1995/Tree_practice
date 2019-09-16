package bst;
//Find the node with minimum value in a Binary Search Tree
class Node1
{
	int data;
	Node1 left,right;
	public Node1(int data)
	{
		this.data = data;
		left = right = null;
	}
}
public class BinaryTree_NodewithMinValue {
	public static void main(String[] args) {
		Node1 root = null;
		BinaryTree_NodewithMinValue bt1 = new BinaryTree_NodewithMinValue();
		root = bt1.insert(root,5);
		bt1.insert(root, 3); 
		bt1.insert(root, 2); 
		bt1.insert(root, 1); 		
		bt1.insert(root, 6); 
		bt1.insert(root, 5); 
		System.out.println(minvalue(root));
	}
	private static int minvalue(Node1 root)
	{
		int min = 0;
		while(root.left != null)
		{
			min = root.left.data;
			root.left = root.left.left;
			
		}	
		return min;
	}
	private Node1 insert(Node1 node, int data) {
		if(node==null)
		{
			return (new Node1(data));
		}
		else
		{
			if(data <= node.data)
				node.left = insert(node.left,data);
			else
				node.right = insert(node.right, data);
		}
		return node;
	}
	
}
