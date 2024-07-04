import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = sc.nextInt();
            for (int x = 1; x <= t; x++) {
                int n = sc.nextInt();
                int[][] matrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = sc.nextInt();
                    }
                }
                int trace = calculateTrace(matrix);
                int repeatedRows = countRepeatedRows(matrix);
                int repeatedColumns = countRepeatedColumns(matrix);
                System.out.printf("Case #%d: %d %d %d%n", x, trace, repeatedRows, repeatedColumns);
            }
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int value : row) {
                if (!uniqueElements.add(value)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int countRepeatedColumns(int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}