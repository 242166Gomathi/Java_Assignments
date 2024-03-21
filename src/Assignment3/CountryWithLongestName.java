package Assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CountryWithLongestName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> countries = new ArrayList<>();

        System.out.print("Enter the number of countries: ");
        int numCountries = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the names of the countries:");
        for (int i = 0; i < numCountries; i++) {
            String countryName = scanner.nextLine();
            countries.add(countryName);
        }

        Optional<String> longestCountryName = countries.stream()
                .reduce((longest, country) -> longest.length() >= country.length() ? longest : country);

        if (longestCountryName.isPresent()) {
            System.out.println("The country with the longest name is: " + longestCountryName.get());
        } else {
            System.out.println("No countries found.");
        }
    }
}