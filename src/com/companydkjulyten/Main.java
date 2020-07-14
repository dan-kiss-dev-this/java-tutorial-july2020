package com.companydkjulyten;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int myAge = 31;
        int herAge = myAge;
	    System.out.println(herAge);
	    byte age = 30;
	    long viewsCount = 3_123_456_789L;
	    float price = 10.99F;
	    char letter = 'A';
	    boolean isEligible = false;
	    // note data is an object
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.getTime());
        Point point1 = new Point(1,1);
        Point point2 = point1; // reference to point object in memory
        point1.x = 2;
        String message = "hello \"Mosh\"!";
        // c:\Windows\... path to windows directory, \t uses a tab, the \ is escape sequence
        String b = "c:\\tWindows\\...";
        System.out.println(message);
        System.out.println(message.length());
        System.out.println(message.replace("!", "*"));
        System.out.println(b);

        // arrays
        int[] numbers = { 2, 3, 5, 1, 4};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // to make a 2d array
        int[][] numbers2 = { { 1, 2, 3}, {4, 5, 6} }; // 2 arrays and each array has 3 elements
        numbers2[0][0] = 1;
        System.out.println(Arrays.deepToString(numbers2));
        final float pi = 3.14f;
        int x = 1;
        x++;
        x += 2;
        System.out.println(x);
        double result = (double)10 / (double)3;
        System.out.println(result);
        // below is sample of implicit casting
        // byte > short > int > long > float > double
        String x1 = "1";
        double y1 = Integer.parseInt(x1) + 2.2;
        System.out.println(y1);

        // using the Math class
        int result3 = (int)Math.round(Math.random() * 100);
        System.out.println(result3);

        // 1,234,567 and 10% formatting
        // NumberFormat is abstract class
        NumberFormat currency2 = NumberFormat.getCurrencyInstance();
        String result4 =currency2.format(1234567.891);
        System.out.println(result4);

        // mortage calculator
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        //to read input from terminal
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Principle: ");
        // int principle = scanner.next(); //this get the first value on the line
        int principle = scanner.nextInt();

        System.out.println("Annual interest rate, no % sign: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.println("Period in years: ");
        byte period = scanner.nextByte();
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgage = principle * (
                monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                ) / (Math.pow(1 + monthlyInterest ,numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

        int x2 = 1;
        int y2 = 1;
        System.out.println(x2 == 2 || y2 == 1);

        int temp = 29;
        if (temp > 30) {
            System.out.println("Its a hot day");
            System.out.println("Drink water");
        } else if (temp > 20) {
            System.out.println("its a mild day");
        } else {
            System.out.println("cold day");
        }

        //instead of using an if and else for boolean setting just do it in one line
        int income = 120_000;
        // you should set an initial value for a variable
        boolean hasHighIncome = income > 100_000;
        System.out.println(hasHighIncome);

        System.out.println("Enter a number fizzbuzz check");
        int fizzbuzz = scanner.nextInt();
        if (fizzbuzz % 15 == 0) System.out.println("fizzbuzz");
        else if(fizzbuzz % 3 == 0) System.out.println("fizz");
        else if(fizzbuzz % 5 == 0) System.out.println("buzz");
        else System.out.println(fizzbuzz);

        // for loop in java
        for(int i = 0; i < 5; i++){
            System.out.println(i);
        }

        int i = 5;
        while(i > 0){
            System.out.println(i);
            i--;
        }

        Scanner stringScan = new Scanner(System.in);
        String input = "";
        while(!input.equals("quit")){
            System.out.println("Input: ");
            input = stringScan.next().toLowerCase();
            if (!input.equals("quit"))
                System.out.println(input);
        }









    }

}
