package org.assignment1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emailregex {

    // Regular expression for validating email addresses
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean validateEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueValidation = true;
        while (continueValidation) {
            System.out.println("Enter an email address to validate (type 'exit' to stop):");
            String email = scanner.nextLine();

            if (email.equalsIgnoreCase("exit")) {
                continueValidation = false;
                System.out.println("Exiting email validation.");
            } else {
                if (validateEmail(email)) {
                    System.out.println("The email address '" + email + "' is valid.");
                } else {
                    System.out.println("The email address '" + email + "' is invalid.");
                }
            }
        }

        scanner.close();
    }
}