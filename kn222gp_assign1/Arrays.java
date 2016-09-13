package kn222gp_assign1;

public class Arrays {

	public static void main(String[] args) {

	}

	// adds all elements in the array arr and returns the sum.
	public int sum(int[] arr) {
		int value = 0;
		for(int i = 0; i < arr.length; i++) {
			value += arr[i];
		}
		return value;
	}

	//  returns a string which, if printed, provides a nice looking print out of the array content.
	public String toString(int[] arr) {
		int n;
		String string = "";
		arr.toString();
		for(int i = 0; i < arr.length; i++) {
			n = arr[i];
			string += n + ", ";
		}
		return string;
	}

	// returns, an array where we have added the number n to all elements in the array arr.
	public int[] addN(int[] arr, int n) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] += n;
		}
		return arr;
	}

	// creates, and returns, a new array with all the elements in array arr but in reverse order.
	public int[] reverse(int[] arr) {
		for(int i = 0; i < arr.length / 2; i++)
		{
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
		return arr;
	}

	// replaces all occurences of the element old with nw in arr.
	public void replaceAll(int[] arr, int old, int nw) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == old) {
				arr[i] = nw;
			}
		}
	}

	// returns a new sorted array (least element first) with the same set of elements as in arr. The array arr should be left unchanged.
	public int[] sort(int[] arr) {
		int[] sortedArr = arr.clone();
		int counter = 0;
		int temp;
		boolean swapped = true;
		while(swapped) {
			swapped = false;
			counter++;
			for(int i = 0; i < sortedArr.length - counter; i++) {
				if(sortedArr[i] > sortedArr[i + 1]) {
					temp = sortedArr[i];
					sortedArr[i] = sortedArr[i + 1];
					sortedArr[i + 1] = temp;
					swapped = true;
				}
			}
		}
		return sortedArr;
	}

	// returns true if the subsequence sub is a part of the array arr, otherwise false. 
	// For example, in the case hasSubsequence({1,2,3,4,5}, {2,3,4}) the result is true since {3,4,5} is the final part of {1,2,3,4,5}
	public boolean hasSubsequence(int[] arr, int[] sub) {

		try {
		if(sub.length > arr.length){
			System.out.println("The sub-array is longer than the original array. Try a different sub-array!");
		}
		else{
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == sub[0]) {
					for(int j = 0; j < sub.length; j++) {
						if(arr[i+j] != sub[j]) {
							return false;
						}
					}
				}
			}
		}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of Bounds!");
			return false;
		} 
		return true;
	}

	// returns a new array that is the absolute difference between array arr1 and array arr2. 
	// That is result array dist(i) = |arr1(i) - arr2(i)|. For example, in the case absDif({1,2,3,4,5}, {1,1,1,1,1}) the result is {0,1,2,3,4}. 
	//Notice, that the sizes of both arrays should be the same, in case they are different the method should throw an exception and be handled within the program.
	public int[] absDif(int[] arr1, int[] arr2) {
		int[] newArr = arr1.clone();
		try {
			if(arr1.length != arr2.length) {
				throw new Exception("The arrays are not the same size!");
			}
			for(int i = 0; i < arr1.length; i++) {
				newArr[i] = arr1[i] - arr2[i];
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return newArr;
	}


}
