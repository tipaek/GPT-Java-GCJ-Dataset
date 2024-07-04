import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner scanner = null;
        try {
            scanner = DEBUG ? new Scanner(new FileInputStream("test.in")) : new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            Integer[][] matrix = new Integer[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(matrix[i], 0);
            }
            boolean isPossible = solve(matrix, n, k);
            System.out.println("Case #" + testCase + ": " + (isPossible ? "POSSIBLE" : "IMPOSSIBLE"));
            if (isPossible) {
                for (Integer[] row : matrix) {
                    System.out.println(formatRow(row));
                }
            }
        }
    }

    static boolean solve(Integer[][] matrix, int n, int k) {
        return fillDiagonal(matrix, n, k, 0);
    }

    static boolean fillDiagonal(Integer[][] matrix, int n, int k, int index) {
        if (index == n && k == 0) {
            return fillMatrix(matrix, n, 0, 0);
        } else if (index == n) {
            return false;
        } else {
            for (int i = 1; i <= n; i++) {
                matrix[index][index] = i;
                if (fillDiagonal(matrix, n, k - i, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    static boolean fillMatrix(Integer[][] matrix, int n, int col, int row) {
        if (matrix[col][row] != 0) {
            if (col == n - 1 && row == n - 1) {
                return isMatrixValid(matrix);
            }
            int nextCol = (col + 1) % n;
            int nextRow = row + (nextCol == 0 ? 1 : 0);
            return fillMatrix(matrix, n, nextCol, nextRow);
        } else {
            for (int i = 1; i <= n; i++) {
                matrix[col][row] = i;
                if (isMatrixValid(matrix)) {
                    int nextCol = (col + 1) % n;
                    int nextRow = row + (nextCol == 0 ? 1 : 0);
                    if (fillMatrix(matrix, n, nextCol, nextRow)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static boolean isMatrixValid(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (!isUnique(matrix[i]) || !isUnique(getColumn(matrix, i))) {
                return false;
            }
        }
        return true;
    }

    static boolean isUnique(Integer[] array) {
        Set<Integer> set = new HashSet<>();
        for (Integer value : array) {
            if (value != 0 && !set.add(value)) {
                return false;
            }
        }
        return true;
    }

    static Integer[] getColumn(Integer[][] matrix, int col) {
        Integer[] column = new Integer[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][col];
        }
        return column;
    }

    static String formatRow(Integer[] row) {
        StringBuilder sb = new StringBuilder();
        for (Integer value : row) {
            sb.append(value).append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}