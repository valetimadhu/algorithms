package ds.hash;

import java.util.HashSet;

public class CheckSum {

	public static int[] findSum(int[] arr,int n) {
		int[] result = new int[2];
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			if(set.contains(n-arr[i])) {
				result[0] = arr[i];
				result[1] = n-arr[i];
				return result;
			}else {
			set.add(arr[i]);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 27;
	    int[] arr1 = {1,21,3,14,5,60,7,6};
	    if(arr1.length > 0){
	      int[] arr2 = findSum(arr1, n);
	      int num1 = arr2[0];
	      int num2 = arr2[1];

	      if((num1 + num2) != n)
	        System.out.println("Not Found");
	      else {
	        System.out.println("Number 1 = " + num1);
	        System.out.println("Number 2 = " + num2);
	        System.out.println("Sum = " +  (n) );

	      }
	    } else {
	      System.out.println("Input Array is Empty!");
	    }
	  }

	}

 