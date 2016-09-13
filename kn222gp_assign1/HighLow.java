package kn222gp_assign1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HighLow {

	public static void main(String[] args) {
		int minimum = 1;
		int maximum = 100;
		int guessCount = 0;
		int randomNumber = randomNumber(minimum, maximum);

		while(randomNumber % 2 == 0){
			randomNumber = randomNumber(minimum, maximum);
		}
		System.out.print("The system have a random odd number between 1-100. Guess away: ");

		while (true) {
			try{
				Scanner keyboard = new Scanner(System.in);
				int myInt = keyboard.nextInt();
				if(myInt < 1 || myInt > 100){
					System.out.print("\nYou cannot guess for " + myInt + ". You have to guess a number between 1-100!\nTry again: ");
					continue;
				}
				else {
					guessCount++;
					if(guessCount == 9) {
						System.out.print("\nLast try! Think, think, think... 1");
					}
					if(guessCount >= 10) {
						System.out.print("\nSorry, you have tried " + guessCount + " times! You cannot try anymore.");
						break;
					}					
					if(myInt == randomNumber) {
						System.out.println("\nCongratulations! You guessed right! The secret number was: " + randomNumber + "\nIt took you " + guessCount + " tries.");
						break;
					}
					if(myInt < randomNumber) {
						System.out.print("\nThe secret number is higher, try again: ");
					}
					if(myInt > randomNumber) {
						System.out.print("\nThe secret number is lower, try again: ");
					}
				}
			} catch(InputMismatchException e){
				System.out.print("\nYou must enter a number between 1-100. Characters and symbols are not allowed!\nTry again: ");
			}
		}

	}

	public static int randomNumber(int min, int max) {
		Random random = new Random();
		int randomNumber = random.nextInt(max - min + 1) + min;

		return randomNumber;
	}
}
