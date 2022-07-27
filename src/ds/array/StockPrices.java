package ds.array;

import java.util.Arrays;

public class StockPrices {
	
	public static Tuple<Integer,Integer> findBuySellStockPrices(int[] stockNums){
		if(stockNums == null || stockNums.length <2) return null;
		
		int buy= stockNums[0];
		int sell = stockNums[1];
		
		int cp= Integer.MIN_VALUE;
		int gp= sell -buy;
		
		for(int i=1; i< stockNums.length; i++) {
			cp = stockNums[i] - buy;
			if(cp > gp) {
				gp = cp;
				sell = stockNums[i];
			}
			if(stockNums[i] <buy ) {
				buy= stockNums[i];
			}
		}
		
		return new Tuple(sell-gp,sell); // in loss cases/negative cases buy is not least price.
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] stockNums =
			{{1, 2, 3, 4, 3, 2, 1, 2, 5}, {8, 6, 5, 4, 3, 2, 1}, {12, 30, 40, 90, 110}, {2}};

	for (int i = 0; i < stockNums.length; i++) {
		Tuple<Integer, Integer> result = findBuySellStockPrices(stockNums[i]);
		System.out.println((i + 1) + ". Day stocks: " + Arrays.toString(stockNums[i]));
		if (result != null) {
			System.out.println("   Buy Price: " + result.x + ", Sell Price: " + result.y);
		} else {
			System.out.println("   Buy Price: null, Sell Price: null");
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------\n");
	}

	}

}
class Tuple<Integer1,Integer2>{
	Integer x;
	Integer y;
	public Tuple(Integer x, Integer y) {
		this.x = x;
		this.y =y;
	}
}
