package ds.tree;

public class MaxHeap {
	private HeapNode[] heapArray;
	int currentSize;
	int maxSize;
	
	public MaxHeap(int max) {
		currentSize = 0;
		maxSize = max;
		heapArray = new HeapNode[max];
	}
	
	public  boolean insert(int data) {
		if(currentSize == maxSize) return false;
		heapArray[currentSize] = new HeapNode(data);
		trickleUp(currentSize++);
		return true;
	}
	
	public void trickleUp(int index) {
		int parent = (index-1)/2;
		HeapNode bottom = heapArray[index];
		while(index > 0 && heapArray[parent].getData() < bottom.getData()) {
			index = parent;
			heapArray[index] = heapArray[parent];
			parent = (parent-1)/2;
		}
		heapArray[index] = bottom;
	}
	
	
	public HeapNode remove() {
		HeapNode root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int index) {
		int largerChild;
		HeapNode top = heapArray[index];
		while(index < currentSize /2) {
			int left = index *2 +1;
			int right = index *2 +2;
			if(right < currentSize && heapArray[left].getData() < heapArray[right].getData()) 
				largerChild = right;
			else largerChild = left;
			
			if(top.getData() >= heapArray[largerChild].getData()) break;
			index = largerChild;
			heapArray[index] = heapArray[largerChild];
		}
		heapArray[index] = top;
	}
	
	public boolean change(int index, int newValue) {
		if(index <0 || index >= currentSize) return false;
		int oldValue = heapArray[index].getData();
		heapArray[index].setData(newValue);
		if(oldValue < newValue) trickleUp(index);
		else trickleDown(index);
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class HeapNode{
	private int data;
	public HeapNode(int key) {
		this.data = key;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	
}
