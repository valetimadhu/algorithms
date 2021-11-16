package ds.basic;

class Queue{
	private int maxsize;
	private long[] qArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int s) {
		maxsize = s;
		qArray = new long[maxsize];
		front =0;
		rear =-1;
		nItems = 0;
	}
	
	public void insert(long val) {
		qArray[++rear] = val;
		nItems++;
	}
	
	public long remove() {
		nItems--;
		return qArray[front++];
	}
	
	public long peekFront() {
		return qArray[front];
	}
	
	public boolean isEmpty() {
		return (nItems ==0);
	}
	
	public boolean isFull() {
		return (nItems == maxsize);
	}
	
	public int size() {
		return nItems;
	}
	
}
public class QueueTest {
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue que = new Queue(5);
		que.insert(10);
		que.remove();
		que.insert(20);
		que.insert(30);
		que.insert(40);
	
		que.remove();

	
		
		while(!que.isEmpty()) {
			long n = que.remove();
			System.out.println(n);
		}

	}

}
