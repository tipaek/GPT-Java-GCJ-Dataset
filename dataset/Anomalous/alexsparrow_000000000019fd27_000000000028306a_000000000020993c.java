import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int diagonalSum = 0, repeatedRows = 0, repeatedCols = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                diagonalSum += matrix[i][i];
            }

            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    repeatedRows++;
                }

                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[101]; // Assuming values are between 1 and 100
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}