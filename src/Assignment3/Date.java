package Assignment3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Date {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter a date (yyyy-MM-dd): ");
        String inputDateStr;
        LocalDate inputDate;

        try {
            inputDateStr = scanner.nextLine();
            inputDate = LocalDate.parse(inputDateStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            return;
        }

        LocalDate currentDate = LocalDate.now();

        int comparison = inputDate.compareTo(currentDate);

        if (comparison == 0) {
            System.out.println("The input date is equal to the current date.");
        } else if (comparison < 0) {
            System.out.println("The input date is before the current date.");
        } else {
            System.out.println("The input date is after the current date.");
        }
    }
}