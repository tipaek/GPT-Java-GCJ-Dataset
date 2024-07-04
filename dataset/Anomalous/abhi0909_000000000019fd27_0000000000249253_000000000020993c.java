import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

    public int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (uniqueElements.contains(matrix[i][j])) {
                    hasDuplicate = true;
                } else {
                    uniqueElements.add(matrix[i][j]);
                }
            }

            if (hasDuplicate) {
                duplicateRowCount++;
            }
        }

        return duplicateRowCount;
    }

    public int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumnCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (uniqueElements.contains(matrix[j][i])) {
                    hasDuplicate = true;
                } else {
                    uniqueElements.add(matrix[j][i]);
                }
            }

            if (hasDuplicate) {
                duplicateColumnCount++;
            }
        }

        return duplicateColumnCount;
    }

    public int calculateDiagonalSum(int[][] matrix, int size) {
        int diagonalSum = 0;

        for (int i = 0; i < size; i++) {
            diagonalSum += matrix[i][i];
        }

        return diagonalSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            int duplicateRows = solution.countDuplicateRows(matrix, size);
            int duplicateColumns = solution.countDuplicateColumns(matrix, size);
            int diagonalSum = solution.calculateDiagonalSum(matrix, size);

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, duplicateRows, duplicateColumns);
            caseNumber++;
        }

        scanner.close();
    }
}