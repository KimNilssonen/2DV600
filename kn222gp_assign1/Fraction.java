package kn222gp_assign1;

public class Fraction {

	private int _numerator;
	private int _denominator;

	public Fraction(int numerator, int denominator) {
		_numerator = numerator;
		_denominator = denominator;

		if(_denominator == 0) {
			throw new IllegalArgumentException("Denominator is zero");
		}
	}

	public boolean isNegative() {	
		if((double)this.getNumerator()/this.getDenominator() < 0) {
			return true;
		}
		return false;
	}

	public boolean isEqualTo(Fraction fraction) {
		if((double)this.getNumerator()/(double)this.getDenominator() == (double)(fraction.getNumerator()/(double)fraction.getDenominator())) {
			return true;
		}
		return false;
	}

	public Fraction add(Fraction fraction) {
		if(this.getDenominator() != fraction.getDenominator()) {
			int newNumerator = this.getNumerator()*fraction.getDenominator() + fraction.getNumerator()*this.getDenominator();
			int newDenominator = this.getDenominator() * fraction.getDenominator();
			return new Fraction(newNumerator, newDenominator);
		}
		int newNumerator = this.getNumerator() + fraction.getNumerator();
		return new Fraction (newNumerator, this.getDenominator());
	}

	public Fraction subtract(Fraction fraction) {
		if(this.getDenominator() != fraction.getDenominator()) {
			int newNumerator = this.getNumerator()*fraction.getDenominator() - fraction.getNumerator()*this.getDenominator();
			int newDenominator = this.getDenominator() * fraction.getDenominator();
			return new Fraction(newNumerator, newDenominator);
		}
		int newNumerator = this.getNumerator() - fraction.getNumerator();
		return new Fraction (newNumerator, this.getDenominator());
	}

	public Fraction multiply(Fraction fraction) {
		int newNumerator = this.getNumerator() * fraction.getNumerator();
		int newDenominator = this.getDenominator() * fraction.getDenominator();

		return new Fraction(newNumerator, newDenominator);
	}

	public Fraction divide(Fraction fraction) {
		int newNumerator = this.getNumerator() * fraction.getDenominator();
		int newDenominator = this.getDenominator() * fraction.getNumerator();

		return new Fraction(newNumerator, newDenominator);
	}

	public String toString() {
		return this.getNumerator() + "/" + this.getDenominator();
	}

	public int getNumerator() {
		return _numerator;
	}

	public int getDenominator() {
		return _denominator;
	}
	public Fraction simplify() {
		int gcd = findGcd(this); // Greatest common divisor
		int newNumerator = this.getNumerator();
		int newDenominator = this.getDenominator();

		newNumerator /= gcd;
		newDenominator /= gcd;
		Fraction f = new Fraction(newNumerator, newDenominator);

		return f;
	}

	// Finds GCD (greatest common divisor) using Euclid's algorithm
	public int findGcd(Fraction fraction) {
		int num1 = fraction.getNumerator();
		int num2 = fraction.getDenominator();

		while (num1 != num2) {
			if (num1 > num2)
				num1 -= num2;
			else
				num2 -= num1;
		}
		return num1;
	}
}
