package ds.array;

public class OneDArray {

	public int[] mergeSortedArrays(int[] arr1, int[] arr2){
		int a1= arr1.length;
		int a2= arr2.length;	
		int[] mergedArray = new int[a1+a2];
		int i=0,j=0,k =0;
		while(i < a1 && j < a2){
		if(arr1[i] < arr2[j]) mergedArray[k++] = arr1[i++];
		else mergedArray[k++] = arr2[j++];
		}
		
		while(i < a1) mergedArray[k++] = arr1[i++];
		while(j < a2) mergedArray[k++] = arr2[j++];
		return mergedArray;
		} 


	public int[] findSumArray(int[] arr, int n){
		int[] sumArray = new int[2];
		for(int i=0; i< arr.length; i++){
			for(int j=i+1; j< arr.length; j++){
				if( arr[i] + arr[j] == n) {
					sumArray [0] = arr[i];
					sumArray[1] = arr[j];
					break;
			
			}
		}
	}
		return sumArray;
	}
	
	public int multiplyArray(int[] arr){
		int result=1;
		for(int i=0; i< arr.length; i++){
			result = result * arr[i];	
	}
	return result;
	}

	public int[] multipleArrayWithoutIndex(int[] arr){
		int multiple = multiplyArray(arr);
		int[] arrResult = new int[arr.length];
		for(int i=0; i< arr.length; i++){
		 arrResult[i] = multiple/arr[i];
		}
		return arrResult;
	}

	public int smallInArray(int[] arr){
		int small = arr[0];
		for (int i=0; i< arr.length; i++){
		if(arr[i] < small) small = arr[i];
		}
		return small;
	}
	
	public int firstNonRepetitive(int[] arr){
		for(int i =0; i< arr.length; i++){
		boolean isRepeated =false;
		for(int j=0; j< arr.length; j++){
				if(arr[i] == arr[j] && i !=j) {
					isRepeated = true;
					break;
				}
				
			}
		if(isRepeated == false) {
			return arr[i];
		}
		}
		return -1;
	}

	public int find(int[] arr, int n){
		 int arraySize = arr.length;
		 int lowerBound = 0;
		 int upperBound = arraySize-1;
		 while(arraySize > 0){
		 int curIndex = (lowerBound + upperBound)/2;
		 	if( n == arr[curIndex] )
		 	return arr[curIndex];
		 	else if(lowerBound > upperBound)
		 	return arraySize;
		 	else{
		 		if( n > arr[curIndex]){
		 		lowerBound = curIndex +1;
		 		}else {
		 		upperBound = curIndex -1;
		 		}
		 	}	 
		 	}
		 	return arraySize;
	}
	public static int secondMinBF(int[] arr){
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for(int i=0; i< arr.length; i++){
			if(arr[i] < min) min = arr[i];
		}
		for(int j= 0; j< arr.length; j++){
		if(arr[j] > min & arr[j] < secondMin) {
			secondMin = arr[j];
		}
		}
		
		return secondMin;
	}
	
	public static int secondMin(int[] arr){
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for(int i=0; i< arr.length; i++){
			if(arr[i] < min) {
				secondMin = min;
				min = arr[i];
			}
			else if(arr[i] < secondMin && arr[i] != min){
			secondMin = arr[i];
			}
			
		}
		return secondMin;
	}

	public static void main(String[] args) {
		
		OneDArray oneD= new OneDArray();
		int arr1[] = {1,3,5,7};
		int arr2[] = { 2,4,6,8};
		int arr3[] = {1,2,1,1,3,4,2};
		
//		int merged[];
//		merged = oneD.mergeSortedArrays(arr1, arr2);
//		for(int i=0; i< merged.length; i++) {
//			System.out.println(merged[i]);
//		}
		
//		int[] result;
//		result = oneD.multipleArrayWithoutIndex(arr3);
//		for(int i=0; i< result.length; i++) {
//		System.out.println(result[i]);
//		}

		//System.out.println(oneD.firstNonRepetitive(arr3));
		//System.out.println(oneD.find(arr3, 9));
		System.out.println(oneD.secondMin(arr1));
		
	}

}
