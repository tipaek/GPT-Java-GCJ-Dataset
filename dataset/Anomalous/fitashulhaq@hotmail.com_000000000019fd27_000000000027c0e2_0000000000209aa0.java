import java.util.*;
import java.io.*;

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
            Arrays.fill(valuesAtline, n);
            int sum = calculateSum(valuesAtline);
            boolean possible = adjustValues(valuesAtline, k, n);

            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            int[][] matrix = new int[n][n];
            fillDiagonal(matrix, valuesAtline, n);

            if (fillMatrix(matrix, n)) {
                System.out.println("Case #" + i + ": ");
                printMatrix(matrix, n);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean adjustValues(int[] valuesAtline, int k, int n) {
        int workingOn = n - 1;
        int sum = calculateSum(valuesAtline);
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

    private static void fillDiagonal(int[][] matrix, int[] valuesAtline, int n) {
        for (int i = 0; i < n; i++) {
            matrix[i][i] = valuesAtline[i];
        }
    }

    private static boolean fillMatrix(int[][] matrix, int n) {
        Random r = new Random();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row == col) continue;
                int value = n;
                while (checkRows(value, matrix, row, col, n) || checkColumns(value, matrix, row, col, n)) {
                    value--;
                    if (value == 0) return false;
                }
                matrix[row][col] = value;
            }
        }
        return true;
    }

    private static boolean checkColumns(int value, int[][] matrix, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (i == col) continue;
            if (matrix[row][i] == value) return true;
        }
        return false;
    }

    private static boolean checkRows(int value, int[][] matrix, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            if (matrix[i][col] == value) return true;
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

    private static void printMatrix(int[][] matrix, int n) {
        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(row[j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}