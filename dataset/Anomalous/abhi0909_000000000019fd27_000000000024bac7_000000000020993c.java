import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (rowSet.contains(matrix[i][j])) {
                    hasDuplicate = true;
                } else {
                    rowSet.add(matrix[i][j]);
                }
            }

            if (hasDuplicate) {
                duplicateRowCount++;
            }
        }

        return duplicateRowCount;
    }

    public int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (colSet.contains(matrix[j][i])) {
                    hasDuplicate = true;
                } else {
                    colSet.add(matrix[j][i]);
                }
            }

            if (hasDuplicate) {
                duplicateColCount++;
            }
        }

        return duplicateColCount;
    }

    public int calculateDiagonalSum(int[][] matrix, int size) {
        int diagonalSum = 0;

        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }

        return diagonalSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            Solution solution = new Solution();
            int duplicateRowCount = solution.countDuplicateRows(matrix, size);
            int duplicateColCount = solution.countDuplicateColumns(matrix, size);
            int diagonalSum = solution.calculateDiagonalSum(matrix, size);

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, duplicateRowCount, duplicateColCount);
            caseNumber++;
        }

        scanner.close();
    }
}