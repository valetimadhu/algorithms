package ds.list;

class DLink{
	public long dData;
	public DLink previous;
	public DLink next;
	
	public DLink(long data) {
		dData = data;
	}
	public void display() {
		System.out.println(dData+" ");
	}
	
}

class DoublyLinkedList{
	private DLink first;
	private DLink last;
	
	public DoublyLinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(long dd) {
		DLink newLink = new DLink(dd);
		if(isEmpty())
			last = newLink;
		else
			first.previous = newLink;
		newLink.next = first;
		first = newLink;
		
	}
	
	public void insertLast(long dd) {
		DLink newLink = new DLink(dd);
		if(isEmpty())
			first = newLink;
		else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
			
	}
	
	public DLink deleteFirst() {
		DLink temp = first;
		if(first.next == null)
			last = null;
		else
			first.next.previous = null;
			
		first= first.next;
		return temp;
		
	}
	
	public DLink deleteLast() {
		DLink temp = last;
		if(first.next == null)
			first = null;
		else
			last.previous.next = null;
		last = last.previous;
		return temp;
	}
	
	public void displayForward() {
		System.out.println(" List  (first-->Last): ");
		DLink current = first;
		while(current != null) {
			current.display();
			current = current.next;
		}
	}
	
	public void displayBackward() {
		System.out.println(" List ( Last --> first) :");
		DLink current = last;
		while(current != null) {
			current.display();
			current = current.previous;
		}
	}
}

public class DoublyLinkedListApp {
	
	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.insertFirst(34);
		doublyLinkedList.insertFirst(67);
		doublyLinkedList.insertFirst(33);
		doublyLinkedList.insertLast(87);
		doublyLinkedList.insertLast(86);
		doublyLinkedList.insertLast(12);
		
		doublyLinkedList.displayBackward();
		doublyLinkedList.displayForward();
		
	}

}
