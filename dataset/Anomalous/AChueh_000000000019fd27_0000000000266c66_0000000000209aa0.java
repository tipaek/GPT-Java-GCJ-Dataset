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
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            Integer[][] matrix = new Integer[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(matrix[i], 0);
            }
            
            boolean isPossible = solve(matrix, n, k);
            System.out.println("Case #" + caseNum + ": " + (isPossible ? "POSSIBLE" : "IMPOSSIBLE"));
            
            if (isPossible) {
                for (int i = 0; i < n; i++) {
                    System.out.println(formatRow(matrix[i]));
                }
            }
        }
    }

    static boolean solve(Integer[][] matrix, int n, int k) {
        for (int i = 1; i <= n; i++) {
            matrix[0][0] = i;
            if (fillDiagonal(matrix, n, k - i, 1)) {
                return true;
            }
        }
        return false;
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

    static boolean fillMatrix(Integer[][] matrix, int n, int row, int col) {
        if (matrix[row][col] != 0) {
            if (row == n - 1 && col == n - 1) {
                return true;
            }
            row = (row + 1) % n;
            if (row == 0) {
                col++;
            }
            return fillMatrix(matrix, n, row, col);
        } else {
            for (int i = 1; i <= n; i++) {
                matrix[row][col] = i;
                if (isMatrixValid(matrix)) {
                    int newRow = (row + 1) % n;
                    int newCol = col;
                    if (newRow == 0) {
                        newCol++;
                    }
                    if (fillMatrix(matrix, n, newRow, newCol)) {
                        return true;
                    }
                }
            }
            matrix[row][col] = 0; // Reset the cell if no valid number is found
            return false;
        }
    }

    static boolean isMatrixValid(Integer[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0 && !rowSet.add(matrix[i][j])) {
                    return false;
                }
                if (matrix[j][i] != 0 && !colSet.add(matrix[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    static String formatRow(Integer[] row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row.length; i++) {
            sb.append(row[i]);
            if (i < row.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}