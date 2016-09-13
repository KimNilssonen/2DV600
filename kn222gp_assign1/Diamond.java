package kn222gp_assign1;

import java.util.Scanner;

public class Diamond {

	public static void main(String[] args) {
		
		System.out.print("Enter an odd, positive number: ");
		while(true) {
			Scanner keyboard = new Scanner(System.in);
			int myInt = keyboard.nextInt();
			if(myInt % 2 == 0 || myInt < 0) {
				System.out.print("You need to enter an odd, positive number! Try again: ");
				continue;
			}
			
			drawDiamond(myInt);
		}
	}
	
	public static void drawDiamond(int width){
		int stars = 1;
		int whitespaces = (width-1)/2;
		boolean starsDecrease = false;
		boolean whitespacesIncrease = false;
		
		// For vertical (Basically creates rows).
		for(int y = 0; y < width; y++) {
			
			// For whitespaces (Basically fills the rows).
			for(int z = 0; z < whitespaces; z++){
				System.out.print(" ");
			}
			
			//For stars (Basically fills the rows).
			for(int x = 0; x < stars; x++){
				System.out.print("*");
			}
			System.out.println();
			
			if(stars < width && !starsDecrease){
				stars+=2;
			}
			else{
				stars-=2;
				starsDecrease = true;
			}
			
			if(whitespaces > 0 && !whitespacesIncrease){
				whitespaces--;
			}
			else {
				whitespaces++;
				whitespacesIncrease = true;	
			}
		}
	}
}
