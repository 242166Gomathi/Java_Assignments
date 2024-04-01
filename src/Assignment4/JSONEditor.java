package org.Assignment4;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.Scanner;

public class JSONEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for JSON file path
        System.out.print("Enter the path of the JSON file to edit: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        // Read JSON file
        JsonElement jsonElement;
        try (FileReader fileReader = new FileReader(file)) {
            jsonElement = JsonParser.parseReader(fileReader);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray dataArray = jsonObject.getAsJsonArray("data");

        // Display the current JSON data
        System.out.println("Current JSON data:");
        System.out.println(dataArray);

        // Prompt user to select an entry to edit
        System.out.print("Enter the index of the entry to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index < 0 || index >= dataArray.size()) {
            System.out.println("Invalid index!");
            return;
        }

        JsonObject selectedEntry = dataArray.get(index).getAsJsonObject();

        // Edit the values of selected entry
        System.out.println("Enter new values for the selected entry:");
        System.out.print("Enter name: ");
        selectedEntry.addProperty("name", scanner.nextLine());
        System.out.print("Enter age: ");
        selectedEntry.addProperty("age", scanner.nextLine());
        System.out.print("Enter city: ");
        selectedEntry.addProperty("city", scanner.nextLine());
        System.out.print("Enter email: ");
        selectedEntry.addProperty("email", scanner.nextLine());
        System.out.print("Enter phone: ");
        selectedEntry.addProperty("phone", scanner.nextLine());

        // Save the updated JSON data to output.json in a different file location
        System.out.print("Enter the path to save the modified JSON file (including filename): ");
        String outputPath = scanner.nextLine();

        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(jsonObject.toString());
            System.out.println("Updated JSON data saved to " + outputPath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
