import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Create a file chooser
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

        // Show the file chooser dialog
        int result = chooser.showOpenDialog(null);

        // Process the selected file
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            printSummary(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }

    private static void printSummary(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String fileName = file.getName();
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                wordCount += line.split("\\s+").length; // Split by whitespace to count words
            }

            System.out.println("Summary Report:");
            System.out.println("File Name: " + fileName);
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
