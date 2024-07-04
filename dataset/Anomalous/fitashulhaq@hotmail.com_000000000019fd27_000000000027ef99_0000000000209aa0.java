import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine(); // Consume the newline character

        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();

            if (line.isEmpty()) {
                i--;
                continue;
            }

            String[] lineParts = line.split(" ");
            int n = Integer.parseInt(lineParts[0]);
            int k = Integer.parseInt(lineParts[1]);

            if (n * n < k) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            int[] valuesAtline = new int[n];
            int input = (k % n == 0) ? k / n : n;

            for (int index = 0; index < n; index++) {
                valuesAtline[index] = input;
            }

            boolean possible = adjustValues(valuesAtline, k);
            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            int[][] matrix = new int[n][n];
            fillDiagonal(matrix, valuesAtline);
            boolean success = fillMatrix(matrix, n);

            if (success) {
                printMatrix(matrix, i);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean adjustValues(int[] valuesAtline, int k) {
        int sum = calculateSum(valuesAtline);
        int workingOn = valuesAtline.length - 1;

        while (sum != k) {
            if (valuesAtline[workingOn] == 1) {
                workingOn--;
            }

            if (workingOn == 1 && valuesAtline[workingOn] == 1) {
                return false;
            }

            valuesAtline[workingOn]--;
            sum = calculateSum(valuesAtline);
        }

        return true;
    }

    private static void fillDiagonal(int[][] matrix, int[] valuesAtline) {
        for (int i = 0; i < valuesAtline.length; i++) {
            matrix[i][i] = valuesAtline[i];
        }
    }

    private static boolean fillMatrix(int[][] matrix, int n) {
        Random random = new Random();
        int attempts = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int value = 1;
                while (checkRows(value, matrix, i, j, n) || checkColumns(value, matrix, i, j, n)) {
                    value++;
                    if (value > n) {
                        attempts++;
                        if (attempts > n) return false;
                        value = 1;
                    }
                }
                matrix[i][j] = value;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix, int caseNumber) {
        System.out.print("Case #" + caseNumber + ": ");
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j != row.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static boolean checkColumns(int value, int[][] matrix, int i, int j, int n) {
        for (int row = 0; row < n; row++) {
            if (row == j) continue;
            if (value == matrix[i][row]) return true;
        }
        return false;
    }

    private static boolean checkRows(int value, int[][] matrix, int i, int j, int n) {
        for (int row = 0; row < n; row++) {
            if (row == i) continue;
            if (value == matrix[row][j]) return true;
        }
        return false;
    }

    private static int calculateSum(int[] valuesAtline) {
        int sum = 0;
        for (int value : valuesAtline) {
            sum += value;
        }
        return sum;
    }
}