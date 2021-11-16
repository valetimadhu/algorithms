package ds.basic;

public class OrdArray {
	private long array[];
	private int arraySize;
	
	public OrdArray(int maxSize) {
		array = new long[maxSize];
		arraySize =0;
	}
	
	public int size() {
		return arraySize;
	}
	
	public void insert(long value) {
		/*int j;
		for(j=0; j< arraySize ; j++)
			if(array[j] > value)
				break;
		for(int k= arraySize ; k> j; k--)
			array[k] = array[k-1];
		array[j] = value;
		arraySize ++;*/
		
		int j=0;
		if(arraySize ==0) 
			array[arraySize++] = value;
		else {
			for(j= arraySize-1; j>=0; j--)
			{
				if(  value  < array[j]  ) 
					array [j+1]= array[j];
				else
					break;

			}
			array[j+1] = value;	
			arraySize++;
			
		}
			
	}
	
	public int find( long searchValue) {
		int lowerBound =0;
		int upperBound = arraySize-1;
		int currIn;
		while(arraySize > 0) {
			currIn = (lowerBound+upperBound)/2;
			if( array[currIn] == searchValue)
				return currIn;
			else if(lowerBound > upperBound)
				return arraySize;
			else {
				if(array[currIn] < searchValue)
					lowerBound = currIn +1;
				else
					upperBound = currIn -1;
			}

		}
		
		return arraySize;
		
	}
	
	public boolean delete(long value) {
		int j = find(value);
		if( j== arraySize )
			return false;
		else {
			for(int k=j; k< arraySize ; k++)
				array[k] = array[k+1];
			arraySize--;
			return true;
		}
	}
	
	public void display() {
		for(int i=0; i< arraySize; i++)
			System.out.println("  "+array[i]);
		
	}
	
	public static void main(String[] args) {
		int maxSize = 100;
		OrdArray ordarray= new OrdArray(maxSize);
		ordarray.insert(43);
		ordarray.insert(12);
		ordarray.insert(76);
		ordarray.insert(24);
		ordarray.insert(98);
		ordarray.insert(34);
		ordarray.insert(76);
		ordarray.insert(23);
		ordarray.insert(65);
		ordarray.display();
		int searchValue = 34;
		if(ordarray.find(searchValue) != ordarray.size())
			System.out.println(" found");
		else
			System.out.println(" not found");
		
		
		ordarray.delete(98);
		ordarray.delete(12);
		ordarray.delete(34);
		ordarray.delete(75);
		
		ordarray.display();
		
		
	}
}
