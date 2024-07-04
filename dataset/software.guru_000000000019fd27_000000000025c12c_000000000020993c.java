import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        for (int tc = 1; tc <= numberOfTestCases; tc++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] row = scanner.next().split(" ");
                for (int j = 0; j < row.length; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int diagonal = 0;
            for (int i = 0; i < n; i++) {
                diagonal += matrix[i][i];
            }
            int repeatedRows = 0;
            for (int i = 0; i < n; i++) {
                int[] row = Arrays.copyOf(matrix[i], n);
                for (i = 0; i < n; i++) {
                    if (row[Math.abs(row[i])] >= 0) {
                        row[Math.abs(row[i])] = -row[Math.abs(row[i])];
                    } else {
                        repeatedRows++;
                        break;
                    }
                }
            }
            int repeatedColumns = 0;
            int[][] transposedMatrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    transposedMatrix[i][j] = matrix[j][i];
                }
            }
            for (int i = 0; i < n; i++) {
                int[] row = Arrays.copyOf(transposedMatrix[i], n);
                for (i = 0; i < n; i++) {
                    if (row[Math.abs(row[i])] >= 0) {
                        row[Math.abs(row[i])] = -row[Math.abs(row[i])];
                    } else {
                        repeatedColumns++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + tc + ": " + diagonal + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}