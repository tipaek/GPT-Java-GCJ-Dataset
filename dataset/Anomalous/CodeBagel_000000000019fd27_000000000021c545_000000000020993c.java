import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 1; i <= cases; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Read the matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            // Track duplicates
            boolean[] duplicateRow = new boolean[n];
            boolean[] duplicateCol = new boolean[n];

            for (int num = 1; num <= n; num++) {
                for (int row = 0; row < n; row++) {
                    boolean rowHasDuplicate = false;
                    boolean colHasDuplicate = false;

                    for (int col = 0; col < n; col++) {
                        if (matrix[row][col] == num) {
                            if (rowHasDuplicate) {
                                duplicateRow[row] = true;
                            } else {
                                rowHasDuplicate = true;
                            }
                        }

                        if (matrix[col][row] == num) {
                            if (colHasDuplicate) {
                                duplicateCol[row] = true;
                            } else {
                                colHasDuplicate = true;
                            }
                        }
                    }
                }
            }

            // Count duplicate rows and columns
            for (int j = 0; j < n; j++) {
                if (duplicateRow[j]) {
                    duplicateRows++;
                }
                if (duplicateCol[j]) {
                    duplicateCols++;
                }
            }

            // Calculate trace
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        in.close();
    }
}