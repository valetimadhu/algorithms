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
		int result =0;
		for(int i =0; i< arr.length; i++){
		int cntr =0;
		for(int j=i+1; j< arr.length; j++){
				cntr++;
				if(arr[i] == arr[j]) {
					cntr =0;
					arr[j] =0;
					break;
				}
				
			}
		if(cntr == arr.length -1 -i) {
			result= arr[i];
			return result;
		}
		}
		return result;
	}

	public static void main(String[] args) {
		
		OneDArray oneD= new OneDArray();
		int arr1[] = {1,3,5,7};
		int arr2[] = { 2,4,6,8};
		int arr3[] = {4,5,1,2,0,4};
		
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

		System.out.println(oneD.firstNonRepetitive(arr3));
		
	}

}
