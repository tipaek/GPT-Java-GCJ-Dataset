import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scan.nextInt();
                }
            }

            solve(matrix, n, caseNum);
        }
    }

    private static void solve(int[][] matrix, int size, int caseNumber) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        int expectedSum = size * (size + 1) / 2;
        int repeatedRows = 0;
        int repeatedCols = 0;

        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (rowCheck[matrix[i][j]]) {
                    rowHasDuplicate = true;
                } else {
                    rowCheck[matrix[i][j]] = true;
                }

                if (colCheck[matrix[j][i]]) {
                    colHasDuplicate = true;
                } else {
                    colCheck[matrix[j][i]] = true;
                }
            }

            if (rowHasDuplicate) {
                repeatedRows++;
            }
            if (colHasDuplicate) {
                repeatedCols++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedCols);
    }
}