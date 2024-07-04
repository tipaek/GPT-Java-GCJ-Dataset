import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

    private static int n, m;

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

    public static void printMatrix(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            for (boolean value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            String[] dimensions = br.readLine().split(" ");
            n = Integer.parseInt(dimensions[0]);
            m = Integer.parseInt(dimensions[1]);

            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            BigInteger totalSum = BigInteger.valueOf(calculateSum(matrix));
            while (true) {
                boolean changed = false;
                int[][] matrixCopy = new int[n][m];

                for (int i = 0; i < n; i++) {
                    System.arraycopy(matrix[i], 0, matrixCopy[i], 0, m);
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (matrix[i][j] == 0) continue;

                        long left = 0, right = 0, top = 0, bottom = 0;
                        int denominator = 0;

                        for (int k = i - 1; k >= 0; k--) {
                            if (matrix[k][j] != 0) {
                                left = matrix[k][j];
                                denominator++;
                                break;
                            }
                        }

                        for (int k = i + 1; k < n; k++) {
                            if (matrix[k][j] != 0) {
                                right = matrix[k][j];
                                denominator++;
                                break;
                            }
                        }

                        for (int k = j - 1; k >= 0; k--) {
                            if (matrix[i][k] != 0) {
                                top = matrix[i][k];
                                denominator++;
                                break;
                            }
                        }

                        for (int k = j + 1; k < m; k++) {
                            if (matrix[i][k] != 0) {
                                bottom = matrix[i][k];
                                denominator++;
                                break;
                            }
                        }

                        if ((left + right + top + bottom) > denominator * matrix[i][j]) {
                            matrixCopy[i][j] = 0;
                            changed = true;
                        }
                    }
                }

                if (!changed) break;
                totalSum = totalSum.add(BigInteger.valueOf(calculateSum(matrixCopy)));
                matrix = matrixCopy;
            }

            System.out.printf("Case #%d: %d\n", caseNumber, totalSum);
        }

        br.close();
    }
}