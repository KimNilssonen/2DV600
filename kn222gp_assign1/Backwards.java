package kn222gp_assign1;

import java.util.Scanner;

public class Backwards {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type a line of text: ");
		String myText = keyboard.nextLine();
		System.out.println("Backwards: " + new StringBuilder(myText).reverse().toString());
		keyboard.close();
		

	}

}
