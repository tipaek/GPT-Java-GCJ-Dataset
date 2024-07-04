import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numRows = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[numRows][numRows];

            for (int i = 0; i < numRows; i++) {
                matrix[i] = parseRow(scanner.nextLine());
            }

            int diagonalSum = calculateDiagonalSum(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static int[] parseRow(String row) {
        String[] split = row.split(" ");
        int[] parsedRow = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            parsedRow[i] = Integer.parseInt(split[i]);
        }
        return parsedRow;
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}