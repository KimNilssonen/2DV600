package kn222gp_assign1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LargestK {

	public static void main(String[] args) {
		while(true){
			Scanner keyboard = new Scanner(System.in);
			int K = 0;
			int i = 0;
			try{
				System.out.print("Enter a number: ");
				int myInt = keyboard.nextInt();
				if(myInt < 0){
					System.out.println("You must enter a positive number!\n");
				}
				else {
					while (K + i <= myInt){		
						K += 2;
						i += K;
						if(i > myInt){
							K -=2;
							break;
						}
					}
					System.out.println("Your number is: " + myInt);
					System.out.println("K is: " + K + "\n");	
				}
			}
			catch(InputMismatchException e){
				System.out.println("You must enter a positive number. Characters and symbols are not allowed!\n");
				break;
			}
		}
	}
}
