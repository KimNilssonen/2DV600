package kn222gp_assign1;

import java.text.DecimalFormat;

public class Play123Main {

	public static void main(String[] args) {
		int wins = 0;
		int losses = 0;
		int timesToPlay = 10000;
		int convertToPercent = 100;
		
		for(int i = 0; i < timesToPlay; i++) {
			Deck deck = new Deck();
			deck.shuffle();
			
			if(playAndCheckWin(deck)) {
				wins++;
			}
			else {
				losses++;
			}
		}
		
		double probabilityToWin = ((double)wins/timesToPlay*convertToPercent);
		printResults(timesToPlay, wins, losses, probabilityToWin);
	}
	
	public static boolean playAndCheckWin(Deck deck) {
		int counter = 1;
		for(int i = 0; i < 52; i++) {
			if(counter == 3) {
				counter = 1;
			}
			Card card = deck.handOutNextCard();
			if(card.getValue() == counter) {
				return false;
			}
			counter++;
		}
		return true;
	}
	
	public static void printResults(int timesToPlay, int wins, int losses, double probability) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		System.out.println("Number of times played: " + timesToPlay);
		System.out.println("Number of wins: " + wins);
		System.out.println("Number of losses: " + losses);
		System.out.println("The probability of winning the game is: " + decimalFormat.format(probability) + "%");
	}

}
