import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static int computeTraceSum(int[][] matrix) {
        int n = matrix.length;
        int traceSum = 0;

        for (int i = 0; i < n; i++) {
            traceSum += matrix[i][i];
            HashSet<Integer> rowSet = new HashSet<>();

            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (rowSet.contains(value)) {
                    return -1; // Duplicate found in row
                }
                rowSet.add(value);
            }
        }

        for (int i = 0; i < n; i++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int value = matrix[j][i];
                if (colSet.contains(value)) {
                    return -1; // Duplicate found in column
                }
                colSet.add(value);
            }
        }

        return traceSum;
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private static void swapCols(int[][] matrix, int col1, int col2) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }

    private static boolean findTrace(int[][] matrix, int start, int end, int targetTrace, int[][] result) {
        if (start == end) {
            if (computeTraceSum(matrix) == targetTrace) {
                int n = matrix.length;
                for (int i = 0; i < n; i++) {
                    System.arraycopy(matrix[i], 0, result[i], 0, n);
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
            int tempValue = startValue;
            int col = 0;

            while (tempValue <= n) {
                matrix[i][col++] = tempValue++;
            }

            for (int j = 1; j < startValue; j++) {
                matrix[i][col++] = j;
            }

            startValue--;
        }
    }

    private static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int[] row : matrix) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println(row[n - 1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int targetTrace = scanner.nextInt();
            int[][] matrix = new int[n][n];
            setLatinSquare(matrix);
            int[][] result = new int[n][n];

            boolean isPossible = findTrace(matrix, 0, n - 1, targetTrace, result);
            if (isPossible) {
                System.out.printf("Case #%d: POSSIBLE\n", t);
                printMatrix(result);
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            }
        }

        scanner.close();
    }
}