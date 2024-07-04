import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;

            // Read the matrix and calculate trace
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    matrix[i][j]--; // Adjusting for 0-based index
                }
            }

            int rowCount = 0;
            int columnCount = 0;

            // Check rows for duplicates
            for (int i = 0; i < N; i++) {
                boolean[] visited = new boolean[N];
                boolean duplicateFound = false;
                for (int j = 0; j < N; j++) {
                    if (visited[matrix[i][j]]) {
                        rowCount++;
                        duplicateFound = true;
                        break;
                    }
                    visited[matrix[i][j]] = true;
                }
                if (duplicateFound) {
                    continue;
                }
            }

            // Check columns for duplicates
            for (int j = 0; j < N; j++) {
                boolean[] visited = new boolean[N];
                boolean duplicateFound = false;
                for (int i = 0; i < N; i++) {
                    if (visited[matrix[i][j]]) {
                        columnCount++;
                        duplicateFound = true;
                        break;
                    }
                    visited[matrix[i][j]] = true;
                }
                if (duplicateFound) {
                    continue;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + columnCount);
        }
    }
}