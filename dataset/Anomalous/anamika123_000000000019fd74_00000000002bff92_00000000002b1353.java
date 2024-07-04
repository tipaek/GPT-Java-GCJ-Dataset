// Java program to generate Pascal's Triangle
import java.io.*;

public class PascalTriangle {

    // Function to print Pascal's Triangle
    public static void generatePascalTriangle(int numRows) {
        for (int line = 1; line <= numRows; line++) {
            int value = 1; // Initial value for each line
            for (int i = 1; i <= line; i++) {
                System.out.print(value + " ");
                value = value * (line - i) / i; // Compute next value
            }
            System.out.println();
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        int rows = 5;
        generatePascalTriangle(rows);
    }
}