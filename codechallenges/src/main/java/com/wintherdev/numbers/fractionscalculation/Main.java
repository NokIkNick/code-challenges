package com.wintherdev.numbers.fractionscalculation;

public class Main {
    public static void main(String[] args) {

        //Initialization of new fractions:
        Fraction fraction1 = new Fraction(2,7);
        Fraction fraction2 = new Fraction(2,14);
        System.out.println(fraction1);
        System.out.println(fraction2);

        //Addition of fractions:
        Fraction fraction3 = fraction1.add(fraction2);
        System.out.println(fraction3);

        //Subtraction of fractions:
        Fraction fraction4 = fraction1.subtract(fraction2);
        System.out.println(fraction4);

        //Multiplication of fractions:
        Fraction fraction5 = fraction1.multiply(fraction2);
        System.out.println(fraction5);

        //Division of fractions:
        Fraction fraction6 = fraction1.divide(fraction2);
        System.out.println(fraction6.doubleValue());

        //Division by whole number:
        Fraction fraction7 = new Fraction(2,5);
        Fraction fraction8 = fraction7.divide(4);
        System.out.println(fraction8);

        //Long calculation string:
        Fraction fraction9 = fraction1.multiply(fraction2).divide(fraction7).subtract(fraction1);
        System.out.println(fraction9.doubleValue());

        //Addition by whole number:
        Fraction fraction10 = new Fraction(2,4);
        Fraction fraction11 =  fraction10.add(3);
        System.out.println(fraction11);

        
        

        
    }
}
