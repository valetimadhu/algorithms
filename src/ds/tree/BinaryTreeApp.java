package ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node{
	public int key;
	public String data;
	public Node leftChild;
	public Node rightChild;
	
	public Node() {
		
	}
	public Node(int k, String d) {
		this.key = k;
		this.data = d;
		
	}
	public void display() {
		System.out.println(" Key: "+key+" Data: "+data);
	}
	
	public void displayKey() {
		System.out.print(key);
	}
}

class BTree{
	private Node root;
	
	public BTree() {
		root = null;
	}
	
	public Node find(int key) {
		Node current = root;
		while(current.key != key) {
			if(key < current.key)
				current = current.leftChild;
			else
				current = current.rightChild;
			if(current == null)
				return null;
		}
		return current;
	}
	public void insert(Node node) {
//		Node newNode = new Node(id,data);
//		if(root == null)
//			root = newNode;
//		else {
//			Node current = root;
//			Node parent;
//			while(true) {
//				parent = current;
//				if( id < current.key)
//				{
//					current = current.leftChild;
//					if( current == null) {
//						parent.leftChild = newNode;
//						return;
//					}
//				} 
//				else {
//					current = current.rightChild;
//					if(current == null) {
//						parent.rightChild = newNode;
//						return;
//					}
//				}
//				
//			}
//		}
		if (root == null) {
			this.root = node;

		}else {
			Node current = root;
			while(true) {
				if(node.key < current.key) {
					if(current.leftChild == null) {
						current.leftChild = node;
						return;
					}else {
						current = current.leftChild;
					}
				}else {
					if(current.rightChild == null) {
						current.rightChild = node;
						return;
					}else {
						current = current.rightChild;
					}
				}
			}
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
	private List<Integer> traverseKeysArray = new ArrayList<>();
	
	
	public Object[] getTraverseKeysArray() {
		return traverseKeysArray.toArray();
	}

	
	private void inOrder(Node localRoot) {
		int cntr =0;
		if(localRoot != null) {
			inOrder(localRoot.leftChild);
			localRoot.displayKey();
			//traverseKeysArray[cntr++] = localRoot.key;
			traverseKeysArray.add(localRoot.key);
			inOrder(localRoot.rightChild);
		}
	}
	
	private void preOrder(Node localRoot) {
		int cntr =0;
		if(localRoot != null) {
			localRoot.displayKey();
			//traverseKeysArray[cntr++] = localRoot.key;
			traverseKeysArray.add(localRoot.key);
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	private void postOrder(Node localRoot) {
		int cntr =0;
		if(localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			localRoot.displayKey();
			//traverseKeysArray[cntr++] = localRoot.key;
			traverseKeysArray.add(localRoot.key);
		}
	}
	
	public Node minimum() {
		Node current;
		Node last =new Node();
		current = root;
		while( current != null) {
			last = current;
			current = current.leftChild;
		}
		
		return last;
	}
	
	public Node maximum() {
		Node current;
		Node last = new Node();
		current = root;
		while(current != null) {
			last = current;
			current = current.rightChild;
		}
		
		return last;
	}
	
	private List<Integer> levelOrderKeysArray = new ArrayList<>();
	
	
	public List<Integer> getLevelOrderKeysArray() {
		return levelOrderKeysArray;
	}


	public void levelOrder() {
		if(root == null) {
			return;
		}

		Queue<Node> nodes = new LinkedList();
		nodes.add(root);
		while(!nodes.isEmpty()) {
			Node node = nodes.remove();
			levelOrderKeysArray.add(node.key);
			
			if(node.leftChild != null ) {
				nodes.add(node.leftChild);
			}
			
			if(node.rightChild != null) {
				nodes.add(node.rightChild);
			}
			
			
		}
	}
	
	
	public void displayTree(){
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
//		System.out.println(
//		"........................................................");
		
		while(isRowEmpty ==false) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			
			for(int j=0; j< nBlanks ; j++) 
				System.out.print(' ');
			
			while(globalStack.isEmpty() == false) {
				Node temp = (Node)globalStack.pop();
				if(temp != null) {
					System.out.print(temp.key);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				}
				else {
					System.out.print("..");
					localStack.push(null);
					localStack.push(null);
				}
				
				for(int j=0; j< nBlanks*2-2; j++) {
					System.out.print(' ');
				}
			} // end of while globalStack.isEmpty();
			
		
		System.out.println();
		nBlanks /= 2;
		while(localStack.isEmpty() == false)
			globalStack.push(localStack.pop());
//		System.out.println(
//				"..............................");
//			
//			
		}
	
	}
	
}


public class BinaryTreeApp {
	
	public static void main(String[] args) {
		BTree btree = new BTree();
		btree.insert(new Node(1, "Subbarayudu"));
		btree.insert(new Node(2, "Satyam"));
		btree.insert(new Node(8, "Srinivas"));
		btree.insert(new Node(3, "Madhu"));
		btree.insert(new Node(4, "Prasad"));
		btree.insert(new Node(9, "Charan"));
		btree.insert(new Node(10, "Sanjay"));
		btree.insert(new Node(5, "Nipun"));
		btree.insert(new Node(6, "Ruthu"));
		btree.insert(new Node(7, "Sai"));

		//btree.find(4).display();
		//btree.traverse(1);
		//btree.traverse(2);
		
		//btree.traverse(3);
		
		//btree.minimum().display();
		//btree.maximum().display();
		
		BTree btree1 = new BTree();
		btree1.insert(new Node(1, "Subbarayudu"));
		btree1.insert(new Node(2, "Satyam"));
		btree1.insert(new Node(8, "Srinivas"));
		btree1.insert(new Node(3, "Madhu"));
		btree1.insert(new Node(4, "Prasad"));
		btree1.insert(new Node(10, "Charan"));
		btree1.insert(new Node(9, "Sanjay"));
		
		
		//btree1.traverse(2);
		
		//boolean isIdentical = Arrays.equals(btree.getTraverseKeysArray(), btree1.getTraverseKeysArray());
		//System.out.println('\n');
		//System.out.println(isIdentical);
		btree1.displayTree();
		btree1.levelOrder();
		for(Integer i: btree1.getLevelOrderKeysArray()) {
			System.out.println(i);
		}
		
		
	}
	
	

}
