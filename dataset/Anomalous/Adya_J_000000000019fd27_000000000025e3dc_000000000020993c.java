import java.util.Scanner;

public class MatrixTraceAndDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.print("\nCase #" + caseNumber + " : " + trace);
            countDuplicateRows(matrix, n);
            countDuplicateColumns(matrix, n);
        }
    }

    private static void countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;

        for (int i = 0; i < size; i++) {
            if (hasDuplicate(matrix[i])) {
                duplicateRowCount++;
            }
        }

        System.out.print(" " + duplicateRowCount);
    }

    private static void countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumnCount = 0;

        for (int i = 0; i < size; i++) {
            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicate(column)) {
                duplicateColumnCount++;
            }
        }

        System.out.print(" " + duplicateColumnCount);
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> seenNumbers = new HashSet<>();
        for (int number : array) {
            if (!seenNumbers.add(number)) {
                return true;
            }
        }
        return false;
    }
}