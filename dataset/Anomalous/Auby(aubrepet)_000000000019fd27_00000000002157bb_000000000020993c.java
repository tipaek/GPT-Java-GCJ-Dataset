import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner in;

    private void run() {
        in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            solveTestcase(i);
        }
    }

    private void solveTestcase(int testCaseNumber) {
        int[][] matrix = readMatrix();
        int trace = calculateTrace(matrix);
        int repeatedColumns = countRepeatedColumns(matrix);
        int repeatedRows = countRepeatedRows(matrix);

        System.out.println("Case #" + (testCaseNumber + 1) + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
    }

    private int[][] readMatrix() {
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }

    private int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countRepeatedColumns(int[][] matrix) {
        int repeatedColumns = 0;
        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedColumns++;
                    break;
                }
            }
        }
        return repeatedColumns;
    }

    private int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;
        for (int row = 0; row < matrix.length; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < matrix.length; col++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedRows++;
                    break;
                }
            }
        }
        return repeatedRows;
    }
}