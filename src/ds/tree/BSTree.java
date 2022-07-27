package ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class BSTree {
	private Node root;
	
	public BSTree() {
		this.root = null;
	}
	
	public void insert(Node node) {
		Node current = root;
		if(current == null) root = node;
		else {
			while(current != null) {
				if(node.key < current.key) {
					current = current.leftChild;
					if(current == null) {
						current.leftChild = node;
						return;
					}
				}else {
					current = current.rightChild;
					if(current == null) {
						current.rightChild = node;
						return;
					}
				}
			}
		}
	}
	
	public Node find(int key) {
		Node current = root;
		while(key != current.key) {
			if( key < current.key) current = current.leftChild;
			else current = current.rightChild;
			
			if(current == null) return null;
		}
		return current;
	}
	
	public Node minimum() {
		Node current = root;
		Node last = new Node();
		while(current != null) {
			last = current.leftChild;
			current = current.leftChild;
		}
		return last;
	}
	
	public Node maximum() {
		Node current = root;
		Node last = new Node();
		while(current != null) {
			last = current.rightChild;
			current = current.rightChild;
		}
		return last;
	}
	
	private List<Integer> inOrderList = new ArrayList<>();
	private List<Integer> preOrderList = new ArrayList<>();
	private List<Integer> postOrderList = new ArrayList<>();
	
	public void inOrder(Node node) {
		if(node != null) {
			inOrder(node.leftChild);
			inOrderList.add(node.key);
			inOrder(node.rightChild);
		}
	}
	
	public void preOrder(Node node) {
		if(node != null) {
			preOrderList.add(node.key);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}
	
	public void postOrder(Node node) {
		if(node != null) {
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			postOrderList.add(node.key);
		}
	}
	
	private Map<Integer,ArrayList<Integer>> levelMap = new HashMap<>();
	private List<Integer> levelList = new ArrayList<>();
	
	public void levelOrder() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(this.root);

		while(!queue.isEmpty()) {
			Node temp = queue.remove();
			levelList.add(temp.key);
			if(temp.leftChild != null) queue.add(temp.leftChild);
			if(temp.rightChild != null) queue.add(temp.rightChild);
			
		}
	}
	
	public void traverse(int traverseType) {
		switch(traverseType)
		{
		case 1: System.out.println(" \nPre order Traversal :");
				preOrder(root);
				break;
		case 2: System.out.println("\nInorder Traversal");
				inOrder(root);
				break;
		case 3: System.out.println("\nPostOrder Traveral");
				postOrder(root);
				break;
		}
	}
	
	public void printTree() {
		int h = heightRec(root);
		for(int i=1; i<=h; i++) {
			printCurrentLevel(root, i);
			System.out.println();
		}
	}
	public int heightRec(Node node) {
		if(root == null) return 0;
		else {
			int lheight = heightRec(node.leftChild);
			int rheight = heightRec(node.rightChild);
			return Integer.max(lheight, rheight) +1;
		}
	}
	
	public void printCurrentLevel(Node root, int level) {
		if(root == null) return;
		if(level ==1) System.out.println(root.key+" ");
		else if(level > 1) {
			printCurrentLevel(root.leftChild, level-1);
			printCurrentLevel(root.rightChild, level-1);
		}
	}
	
	public  int height(Node root) {
		if(root == null) return 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int height =0;
		while(!queue.isEmpty()) {
			Node temp= queue.remove();
			if(queue.size() ==0) height ++;
			if(temp.leftChild != null) queue.add(temp.leftChild);
			if(temp.rightChild != null) queue.add(temp.rightChild);
		}
		
		return height;
	}
	
	public void mirrorBinaryTree(Node node) {
		if(node == null) return;
		if(node.leftChild != null) mirrorBinaryTree(node.leftChild);
		if(node.rightChild != null) mirrorBinaryTree(node.rightChild);
		Node temp = node.leftChild;
		node.leftChild = node.rightChild;
		node.rightChild = temp;
		
	}
	// traverse
	// level order/
	// find height
	//find level
	// find depth
	// siblings
	//ancestor
	//successor
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
