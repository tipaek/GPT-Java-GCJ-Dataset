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
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            processTestCase(i);
        }
    }

    private void processTestCase(int caseNumber) {
        int[][] matrix = readMatrix();
        int trace = calculateTrace(matrix);
        int repeatedColumns = countRepeatedColumns(matrix);
        int repeatedRows = countRepeatedRows(matrix);

        System.out.println("Case #" + (caseNumber + 1) + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
    }

    private int[][] readMatrix() {
        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> columnValues = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (!columnValues.add(matrix[j][i])) {
                    repeatedColumns++;
                    break;
                }
            }
        }
        return repeatedColumns;
    }

    private int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowValues = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (!rowValues.add(matrix[i][j])) {
                    repeatedRows++;
                    break;
                }
            }
        }
        return repeatedRows;
    }
}