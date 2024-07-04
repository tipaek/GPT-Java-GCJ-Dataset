import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numCases; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                String[] rowValues = reader.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(rowValues[k]);
                }
            }

            int rowCount = countDuplicateRows(matrix);
            int colCount = countDuplicateCols(matrix);
            int trace = calculateTrace(matrix);

            System.out.printf("Case #%d: %d %d %d\n", i + 1, trace, rowCount, colCount);
        }

        reader.close();
    }

    private static int countDuplicateRows(int[][] matrix) {
        int n = matrix.length;
        int rowCount = 0;
        for (int[] row : matrix) {
            boolean[] used = new boolean[n];
            Arrays.fill(used, false);
            for (int value : row) {
                if (used[value - 1]) {
                    rowCount++;
                    break;
                }
                used[value - 1] = true;
            }
        }
        return rowCount;
    }

    private static int countDuplicateCols(int[][] matrix) {
        int n = matrix.length;
        int colCount = 0;
        for (int j = 0; j < n; j++) {
            boolean[] used = new boolean[n];
            Arrays.fill(used, false);
            for (int[] row : matrix) {
                if (used[row[j] - 1]) {
                    colCount++;
                    break;
                }
                used[row[j] - 1] = true;
            }
        }
        return colCount;
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
}