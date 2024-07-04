// Java program for Pascal's Triangle
// A O(n^2) time and O(1) extra
// space method for Pascal's Triangle
public class PascalTriangle {

    // Function to print Pascal's Triangle
    public static void printPascal(int n) {
        for (int line = 1; line <= n; line++) {
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
        int n = 5;
        printPascal(n);
    }
}