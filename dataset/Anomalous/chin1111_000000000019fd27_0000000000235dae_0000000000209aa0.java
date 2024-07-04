import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine().trim());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            matrix = new int[n][n];
            fillMatrix(n);

            int factor = 0;
            for (int i = 1; i <= k; i++) {
                if (k == i * n) {
                    factor = i;
                    break;
                }
            }

            if (factor != 0) {
                int[][] resultMatrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == factor) {
                            for (int l = 0; l < n; l++) {
                                resultMatrix[l][i] = matrix[l][j];
                            }
                            break;
                        }
                    }
                }

                System.out.println("Case #" + testCase + ": POSSIBLE");
                printMatrix(resultMatrix, n);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    static void fillMatrix(int n) {
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                matrix[i][right] = 1;
                fillColumn(i, right, n);
                right--;
            } else {
                matrix[i][left] = 1;
                fillColumn(i, left, n);
                left++;
            }
        }
    }

    static void fillColumn(int row, int col, int size) {
        int value = 2;
        for (int i = row + 1; i < size; i++) {
            matrix[i][col] = value++;
        }
        for (int i = 0; i < row; i++) {
            matrix[i][col] = value++;
        }
    }

    static void printMatrix(int[][] mat, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mat[i][j]);
                if (j < size - 1) {
                    System.out.print(" ");
                }
            }
            if (i < size - 1) {
                System.out.println();
            }
        }
    }
}