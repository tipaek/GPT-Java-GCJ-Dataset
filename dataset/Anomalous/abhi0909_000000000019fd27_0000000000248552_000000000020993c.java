import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    hasDuplicate = true;
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
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    hasDuplicate = true;
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
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            Solution solution = new Solution();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int duplicateRowCount = solution.countDuplicateRows(matrix, size);
            int duplicateColCount = solution.countDuplicateColumns(matrix, size);
            int diagonalSum = solution.calculateDiagonalSum(matrix, size);

            System.out.printf("Case #%d: %d %d %d%n", testCases + 1, diagonalSum, duplicateRowCount, duplicateColCount);
        }

        scanner.close();
    }
}