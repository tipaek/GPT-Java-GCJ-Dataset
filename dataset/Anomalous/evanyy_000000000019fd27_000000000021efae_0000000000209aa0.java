import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = generateMatrix(n, k);
            
            if (matrix == null) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static int[][] generateMatrix(int n, int k) {
        int maxAttempts = 100000;
        int[][] matrix = new int[n][n];
        Random random = new Random();
        
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 1 + random.nextInt(n);
                }
            }
            
            if (isValidMatrix(matrix, k)) {
                return matrix;
            }
        }
        return null;
    }

    public static boolean isValidMatrix(int[][] matrix, int targetTrace) {
        return calculateTrace(matrix) == targetTrace && countRepeatedRows(matrix) == 0 && countRepeatedColumns(matrix) == 0;
    }

    public static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    public static int countRepeatedColumns(int[][] matrix) {
        int repeatedColumns = 0;
        int n = matrix.length;
        for (int col = 0; col < n; col++) {
            int[] column = new int[n];
            for (int row = 0; row < n; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }

    public static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}