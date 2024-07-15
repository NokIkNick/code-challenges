package com.wintherdev.numbers.fractionscalculation;

public class Fraction extends Number{
    private int numerator;
    private int denominator;

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

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction add(Fraction in){
    
        if(this.denominator == in.getDemominator())
            return new Fraction(this.numerator + in.getNumerator(), this.denominator);

        int firstDenominator = this.getDemominator();
        int secondDenominator = in.getDemominator();

        this.setNumerator(this.numerator * secondDenominator);
        this.setDenominator(this.denominator * secondDenominator);
        in.setNumerator(in.getNumerator() * firstDenominator);
        in.setDenominator(in.getDemominator() * firstDenominator);
        int sumOfNumerators = this.numerator + in.getNumerator();

        int gcd = gcdByEuclidsAlgorithm(sumOfNumerators, this.denominator);
        
        return new Fraction(sumOfNumerators / gcd, this.denominator/gcd);
        
    }

    //First, if we subtract the smaller number form the larger number, the GCD doesn't change- Therefore, if we keep on subtracting the number, we finally end up with their GCD.
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
