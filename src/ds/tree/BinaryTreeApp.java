package ds.tree;

class Node{
	public int key;
	public double data;
	public Node leftChild;
	public Node rightChild;
	
	/*public Node(int k, double d) {
		this.key = k;
		this.data = d;
		
	}*/
	public void display() {
		System.out.println(" Key: "+key+" Data: "+data);
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
	public void insert(int id, double dd) {
		Node newNode = new Node();
		newNode.key = id;
		newNode.data = dd;
		
		if(root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while(true) {
				parent = current;
				if( id < current.key)
				{
					current = current.leftChild;
					if( current == null) {
						parent.leftChild = newNode;
						return;
					}
				} 
				else {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
				
			}
		}
		
	}
}
public class BinaryTreeApp {

}
