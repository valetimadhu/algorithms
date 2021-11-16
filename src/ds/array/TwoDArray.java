package ds.array;

public class TwoDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 10;
		int columns = 10;
		int[][] my2DArray;
		my2DArray = new int[rows][];
		for(int i=0; i< 10; i++) {
			my2DArray[i] = new int[10];
			for(int j=0; j<10; j++) {
				my2DArray[i][j] = i+j;
				System.out.println(my2DArray[i][j]);
			}
		}

	}

}
