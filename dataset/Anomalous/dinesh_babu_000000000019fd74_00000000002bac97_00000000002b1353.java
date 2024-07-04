import java.io.*;

class Solution {

    // Function to print Pascal's Triangle
    static void printPascal(int n) {
        for (int line = 0; line < n; line++) {
            for (int i = 0; i <= line; i++) {
                System.out.print(binomialCoefficient(line, i) + " ");
            }
            System.out.println();
        }
    }

    // Function to calculate binomial coefficient
    static int binomialCoefficient(int n, int k) {
        int result = 1;

        // Optimize calculation by using the property C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }

        for (int i = 0; i < k; ++i) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 7;
        printPascal(n);
    }
}