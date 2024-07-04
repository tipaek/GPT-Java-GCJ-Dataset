import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        LatinTrace latinTraceSolver = new LatinTrace();

        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            latinTraceSolver.solve(matrix);
        }
    }
}

class LatinTrace {
    private static int testCaseNumber = 1;

    public void solve(int[][] matrix) {
        int trace = calculateTrace(matrix);
        int repeatedRows = countRepeatedRows(matrix);
        int repeatedColumns = countRepeatedColumns(matrix);
        System.out.println("Case #" + testCaseNumber++ + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
    }

    private int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private int countRepeatedColumns(int[][] matrix) {
        int repeatedColumns = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }

    private boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}