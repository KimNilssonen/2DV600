package kn222gp_assign1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CountDigits {

	public static void main(String[] args) {
		

		try {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter a positive integer: ");
			int myInt = keyboard.nextInt();

			int zeroCounter = 0;
			int oddCounter = 0;
			int evenCounter = 0;
			int sum = 0;
			int valueOfNumber;

			char[] numberArray = String.valueOf(myInt).toCharArray();
			for(int i = 0; i < numberArray.length; i++) {
				if(numberArray[i] == '0') {
					zeroCounter++;
				}
				if(numberArray[i]%2 == 0 && numberArray[i] != '0') {
					evenCounter++;
				}
				if(numberArray[i]%2 != 0 && numberArray[i] != '0') {
					oddCounter++;
				}

				String s = String.valueOf(numberArray[i]);
				valueOfNumber = Integer.valueOf(numberArray[i]).parseInt(s);
				sum += valueOfNumber;
			}

			System.out.println("Zeros: " + zeroCounter);
			System.out.println("Odd: " + oddCounter);
			System.out.println("Even: " + evenCounter);
			System.out.println("Sum: " + sum);
			keyboard.close();

		}
		catch(InputMismatchException e) {
			System.out.println("You must enter a positive integer!");
		}
	}

}
