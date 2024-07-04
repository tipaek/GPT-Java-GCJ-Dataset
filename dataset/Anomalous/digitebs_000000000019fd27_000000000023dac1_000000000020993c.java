import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            for (int i = 0; i < n; i++) {
                int[] rowCheck = new int[n + 1];
                int[] colCheck = new int[n + 1];
                boolean rowDuplicate = false;
                boolean colDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    if (rowCheck[matrix[i][j]] > 0) {
                        rowDuplicate = true;
                    }
                    rowCheck[matrix[i][j]]++;

                    if (colCheck[matrix[j][i]] > 0) {
                        colDuplicate = true;
                    }
                    colCheck[matrix[j][i]]++;
                }

                if (rowDuplicate) {
                    repeatedRows++;
                }
                if (colDuplicate) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}