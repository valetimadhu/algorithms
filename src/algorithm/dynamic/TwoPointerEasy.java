package algorithm.dynamic;

public class TwoPointerEasy {

	public int[] pairWithGivenSum(int[] arr, int s){
		int[] pair = new int[2];
		int pairOne = 0;
		int pairTwo = arr.length-1;
		int pairSum =0;
		while(pairOne < pairTwo){
			pairSum = arr[pairOne] + arr[pairTwo];
			if(pairSum == s){
				pair[0] = pairOne;
				pair[1] = pairTwo;
				return pair;
			}
			else if(pairSum > s)
				pairTwo--;
			else pairOne++;
		}
		return pair;
	}
	public int removeDuplicates(int[] arr){
		int nextNonDuplicate=1;
		for(int i=1; i< arr.length; i++){
			if(arr[nextNonDuplicate-1] != arr[i]){
				arr[nextNonDuplicate] = arr[i];
				nextNonDuplicate++;
			}
		}
		return nextNonDuplicate;
	}

	public int removeAllInstancesOfGivenKey(int[] arr, int k){
		int newArrPointer =0;
		for(int i=0; i< arr.length; i++){
			if(arr[i] != k){
			arr[newArrPointer] = arr[i];
			newArrPointer++;
			}
		}
		return newArrPointer;
	}
	
	public int[] squareOfSortedArray(int[] arr){
		int[] arrSquares = new int[arr.length];
		int leftPointer =0;
		int rightPointer = arr.length -1;
		int highSquareIndex = arr.length -1;
		while(leftPointer < rightPointer){
			int leftSquare = arr[leftPointer] * arr[leftPointer];
			int rightSquare = arr[rightPointer] * arr[rightPointer];
			if(leftSquare > rightSquare){
				arrSquares[highSquareIndex--] = leftSquare;
				leftPointer++;
			}else{
				arrSquares[highSquareIndex--] = rightSquare;
				rightPointer--;
			}
		}
		return arrSquares;
		
	}
	public static void main(String[] args) {
		TwoPointerEasy twoPointerEasy = new TwoPointerEasy();
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int[] result = twoPointerEasy.pairWithGivenSum(arr, 17);
		for(int i: result) {
			System.out.println(i);
		}
		int[] dupArr = { 1,2,2,3,3,3,3,4,5,9};
		int[] dupArr1 = { 1,2,2,3,3,3,3,4,5,9};
		System.out.println(" Array Length after removing duplicates :"+twoPointerEasy.removeDuplicates(dupArr));
		System.out.println(" Array Length after removing given key :"+twoPointerEasy.removeAllInstancesOfGivenKey(dupArr1,3));

		int[] sqrArr = {-3,-1,0,1,2};
		int[] squares = twoPointerEasy.squareOfSortedArray(sqrArr);
		for(int i: squares) {
			System.out.println(i);
		}
	}

}
