import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Calculate trace and check for duplicate values in rows and columns
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];

                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }

                int[] column = new int[matrixSize];
                for (int j = 0; j < matrixSize; j++) {
                    column[j] = matrix[j][i];
                }

                if (hasDuplicates(column)) {
                    duplicateCols++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, duplicateRows, duplicateCols);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}