package com.companydkjulyten;

import sun.nio.fs.MacOSXFileSystemProvider;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

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


        //default mortgage values
        int principle = 0;
        float annualInterest = 0;
        byte years = 0;


        //to read input from terminal
        Scanner scanner = new Scanner(System.in);

        principle = (int) readNumber("Principle: ", 1_000, 1_000_000);

        annualInterest = (float) readNumber("Annual Interest Rate with no percent sign", 1, 30);

        years = (byte) readNumber("Period in years (1-30): ", 1, 30);

        double mortgage = calculateMortgage(principle, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
        printPaymentSchedule(principle, annualInterest, years);
        //end mortgage calc

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
            System.out.println("Input (type quit to exit): ");
            input = stringScan.next().toLowerCase();
            if (!input.equals("quit"))
                System.out.println(input);
        }

        String message2 = greetUser("Ted", "Roberts");
        System.out.println(message2);
    }

    private static void printPaymentSchedule(int principle, float annualInterest, byte years) {
        System.out.println("Monthly Payments: ");
        System.out.println("Payment Schedule -----");
        for(short month = 1; month < years * MONTHS_IN_YEAR; month++){
            double balance = calulatorBalance(principle, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static String greetUser( String firstName, String lastName ){
        System.out.println("Hello output " + firstName + " " + lastName);
        return "Hello " + firstName + " " + lastName;
    }

    public static double calculateMortgage(
            int principle,
            float annualInterest,
            byte years){



        float monthlyInterest = annualInterest / PERCENT / 12;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        double mortgage = principle * (
                monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
        ) / (Math.pow(1 + monthlyInterest ,numberOfPayments) - 1);

        return mortgage;
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true){
            System.out.println(prompt);
            value = scanner.nextFloat();
            if(value >= min && value <= max){
                break;
            }
            System.out.println("Enter a value between " + min + " and " + max );
        }
        return value;
    }

    public static double calulatorBalance(
            int principle,
            float annualInterest,
            byte years,
            short numberOfPaymentsMade
    ){


        float monthlyInterest = annualInterest / PERCENT / 12;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double balance = principle
                *(Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

                return balance;
    }

}
