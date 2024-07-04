import java.util.Scanner;

public class Solution {

    private static int computeTraceSum(int[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private static void swapCols(int[][] matrix, int col1, int col2) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    private static boolean findTrace(int[][] matrix, int start, int end, int targetTrace, int[][] result) {
        if (start == end) {
            if (computeTraceSum(matrix) == targetTrace) {
                for (int i = 0; i < matrix.length; i++) {
                    System.arraycopy(matrix[i], 0, result[i], 0, matrix.length);
                }
                return true;
            }
        } else {
            for (int i = start; i <= end; i++) {
                swapRows(matrix, start, i);
                if (findTrace(matrix, start + 1, end, targetTrace, result)) {
                    return true;
                }
                swapRows(matrix, start, i);

                swapCols(matrix, start, i);
                if (findTrace(matrix, start + 1, end, targetTrace, result)) {
                    return true;
                }
                swapCols(matrix, start, i);
            }
        }
        return false;
    }

    private static void setLatinSquare(int[][] matrix) {
        int n = matrix.length;
        int startValue = n + 1;
        for (int i = 0; i < n; i++) {
            int currentValue = startValue;
            int col = 0;
            while (currentValue <= n) {
                matrix[i][col++] = currentValue++;
            }
            for (int j = 1; j < startValue; j++) {
                matrix[i][col++] = j;
            }
            startValue--;
        }
    }

    private static void printArr(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 0; j < row.length - 1; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println(row[row.length - 1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];
            setLatinSquare(matrix);
            int[][] result = new int[n][n];
            boolean isPossible = findTrace(matrix, 0, n - 1, k, result);
            if (isPossible) {
                System.out.printf("Case #%d: POSSIBLE\n", t);
                printArr(result);
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            }
        }
        scanner.close();
    }
}