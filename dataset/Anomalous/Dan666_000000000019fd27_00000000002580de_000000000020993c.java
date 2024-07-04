import java.util.Scanner;

public class Solution {

    public static void analyzeMatrix(int[][] matrix, int n, int caseNumber) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        int[] rowCheck = new int[10];
        int[] colCheck = new int[10];

        for (int i = 0; i < n; i++) {
            Arrays.fill(rowCheck, 0);
            Arrays.fill(colCheck, 0);
            boolean rowHasDuplicates = false;
            boolean colHasDuplicates = false;

            for (int j = 0; j < n; j++) {
                // Calculate the trace
                if (i == j) {
                    trace += matrix[i][j];
                }

                // Check for duplicates in the row
                if (rowCheck[matrix[i][j]]++ > 0) {
                    rowHasDuplicates = true;
                }

                // Check for duplicates in the column
                if (colCheck[matrix[j][i]]++ > 0) {
                    colHasDuplicates = true;
                }
            }

            if (rowHasDuplicates) {
                rowDuplicates++;
            }
            if (colHasDuplicates) {
                colDuplicates++;
            }
        }

        System.out.format("Case #%d: %d %d %d\n", caseNumber, trace, rowDuplicates, colDuplicates);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            analyzeMatrix(matrix, n, i);
        }
    }
}