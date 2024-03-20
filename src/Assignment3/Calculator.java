package Assignment3;

import java.util.Scanner;

interface Operation {
    double perform(double num1, double num2);
}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter operator (+, -, *, /) or 'q' to quit: ");
            char operator = scanner.next().charAt(0);

            if (operator == 'q') {
                System.out.println("Exiting calculator.");
                break;
            }

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            Operation operation;
            switch (operator) {
                case '+':
                    operation = (a, b) -> a + b;
                    break;
                case '-':
                    operation = (a, b) -> a - b;
                    break;
                case '*':
                    operation = (a, b) -> a * b;
                    break;
                case '/':
                    operation = (a, b) -> a / b;
                    break;
                default:
                    System.out.println("Invalid operator");
                    continue; // Skip the rest of the loop and start over
            }

            double result = operation.perform(num1, num2);
            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}
