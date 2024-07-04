import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[][] matrix = readMatrix();
            analyzeMatrix(testCase, matrix);
        }
    }

    private static int[][] readMatrix() {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void analyzeMatrix(int testCaseNumber, int[][] matrix) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> columnSet = new HashSet<>();
            boolean rowHasDuplicates = false;
            boolean columnHasDuplicates = false;

            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!rowSet.add(matrix[i][j]) && !rowHasDuplicates) {
                    repeatedRows++;
                    rowHasDuplicates = true;
                }
                if (!columnSet.add(matrix[j][i]) && !columnHasDuplicates) {
                    repeatedColumns++;
                    columnHasDuplicates = true;
                }
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
    }
}