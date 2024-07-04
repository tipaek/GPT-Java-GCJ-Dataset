// Java program to generate Pascal's Triangle
// This method operates in O(n^2) time complexity and uses O(1) extra space
public class PascalTriangle {

    // Function to print Pascal's Triangle
    public static void printPascal(int n) {
        for (int line = 0; line < n; line++) {
            int C = 1; // Represents C(line, i)
            for (int i = 0; i <= line; i++) {
                System.out.print(C + " ");
                C = C * (line - i) / (i + 1);
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