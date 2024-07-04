import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            int trace = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = countRowDuplicates(matrix, N);
            int colDuplicates = countColDuplicates(matrix, N);

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }

    private static int countRowDuplicates(int[][] matrix, int N) {
        int rowDuplicates = 0;
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (seen[matrix[i][j] - 1]) {
                    rowDuplicates++;
                    break;
                }
                seen[matrix[i][j] - 1] = true;
            }
        }
        return rowDuplicates;
    }

    private static int countColDuplicates(int[][] matrix, int N) {
        int colDuplicates = 0;
        for (int j = 0; j < N; j++) {
            boolean[] seen = new boolean[N];
            for (int i = 0; i < N; i++) {
                if (seen[matrix[i][j] - 1]) {
                    colDuplicates++;
                    break;
                }
                seen[matrix[i][j] - 1] = true;
            }
        }
        return colDuplicates;
    }
}