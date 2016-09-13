package kn222gp_assign1;

public class FractionMain {

	public static void main(String[] args) {
		System.out.println("\n---------------------------------\n           Fraction!\n---------------------------------\n\n");

		Fraction fraction1 = new Fraction(2, 5);
		Fraction fraction2 = new Fraction(3, 4);
		
		// getNumerator and getDenominator
		System.out.println("Testing to get numerator and denominator of the first fraction");
		System.out.println("Numerator: " + fraction1.getNumerator() + "\nDenominator: " + fraction1.getDenominator());
		
		// isNegative
		System.out.println("\n----------------------------------\nTesting if the fractional number is negative");
		System.out.println("True/False: " + fraction1.isNegative());
		
		// add
		System.out.println("\n----------------------------------\nTesting to add the two fractions");
		System.out.print(fraction1.toString() + " + " + fraction2.toString() + " = ");
		System.out.println(fraction1.add(fraction2).simplify());
		
		// subtract
		System.out.println("\n----------------------------------\nTesting to subtract the two fractions");
		System.out.print(fraction1.toString() + " - " + fraction2.toString() + " = ");
		System.out.println(fraction1.subtract(fraction2));
		
		// multiply
		System.out.println("\n----------------------------------\nTesting to multiply the two fractions");
		System.out.print(fraction1.toString() + " * " + fraction2.toString() + " = ");
		System.out.println(fraction1.multiply(fraction2).simplify());
		
		// divide
		System.out.println("\n----------------------------------\nTesting to divide the two fractions");
		System.out.print(fraction1.toString() + " / " + fraction2.toString() + " = ");
		System.out.println(fraction1.divide(fraction2).simplify());
		
		// isEqual
		System.out.println("\n----------------------------------\nTesting to see if the two fractions are equal");
		System.out.println("Fraction1: " + fraction1.toString() + "\nFraction2: " + fraction2.toString());
		System.out.println("True/False: " + fraction1.isEqualTo(fraction2));

	}
}


