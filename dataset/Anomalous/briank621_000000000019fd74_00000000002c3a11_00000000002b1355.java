import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Solution {

    static int n, m;

    public static long calculateSum(int[][] matrix) {
        long totalSum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                totalSum += value;
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

    public static void printMatrix(boolean[][] matrix) {
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

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
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

            BigInteger totalSum = BigInteger.valueOf(calculateSum(matrix));
            while (true) {
                boolean changed = false;
                int[][] tempMatrix = new int[n][m];

                for (int i = 0; i < n; i++) {
                    System.arraycopy(matrix[i], 0, tempMatrix[i], 0, m);
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (matrix[i][j] == 0) continue;

                        long left = 0, right = 0, top = 0, bottom = 0;
                        int count = 0;

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

                        if ((left + right + top + bottom) > count * matrix[i][j]) {
                            tempMatrix[i][j] = 0;
                            changed = true;
                        }
                    }
                }

                if (!changed) break;

                totalSum = totalSum.add(BigInteger.valueOf(calculateSum(tempMatrix)));
                matrix = tempMatrix;
            }
            System.out.printf("Case #%d: %d\n", caseNum, totalSum);
        }

        reader.close();
    }
}