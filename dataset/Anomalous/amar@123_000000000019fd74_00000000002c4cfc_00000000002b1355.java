import java.io.*;

public class PascalTriangle {

    // Function to print Pascal's Triangle
    public static void printPascal(int rows) {
        for (int line = 0; line < rows; line++) {
            int value = 1; // C(line, 0) is always 1
            for (int i = 0; i <= line; i++) {
                System.out.print(value + " ");
                value = value * (line - i) / (i + 1);
            }
            System.out.println();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        int numberOfRows = 5;
        printPascal(numberOfRows);
    }
}