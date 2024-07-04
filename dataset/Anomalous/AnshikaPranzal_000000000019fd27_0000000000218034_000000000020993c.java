import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read matrix and calculate trace and row repeats
            for (int row = 0; row < n; row++) {
                boolean[] rowCheck = new boolean[n];
                boolean rowHasRepeat = false;
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    if (rowCheck[matrix[row][col] - 1]) {
                        if (!rowHasRepeat) {
                            rowRepeats++;
                            rowHasRepeat = true;
                        }
                    } else {
                        rowCheck[matrix[row][col] - 1] = true;
                    }
                }
            }

            // Calculate column repeats
            for (int col = 0; col < n; col++) {
                boolean[] colCheck = new boolean[n];
                boolean colHasRepeat = false;
                for (int row = 0; row < n; row++) {
                    if (colCheck[matrix[row][col] - 1]) {
                        if (!colHasRepeat) {
                            colRepeats++;
                            colHasRepeat = true;
                        }
                    } else {
                        colCheck[matrix[row][col] - 1] = true;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, rowRepeats, colRepeats);
        }

        sc.close();
    }
}