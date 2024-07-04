import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] rowSum = new int[n];
            int[] colSum = new int[n];
            int expectedSum = (n * (n + 1)) / 2;

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    rowSum[i] += matrix[i][j];
                    colSum[j] += matrix[i][j];

                    if (rowCheck[matrix[i][j]]) {
                        rowRepeats++;
                        rowCheck = new boolean[n + 1]; // Reset the row check to avoid multiple counts
                        break;
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }

                    if (colCheck[matrix[j][i]]) {
                        colRepeats++;
                        colCheck = new boolean[n + 1]; // Reset the col check to avoid multiple counts
                        break;
                    } else {
                        colCheck[matrix[j][i]] = true;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        scanner.close();
    }
}