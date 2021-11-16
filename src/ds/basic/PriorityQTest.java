package ds.basic;

class PriorityQ{
	private int maxsize;
	private long[] prioarray;
	private int nitems;
	
	public PriorityQ(int s) {
		maxsize= s;
		prioarray = new long[maxsize];
		nitems = 0;
	}
	public void insert(int val) {
		int j=0;
		if(nitems ==0) 
			prioarray[nitems++] = val;
		else {
			for(j= nitems-1; j>=0; j--)
			{
				if(  val  > prioarray[j]  ) 
					prioarray [j+1]= prioarray[j];
				else
					break;

			}
			prioarray[j+1] = val;	
			nitems++;
			
		}
		
	}
	
	/*public void insert(long value) {
		
		int j;
		for(j=0; j< nitems ; j++) {
			loopcnt+=1;
			if(prioarray[j] > value)
				break;
		}
		for(int k= nitems ; k> j; k--) {
			prioarray[k] = prioarray[k-1];
			loopcnt+=1;
		}
		prioarray[j] = value;
		nitems ++;
		
	}*/
	
//	public int getLoopCount() {
//		return loopcnt;
//	}
	
	public long remove() {
		return prioarray[--nitems];
	}
	
	public void display() {
		for(int i=0; i< prioarray.length; i++) {
		System.out.println(" "+prioarray[i]);
		}
	}
	
	public boolean isEmpty() {
		return (nitems ==0);
	}
	
	public boolean isFull() {
		return (nitems == maxsize);
	}
	
	public int size() {
		return nitems;
	}
}
public class PriorityQTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQ priorityQ = new PriorityQ(5);
		priorityQ.insert(30);
		priorityQ.insert(50);
		priorityQ.insert(10);
		priorityQ.insert(40);
		priorityQ.insert(20);
	
		
//		System.out.println(" loop count "+priorityQ.getLoopCount());
		priorityQ.display();
//		System.out.println(" loop count "+priorityQ.getLoopCount());
		while(!priorityQ.isEmpty()) {
			System.out.println(" "+priorityQ.remove());
		}
	}

}
