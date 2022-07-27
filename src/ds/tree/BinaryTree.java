package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	public void insert(Node node) {
		Queue<Node> queue = new LinkedList<>();
		Node temp = this.root;
		queue.add(temp);
		while(!queue.isEmpty()) {
			temp = queue.remove();
			if(temp.leftChild == null) {
				temp.leftChild = node;
				break;
			}else {
				queue.add(temp.leftChild);
			}
			
			if(temp.rightChild == null) {
				temp.rightChild = node;
				break;
			}else {
				queue.add(temp.rightChild);
			}
		}
		
	}
	
	

	

}

