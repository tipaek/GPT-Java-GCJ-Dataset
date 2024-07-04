// Java program to generate Pascal's Triangle
// with O(n^2) time complexity and O(1) extra space
public class PascalTriangle {

    // Function to print Pascal's Triangle
    public static void printPascal(int n) {
        for (int line = 1; line <= n; line++) {
            int C = 1; // Initial value for C(line, i)
            for (int i = 1; i <= line; i++) {
                // Print the current value of C
                System.out.print(C + " ");
                // Update C to the next value in the line
                C = C * (line - i) / i;
            }
            // Move to the next line
            System.out.println();
        }
    }

    // Main method to drive the code
    public static void main(String[] args) {
        int n = 5;
        printPascal(n);
    }
}