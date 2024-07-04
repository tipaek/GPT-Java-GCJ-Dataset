import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = generateMatrix(n, k);
            
            if (matrix == null) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
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
        int attempts = 0;
        Random random = new Random();
        int[][] matrix = new int[n][n];
        
        while (attempts < 200000) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 1 + random.nextInt(n);
                }
            }
            
            if (noRepeatedRows(matrix) && noRepeatedColumns(matrix) && calculateTrace(matrix) == k) {
                return matrix;
            }
            attempts++;
        }
        return null;
    }

    public static int calculateTrace(int[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    public static boolean noRepeatedRows(int[][] matrix) {
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                return false;
            }
        }
        return true;
    }

    public static boolean noRepeatedColumns(int[][] matrix) {
        int n = matrix.length;
        for (int col = 0; col < n; col++) {
            int[] column = new int[n];
            for (int row = 0; row < n; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}