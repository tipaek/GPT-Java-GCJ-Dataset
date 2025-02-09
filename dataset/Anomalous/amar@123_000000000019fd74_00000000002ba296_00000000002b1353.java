import java.io.*;

public class PascalTriangle {

    // Function to print Pascal's Triangle
    public static void printPascal(int n) {
        for (int line = 1; line <= n; line++) {
            int C = 1; // Represents C(line, i)
            for (int i = 1; i <= line; i++) {
                // The first value in a line is always 1
                System.out.print(C + " ");
                C = C * (line - i) / i;
            }
            System.out.println();
        }
    }

    // Main method to drive the code
    public static void main(String[] args) {
        int n = 5;
        printPascal(n);
    }
}