import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0, rowRepeats = 0, colRepeats = 0;

            // Read matrix and calculate diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                diagonalSum += matrix[i][i];
            }

            // Check for repeated elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[101];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            // Check for repeated elements in columns
            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[101];
                for (int j = 0; j < n; j++) {
                    if (colCheck[matrix[j][i]]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
    }
}