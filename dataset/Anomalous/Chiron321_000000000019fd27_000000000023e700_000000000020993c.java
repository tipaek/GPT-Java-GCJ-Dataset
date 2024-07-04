import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;
        int numberOfTests = scanner.nextInt();

        while (numberOfTests-- > 0) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < matrixSize; i++) {
                boolean rowHasDuplicates = false;
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    if (!rowHasDuplicates && contains(matrix[i], value, j)) {
                        duplicateRows++;
                        rowHasDuplicates = true;
                    }
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                }
            }

            for (int j = 0; j < matrixSize; j++) {
                int[] columnArray = new int[matrixSize];
                for (int i = 0; i < matrixSize; i++) {
                    columnArray[i] = matrix[i][j];
                }
                if (hasDuplicates(columnArray)) {
                    duplicateColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber++, trace, duplicateRows, duplicateColumns);
        }
    }

    private static boolean contains(int[] array, int value, int endIndex) {
        for (int i = 0; i < endIndex; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}