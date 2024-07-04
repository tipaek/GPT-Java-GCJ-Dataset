import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.processCases();
        solution.closeResources();
    }

    private void processCases() {
        int t = readInt();
        for (int i = 1; i <= t; i++) {
            pw.print("Case #" + i + ": " + processCase());
        }
    }

    private String processCase() {
        int[] arr = readIntArray();
        int n = arr[0];
        int k = arr[1];

        int[][] matrix = new int[n][n];
        initializeMatrix(n, matrix);

        int remainingDifference = k - n;
        while (remainingDifference > 0) {
            int minDifference = Integer.MAX_VALUE;
            int row1 = -1, col1 = -1, row2 = -1, col2 = -1;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int diff = calculateDifference(matrix, i, j);
                    if (diff > 0 && diff < minDifference) {
                        minDifference = diff;
                        row1 = i;
                        col1 = j;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int diff = calculateDifference(matrix, j, i);
                    if (diff > 0 && diff < minDifference) {
                        minDifference = diff;
                        row2 = i;
                        col2 = j;
                    }
                }
            }

            if (minDifference == Integer.MAX_VALUE) {
                return "IMPOSSIBLE";
            }

            if (row2 != -1) {
                swapColumns(matrix, n, row2, col2);
            } else {
                swapRows(matrix, n, row1, col1);
            }

            remainingDifference -= minDifference;
        }

        if (remainingDifference < 0) {
            return "IMPOSSIBLE";
        }

        return buildResultString(matrix, n);
    }

    private void initializeMatrix(int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][(i + j) % n] = j + 1;
            }
        }
    }

    private int calculateDifference(int[][] matrix, int i, int j) {
        return matrix[i][j] - matrix[j][j] + matrix[j][i] - matrix[i][i];
    }

    private void swapColumns(int[][] matrix, int n, int col1, int col2) {
        for (int i = 0; i < n; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    private void swapRows(int[][] matrix, int n, int row1, int row2) {
        int[] temp = new int[n];
        System.arraycopy(matrix[row1], 0, temp, 0, n);
        System.arraycopy(matrix[row2], 0, matrix[row1], 0, n);
        System.arraycopy(temp, 0, matrix[row2], 0, n);
    }

    private String buildResultString(int[][] matrix, int n) {
        StringBuilder result = new StringBuilder("POSSIBLE\n");
        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                result.append(row[j]);
                if (j < n - 1) {
                    result.append(" ");
                } else {
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    private void closeResources() {
        pw.close();
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private int[] readIntArray() {
        StringTokenizer st = new StringTokenizer(readLine());
        int n = st.countTokens();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}