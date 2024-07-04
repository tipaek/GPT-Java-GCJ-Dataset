import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int trace = 0;
            int rowIssues = 0;
            int columnIssues = 0;

            int[][] matrix = new int[N][N];
            boolean[] rowCheck;
            boolean[] columnCheck;

            // Read the matrix and compute the trace
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for row issues
            for (int i = 0; i < N; i++) {
                rowCheck = new boolean[N + 1];
                for (int j = 0; j < N; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowIssues++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            // Check for column issues
            for (int j = 0; j < N; j++) {
                columnCheck = new boolean[N + 1];
                for (int i = 0; i < N; i++) {
                    if (columnCheck[matrix[i][j]]) {
                        columnIssues++;
                        break;
                    }
                    columnCheck[matrix[i][j]] = true;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowIssues + " " + columnIssues);
        }
    }
}