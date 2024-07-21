package com.wintherdev.numbers.fractionscalculation;

public class Fraction extends Number{
    private int numerator;
    private int denominator;


    /**
     * Initializes a new fraction. The fraction follows the structure: numerator/denominator.
     * @param numerator | The numerator of the fraction.
     * @param denominator | The denominator of the fraction.
     * @exception IllegalArgumentException | Gets thrown if the denominator is zero.
     * @return new Fraction object with the values passed in through the constructor.
     */
    public Fraction(int numerator, int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        if(denominator < 0){
            numerator *= -1; //turns the numerator positive.
            denominator *= -1; //turns the denominator positive.
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Initializes a new fraction. The fraction follows the structure: numerator/1.
     * @param numerator | The numerator of the fraction.
     * @return new Fraction object with the values passed in through the constructor.
     */
    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    /**
     * Adds two fractions together.
     * @param in | The fraction to add to the current fraction.
     * @return new Fraction object with the sum of the two fractions.
     */
    public Fraction add(Fraction in){
    
        if(this.denominator == in.getDemominator())
            return new Fraction(this.numerator + in.getNumerator(), this.denominator);

        int[] result = calculateNumeratorAndDenominator(in, ArithmeticType.ADDITION);

        int gcd = gcdByEuclidsAlgorithm(result[0], result[1]);
    
        return new Fraction(result[0] / gcd, result[1]/gcd);
    }

    /**
     * Adds a whole number to the fraction.
     * @param in | The whole number to add to the fraction.
     * @return new Fraction object with the sum of the fraction and the whole number.
     */
    public Fraction add(int in){
        Fraction inFraction = new Fraction(in);
        return add(inFraction);
    }

    /**
     * Subtracts a fraction from the current fraction.
     * @param in | The fraction to subtract from the current fraction.
     * @return new Fraction object with the difference of the two fractions.
     */
    public Fraction subtract(Fraction in){
        
        if(this.denominator == in.getDemominator()){
            return new Fraction(this.numerator - in.getNumerator(), this.denominator);
        }

        int[] result = calculateNumeratorAndDenominator(in, ArithmeticType.SUBTRACTION);

        int gcd = gcdByEuclidsAlgorithm(result[0], result[1]);

        return new Fraction(result[0] / gcd, result[1]/gcd);
    }

    /**
     * Subtracts a whole number from the fraction.
     * @param in | The whole number to subtract from the fraction.
     * @return new Fraction object with the difference of the fraction and the whole number.
     */
    public Fraction subtract(int in){
        return subtract(new Fraction(in));
    }

    /**
     * Multiplies the current fraction with another fraction.
     * @param in | The fraction to multiply with the current fraction.
     * @return new Fraction object with the product of the two fractions.
     */
    public Fraction multiply(Fraction in){
        int gcd = gcdByEuclidsAlgorithm(this.getNumerator() * in.getNumerator(), this.denominator * in.getDemominator());
        return new Fraction((this.getNumerator() * in.getNumerator()) / gcd, (this.denominator * in.getDemominator()) / gcd);
    }

    /**
     * Multiplies the current fraction with a whole number.
     * @param in | The whole number to multiply with the current fraction.
     * @return new Fraction object with the product of the fraction and the whole number.
     */
    public Fraction multiply(int in){
        Fraction inFraction = new Fraction(in);
        return multiply(inFraction);
    }

    /**
     * Divides the current fraction with another fraction.
     * @param in | The fraction to divide the current fraction with.
     * @return new Fraction object with the quotient of the two fractions.
     */
    public Fraction divide(Fraction in){
        int gcd = gcdByEuclidsAlgorithm(this.getNumerator() * in.getDemominator(), this.denominator * in.getNumerator());
        return new Fraction((this.getNumerator() * in.getDemominator() / gcd), (this.denominator * in.getNumerator() / gcd));
    }

    /**
     * Divides the current fraction with a whole number.
     * @param in | The whole number to divide the current fraction with.
     * @return new Fraction object with the quotient of the fraction and the whole number.
     */
    public Fraction divide(int in){
        Fraction inFraction = new Fraction(in);
        return divide(inFraction);
    }

    /**
     * Calculates the numerator and denominator of the fractions when adding or subtracting them.
     * @param in | The fraction to add or subtract.
     * @param type | The type of arithmetic operation to perform.
     * @return int[] | An array with the numerator and denominator of the new fraction.
     */
    private int[] calculateNumeratorAndDenominator(Fraction in, ArithmeticType type){

        int firstDenominator = this.getDemominator();
        int secondDenominator = in.getDemominator();

        int calcFirstNumerator = (this.numerator * secondDenominator);
        int calcFirstDenominator = (this.denominator * secondDenominator);
        int calcSecondNumerator = (in.getNumerator() * firstDenominator);

        int[] toReturn = new int[2];

        switch(type.name()){
            case "ADDITION":
                toReturn[0] = calcFirstNumerator + calcSecondNumerator;
                toReturn[1] = calcFirstDenominator;
                break;
            case "SUBTRACTION":
                toReturn[0] = calcFirstNumerator - calcSecondNumerator;
                toReturn[1] = calcFirstDenominator;
                break;  
        }

        return toReturn;
    }

    /**
     * Calculates the greatest common divisor of two numbers using Euclid's algorithm.
     * @param n1 | The first number.
     * @param n2 | The second number.
     * @return The greatest common divisor of the two numbers.
     */
    private int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }


    public int getNumerator(){
        return this.numerator;
    }

    public int getDemominator(){
        return this.denominator;
    }

    public void setNumerator(int i){
        this.numerator = i;
    }

    public void setDenominator(int i){
        this.denominator = i;
    }

    
    @Override
    public String toString() {
        return this.numerator+"/"+this.denominator;
    }

    @Override
    public int intValue() {
        return (int) this.doubleValue();
    }

    @Override
    public long longValue() {
        return (long) this.doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) this.doubleValue();
    }

    @Override
    public double doubleValue() {
        return ((double) this.numerator/((double) this.denominator));
    }
}


