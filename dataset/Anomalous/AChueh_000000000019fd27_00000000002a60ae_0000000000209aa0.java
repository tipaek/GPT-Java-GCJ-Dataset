import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner in = null;
        try {
            in = DEBUG ? new Scanner(new FileInputStream("test.in")) : new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            Integer[][] matrix = new Integer[n][n];
            for (Integer[] row : matrix) {
                Arrays.fill(row, 0);
            }

            boolean found = fillDiagonal(matrix, n, k, 0);
            System.out.println("Case #" + i + ": " + (found ? "POSSIBLE" : "IMPOSSIBLE"));
            if (found) {
                for (Integer[] row : matrix) {
                    System.out.println(formatRow(row));
                }
            }
        }
    }

    static boolean fillDiagonal(Integer[][] matrix, int n, int k, int index) {
        if (index == n && k == 0) {
            return fillMatrix(matrix, n, 0, 0);
        } else if (index == n) {
            return false;
        } else {
            for (int i = 1; i <= n; ++i) {
                matrix[index][index] = i;
                if (fillDiagonal(matrix, n, k - i, index + 1)) {
                    return true;
                }
            }
            matrix[index][index] = 0;
            return false;
        }
    }

    static boolean fillMatrix(Integer[][] matrix, int n, int row, int col) {
        if (matrix[row][col] != 0) {
            if (row == n - 1 && col == n - 1) {
                return true;
            }
            int nextRow = (row + 1) % n;
            int nextCol = col + (nextRow == 0 ? 1 : 0);
            return fillMatrix(matrix, n, nextRow, nextCol);
        } else {
            for (int i = 1; i <= n; ++i) {
                matrix[row][col] = i;
                if (isMatrixValid(matrix)) {
                    int nextRow = (row + 1) % n;
                    int nextCol = col + (nextRow == 0 ? 1 : 0);
                    if (fillMatrix(matrix, n, nextRow, nextCol)) {
                        return true;
                    }
                }
            }
            matrix[row][col] = 0;
            return false;
        }
    }

    static boolean isMatrixValid(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < matrix.length; ++j) {
                if (matrix[i][j] != 0 && !rowSet.add(matrix[i][j])) {
                    return false;
                }
            }
        }

        for (int j = 0; j < matrix.length; ++j) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < matrix.length; ++i) {
                if (matrix[i][j] != 0 && !colSet.add(matrix[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    static String formatRow(Integer[] row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row.length; ++i) {
            sb.append(row[i]).append(' ');
        }
        return sb.toString().trim();
    }
}