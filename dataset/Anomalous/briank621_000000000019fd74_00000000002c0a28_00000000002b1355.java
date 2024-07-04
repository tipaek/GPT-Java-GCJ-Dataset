import java.util.*;
import java.io.*;

class Solution {

    private static int n, m;

    public static long calculateSum(int[][] matrix) {
        long total = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                total += value;
            }
        }
        return total;
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
                int[][] matrixCopy = new int[n][m];
                boolean[][] possible = new boolean[n][m];

                for (int i = 0; i < n; i++) {
                    matrixCopy[i] = Arrays.copyOf(matrix[i], m);
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (matrix[i][j] == 0) continue;

                        int left = 0, right = 0, top = 0, bottom = 0, denominator = 0;
                        int tempI = i, tempJ = j;

                        while (tempI > 0 && matrix[tempI - 1][j] == 0) tempI--;
                        if (tempI > 0) {
                            left = matrix[tempI - 1][j];
                            denominator++;
                        }

                        tempI = i;
                        while (tempI < n - 1 && matrix[tempI + 1][j] == 0) tempI++;
                        if (tempI < n - 1) {
                            right = matrix[tempI + 1][j];
                            denominator++;
                        }

                        while (tempJ > 0 && matrix[i][tempJ - 1] == 0) tempJ--;
                        if (tempJ > 0) {
                            top = matrix[i][tempJ - 1];
                            denominator++;
                        }

                        tempJ = j;
                        while (tempJ < m - 1 && matrix[i][tempJ + 1] == 0) tempJ++;
                        if (tempJ < m - 1) {
                            bottom = matrix[i][tempJ + 1];
                            denominator++;
                        }

                        if ((left + right + top + bottom) > denominator * matrix[i][j]) {
                            matrixCopy[i][j] = 0;
                            hasChanged = true;
                        }
                    }
                }

                if (!hasChanged) break;

                totalSum += calculateSum(matrixCopy);
                matrix = matrixCopy;
            }

            System.out.printf("Case #%d: %d\n", caseNumber, totalSum);
        }

        reader.close();
    }
}