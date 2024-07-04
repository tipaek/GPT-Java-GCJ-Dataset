import java.io.*;

public class Main {

    // Function to print Pascal's Triangle
    public static void printPascal(int n) {
        for (int line = 1; line <= n; line++) {
            int C = 1; // Initialize the first value in a line
            for (int i = 1; i <= line; i++) {
                System.out.print(C + " ");
                C = C * (line - i) / i;
            }
            System.out.println();
        }
    }

    // Main driver method
    public static void main(String[] args) {
        int n = 5;
        printPascal(n);
    }
}