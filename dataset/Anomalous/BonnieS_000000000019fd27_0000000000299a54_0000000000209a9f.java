import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.next());
        int caseNumber = 1;

        while (testCases > 0) {
            int n = Integer.parseInt(scanner.next());
            int k = Integer.parseInt(scanner.next());
            int[][] matrix = new int[n][n];

            String result = "POSSIBLE";
            if (n > k || n * n < k) {
                result = "IMPOSSIBLE";
            } else {
                matrix = generateMatrix(n);
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            if (result.equals("POSSIBLE")) {
                printMatrix(matrix);
                System.out.println("Trace: " + calculateTrace(matrix));
            }

            caseNumber++;
            testCases--;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            int value = row + 1;
            for (int col = 0; col < n; col++) {
                matrix[row][col] = value;
                value = (value % n) + 1;
            }
        }
        return matrix;
    }
}