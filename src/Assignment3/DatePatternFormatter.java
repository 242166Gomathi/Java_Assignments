package Assignment3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePatternFormatter {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formattedDate = currentDate.format(formatter);

        FormattedDate formattedDateRecord = new FormattedDate(formattedDate);
        System.out.println("Current date in the pattern 'MM-dd-yyyy': " + formattedDateRecord.formattedDate());
    }
}

// Record to generate getters and setters
record FormattedDate(String formattedDate) {}