import java.util.*;
import java.io.*;

public class Solution {
    static int row = 0, col = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Number of test cases

        for (int x = 1; x <= T; ++x) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate rows and columns
            checkDuplicates(N, matrix);

            // Print the result for the current test case
            System.out.println("Case #" + x + ": " + trace + " " + row + " " + col);
            row = 0;
            col = 0;
        }
    }

    private static void checkDuplicates(int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            boolean rowDuplicate = false;
            boolean colDuplicate = false;

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (!rowDuplicate && matrix[i][j] == matrix[i][k]) {
                        row++;
                        rowDuplicate = true;
                    }
                    if (!colDuplicate && matrix[j][i] == matrix[k][i]) {
                        col++;
                        colDuplicate = true;
                    }
                }
            }
        }
    }
}