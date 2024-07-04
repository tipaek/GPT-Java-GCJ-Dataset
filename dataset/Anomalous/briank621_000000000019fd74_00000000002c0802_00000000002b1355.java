import java.util.*;
import java.io.*;

class Solution {

    static int n, m;

    public static long calculateSum(int[][] matrix) {
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                totalSum += matrix[i][j];
            }
        }
        return totalSum;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printBooleanMatrix(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            for (boolean value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] dimensions = reader.readLine().split(" ");
            n = Integer.parseInt(dimensions[0]);
            m = Integer.parseInt(dimensions[1]);

            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            long totalSum = calculateSum(matrix);
            while (true) {
                boolean hasChanged = false;
                int[][] tempMatrix = new int[n][m];

                for (int i = 0; i < n; i++) {
                    tempMatrix[i] = Arrays.copyOf(matrix[i], m);
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (matrix[i][j] == 0) continue;

                        int left = 0, right = 0, top = 0, bottom = 0, count = 0;

                        for (int k = i - 1; k >= 0; k--) {
                            if (matrix[k][j] != 0) {
                                left = matrix[k][j];
                                count++;
                                break;
                            }
                        }
                        for (int k = i + 1; k < n; k++) {
                            if (matrix[k][j] != 0) {
                                right = matrix[k][j];
                                count++;
                                break;
                            }
                        }
                        for (int k = j - 1; k >= 0; k--) {
                            if (matrix[i][k] != 0) {
                                top = matrix[i][k];
                                count++;
                                break;
                            }
                        }
                        for (int k = j + 1; k < m; k++) {
                            if (matrix[i][k] != 0) {
                                bottom = matrix[i][k];
                                count++;
                                break;
                            }
                        }

                        if ((left + right + top + bottom) / (double) count > matrix[i][j]) {
                            tempMatrix[i][j] = 0;
                            hasChanged = true;
                        }
                    }
                }

                if (!hasChanged) break;

                totalSum += calculateSum(tempMatrix);
                matrix = tempMatrix;
            }

            System.out.printf("Case #%d: %d\n", caseNumber, totalSum);
        }

        reader.close();
    }
}