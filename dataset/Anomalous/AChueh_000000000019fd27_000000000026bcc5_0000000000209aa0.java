import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner scanner = null;
        try {
            scanner = DEBUG ? new Scanner(new FileInputStream("test.in")) : new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            Integer[][] matrix = new Integer[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(matrix[i], 0);
            }
            boolean possible = solve(matrix, n, k);
            System.out.println("Case #" + t + ": " + (possible ? "POSSIBLE" : "IMPOSSIBLE"));
            if (possible) {
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
            matrix[index][index] = 0;
            return false;
        }
    }

    static boolean fillMatrix(Integer[][] matrix, int n, int col, int row) {
        if (matrix[col][row] != 0) {
            if (col == n - 1 && row == n - 1) {
                return isValid(matrix);
            }
            int nextCol = (col + 1) % n;
            int nextRow = row + (nextCol == 0 ? 1 : 0);
            return fillMatrix(matrix, n, nextCol, nextRow);
        } else {
            for (int i = 1; i <= n; i++) {
                matrix[col][row] = i;
                if (isValid(matrix)) {
                    int nextCol = (col + 1) % n;
                    int nextRow = row + (nextCol == 0 ? 1 : 0);
                    if (fillMatrix(matrix, n, nextCol, nextRow)) {
                        return true;
                    }
                }
            }
            matrix[col][row] = 0;
            return false;
        }
    }

    static boolean isValid(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (rowSet.contains(matrix[i][j])) {
                    return false;
                } else if (matrix[i][j] != 0) {
                    rowSet.add(matrix[i][j]);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (colSet.contains(matrix[j][i])) {
                    return false;
                } else if (matrix[j][i] != 0) {
                    colSet.add(matrix[j][i]);
                }
            }
        }
        return true;
    }

    static String formatRow(Integer[] row) {
        StringBuilder sb = new StringBuilder();
        for (int value : row) {
            sb.append(value).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}