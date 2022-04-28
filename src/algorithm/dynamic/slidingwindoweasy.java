package algorithm.dynamic;

public class slidingwindoweasy {
	
	/*
	 * Time complexity: o(n*k)
	 * space complexity: 
	 */
	public double[] findAveragesBF(int[] arr, int k){
		 double[] result = new double[arr.length-k+1];
		 for(int i=0; i<arr.length-k+1; i++){
		 	int sum =0;
		 	for(int j=i; j<i+k; j++){
		 		sum += arr[j];
		 		result[i] = sum/k;
		 	} 
		 }
		 return result;
		}

	/*
	 * Time complexity: o(n)
	 * space complexity: 
	 */
	public double[] findAverages(int[] arr, int k){
		 double[] result = new double[arr.length-k+1];
		int windowStart = 0;
		int windowSum =0;
		for(int windowEnd=0; windowEnd<arr.length; windowEnd ++){
		 windowSum += arr[windowEnd];
		 if( windowEnd >= k-1){
		  result[windowStart] = windowSum/k;
		  windowSum -= arr[windowStart];
		  windowStart ++;
		 }
		} 
		return result;
	}
	
	
	public int maxSumSubArray(int[] arr, int k){
		int maxSum =0;
		int windowStart =0;
		int windowSum =0;
		for(int windowEnd =0; windowEnd < arr.length; windowEnd ++){
			windowSum += arr[windowEnd];
			if(windowEnd >= k-1){
			if(windowSum > maxSum) maxSum = windowSum;
			windowSum -= arr[windowStart];
			windowStart ++;
			}
		}
		return maxSum;
	}
	
	public  int minSumSubArrayBF(int[] arr, int s) {
		int subArrayLength = Integer.MAX_VALUE;
		for( subArrayLength =1; subArrayLength<= arr.length; subArrayLength++){
			int sum = 0;
			for(int i=subArrayLength; i< subArrayLength; i++){
				sum += arr[i];
			}
		if(sum >= s) return subArrayLength;
		}
		return -1;
	}
	public int minSubArray(int[] arr, int s){
	 	int windowSum=0;
	 	int windowStart =0;
	 	int minArrLength = Integer.MAX_VALUE;
	 	//int cntr =0;
	 	for(int windowEnd =0; windowEnd < arr.length; windowEnd++){
	 		windowSum += arr[windowEnd];
	 		while(windowSum >= s){
	 			//cntr++;
	 			minArrLength = Math.min(minArrLength, windowEnd - windowStart +1);
	 			windowSum -= arr[windowStart];
	 			windowStart ++;
	 		}
	 	}
	 	//System.out.println("cntr  :" +cntr);
	 	return minArrLength == Integer.MAX_VALUE?0: minArrLength;
	}
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int[] arr1 = {2,1,5,2,3,2};
		slidingwindoweasy slidingwindoweasy = new slidingwindoweasy();
		
		double[] resultBF = slidingwindoweasy.findAveragesBF(arr, 3);
		for(double d: resultBF) {
		//System.out.println("Find average "+d);
		}
		double[] result = slidingwindoweasy.findAverages(arr, 3);
		for(double d: result) {
		//System.out.println("Find average "+d);
		}
		
		//System.out.println(" MaxSumArray :  "+slidingwindoweasy.maxSumSubArray(arr, 5));
		System.out.println(" Min Sub Array Length :  "+slidingwindoweasy.minSubArray(arr, 13));

	}

}
