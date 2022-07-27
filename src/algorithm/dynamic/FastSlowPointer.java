package algorithm.dynamic;


class Listnode{
	int val =0;
	Listnode next;
	Listnode(int val){
		this.val = val;
	}
}
public class FastSlowPointer {
	
	public boolean hasCycle(Listnode head){
		Listnode slow = head;
		Listnode fast = head;
		while(fast != null && fast.next != null){
		fast = fast.next.next;
		slow = slow.next;
		if( slow ==fast) return true;
		}
		
		return false;
	}
	
	public int findCycleLength(Listnode head) {
		Listnode slow = head;
		Listnode fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if( slow == fast) return calLength(slow);
		}
		return 0;
	}

	public int calLength(Listnode slow){
		Listnode current = slow;
		int cycleLength =0;
		do{
		current = current.next;
		cycleLength++;
		}while(current != slow);
		return cycleLength;
	}

	public static void main(String[] args) {
		Listnode head = new Listnode(1);
		head.next = new Listnode(2);
		head.next.next = new Listnode(3);
		head.next.next.next = new Listnode(4);
		head.next.next.next.next = new Listnode(5);
		head.next.next.next.next.next = new Listnode(6);
		FastSlowPointer fastSlowPointer = new FastSlowPointer();
		System.out.println(" Linked list has a cycle : "+fastSlowPointer.hasCycle(head));
		
		head.next.next.next.next.next.next = head.next.next;
		
		System.out.println(" Linked list has a cycle and cycle length : "+fastSlowPointer.findCycleLength(head));
		head.next.next.next.next.next.next = head.next;
		System.out.println(" Linked list has a cycle and cycle length : "+fastSlowPointer.findCycleLength(head));
	}

}


