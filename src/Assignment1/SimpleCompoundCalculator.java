package org.assignment1;

import java.util.Scanner;

public class SimpleCompoundCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the type of interest calculation:");
        System.out.println("1. Simple Interest");
        System.out.println("2. Compound Interest");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                calculateInterest(scanner, true);
                break;
            case 2:
                calculateInterest(scanner, false);
                break;
            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
        }

        scanner.close();
    }

    private static void calculateInterest(Scanner scanner, boolean simpleInterest) {
        System.out.println("Enter principal amount:");
        double principal = scanner.nextDouble();

        System.out.println("Enter rate of interest:");
        double rate = scanner.nextDouble();

        System.out.println("Enter time period (in years):");
        int time = scanner.nextInt();

        double interest;
        if (simpleInterest) {
            interest = calculateSimpleInterest(principal, rate, time);
            System.out.println("Simple Interest: " + interest);
        } else {
            interest = calculateCompoundInterest(principal, rate, time);
            System.out.println("Compound Interest: " + interest);
        }
    }

    private static double calculateSimpleInterest(double principal, double rate, int time) {
        return (principal * rate * time) / 100;
    }

    private static double calculateCompoundInterest(double principal, double rate, int time) {
        return principal * Math.pow(1 + (rate / 100), time) - principal;
    }
}
