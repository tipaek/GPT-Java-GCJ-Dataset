import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = generateMatrix(n, k);
            
            if (matrix == null) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": POSSIBLE");
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
        int[][] matrix = new int[n][n];
        Random random = new Random();
        
        while (attempts < 1000000) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 1 + random.nextInt(n);
                }
            }
            
            if (hasUniqueRows(matrix) && hasUniqueColumns(matrix) && calculateTrace(matrix) == k) {
                return matrix;
            }
            attempts++;
        }
        return null;
    }

    public static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static boolean hasUniqueRows(int[][] matrix) {
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasUniqueColumns(int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
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