import java.io.*;

public class PascalTriangle {

    // Method to print Pascal's Triangle
    public static void printPascalTriangle(int rows) {
        for (int line = 1; line <= rows; line++) {
            int coefficient = 1; // Represents C(line, i)
            for (int i = 1; i <= line; i++) {
                // The first value in a line is always 1
                System.out.print(coefficient + " ");
                coefficient = coefficient * (line - i) / i;
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        int numberOfRows = 5;
        printPascalTriangle(numberOfRows);
    }
}