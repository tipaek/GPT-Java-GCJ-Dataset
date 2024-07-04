import java.io.*;

public class PascalTriangle {

    // Method to print Pascal's triangle
    public static void printPascal(int n) {
        for (int line = 1; line <= n; line++) {
            int C = 1; // Initial value for C(line, i)
            for (int i = 1; i <= line; i++) {
                // Print the current value of C
                System.out.print(C + " ");
                // Calculate the next value of C
                C = C * (line - i) / i;
            }
            // Move to the next line
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        int n = 5;
        printPascal(n);
    }
}