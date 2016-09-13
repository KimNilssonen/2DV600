package kn222gp_assign1;

public class ArraysMain {

	public static void main(String[] args) {
		Arrays arrays = new Arrays();
		int[] testArray = {1,2,3,4,5};
		int[] testArray2 = {1,1,1,1,1};
		int[] subArray = {6,5,4};
		int testNumber = 2;
		int testNumber2 = 3;
		
		// sum
		System.out.println("\nTesting method: \"sum\"\n-----------------------------------------");
		System.out.println("Sum of all values in array: " + arrays.sum(testArray));
		System.out.println("-----------------------------------------\n");
		
		// toString
		System.out.println("\nTesting method: \"toString\"\n-----------------------------------------");
		System.out.println("Values in array: " + arrays.toString(testArray));
		System.out.println("-----------------------------------------\n");
		
		// addN
		System.out.println("\nTesting method: \"addN\"\n-----------------------------------------");
		System.out.println("Testnumber: " + testNumber);
		System.out.println("Old values: " + arrays.toString(testArray));
		System.out.println("New values after addition: " + arrays.toString(arrays.addN(testArray, testNumber)));
		System.out.println("-----------------------------------------\n");
		
		// reverse
		System.out.println("\nTesting method: \"reverse\"\n-----------------------------------------");
		System.out.println("Original array: " + arrays.toString(testArray));
		System.out.println("Reversed array: " + arrays.toString(arrays.reverse(testArray)));
		System.out.println("-----------------------------------------\n");
		
		// replaceAll
		System.out.println("\nTesting method: \"replaceAll\"\n-----------------------------------------");
		System.out.println("Old number: " + testNumber2);
		System.out.println("New number: " + testNumber);
		System.out.println("Original array: " + arrays.toString(testArray));
		arrays.replaceAll(testArray, testNumber2, testNumber);
		System.out.println("Array after replacement: " + arrays.toString(testArray));
		System.out.println("-----------------------------------------\n");
	
		// sort
		System.out.println("\nTesting method: \"sort\"\n-----------------------------------------");
		System.out.println("Original array: " + arrays.toString(testArray));
		System.out.println("Array after sorting: " + arrays.toString(arrays.sort(testArray)));
		System.out.println("-----------------------------------------\n");
		
		// hasSubsequence
		System.out.println("\nTesting method: \"hasSubsequence\"\n-----------------------------------------");
		System.out.println("Original array: " + arrays.toString(testArray));
		System.out.println("Subsequence array: " + arrays.toString(subArray));
		System.out.println("Answer from hasSubsequence: " + arrays.hasSubsequence(testArray, subArray));
		System.out.println("-----------------------------------------\n");
		
		// absDif
		System.out.println("\nTesting method: \"absDif\"\n-----------------------------------------");
		System.out.println("First array: " + arrays.toString(testArray));
		System.out.println("Second array: " + arrays.toString(testArray2));
		System.out.println("Difference in values between arrays: " + arrays.toString(arrays.absDif(testArray, testArray2)));
		System.out.println("-----------------------------------------\n");
	}

}
