import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= t; ++i) {
            String line = scanner.nextLine();

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

            int[][] matrix = new int[n][n];
            int[] valuesAtLine = new int[n];
            for (int j = 0; j < n; j++) {
                valuesAtLine[j] = n;
            }

            boolean possible = adjustValues(valuesAtLine, k);
            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            fillDiagonal(matrix, valuesAtLine);
            boolean success = fillMatrix(matrix, n);

            if (success) {
                printMatrix(matrix, i, n);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean adjustValues(int[] valuesAtLine, int targetSum) {
        int sum = calculateSum(valuesAtLine);
        int n = valuesAtLine.length;
        int workingOn = n - 1;

        while (sum != targetSum) {
            if (valuesAtLine[workingOn] == 1) {
                workingOn--;
            }

            if (workingOn == 1 && valuesAtLine[workingOn] == 1) {
                return false;
            }

            valuesAtLine[workingOn]--;
            sum = calculateSum(valuesAtLine);
        }
        return true;
    }

    private static void fillDiagonal(int[][] matrix, int[] valuesAtLine) {
        for (int i = 0; i < valuesAtLine.length; i++) {
            matrix[i][i] = valuesAtLine[i];
        }
    }

    private static boolean fillMatrix(int[][] matrix, int n) {
        Random random = new Random();
        int attempts = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int value = n;
                while (true) {
                    if (isValid(matrix, i, j, value, n)) {
                        matrix[i][j] = value;
                        break;
                    }

                    value--;
                    if (value == 0) {
                        attempts++;
                        if (attempts > n) {
                            return false;
                        }
                        value = n;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] matrix, int row, int col, int value, int n) {
        for (int i = 0; i < n; i++) {
            if (matrix[row][i] == value || matrix[i][col] == value) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix, int caseNumber, int n) {
        System.out.println("Case #" + caseNumber + ":");
        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(row[j]);
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static int calculateSum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}