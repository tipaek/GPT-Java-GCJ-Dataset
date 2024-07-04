import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            int[] result = analyzeMatrix(matrix);
            System.out.printf("Case #%d: %d %d %d%n", i, result[0], result[1], result[2]);
        }
    }

    private static int[] analyzeMatrix(int[][] matrix) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];

            boolean[] rowSeen = new boolean[size + 1];
            boolean[] colSeen = new boolean[size + 1];

            for (int j = 0; j < size; j++) {
                if (rowSeen[matrix[i][j]]) {
                    rowDuplicates++;
                    break;
                }
                rowSeen[matrix[i][j]] = true;
            }

            for (int j = 0; j < size; j++) {
                if (colSeen[matrix[j][i]]) {
                    colDuplicates++;
                    break;
                }
                colSeen[matrix[j][i]] = true;
            }
        }

        return new int[]{trace, rowDuplicates, colDuplicates};
    }
}