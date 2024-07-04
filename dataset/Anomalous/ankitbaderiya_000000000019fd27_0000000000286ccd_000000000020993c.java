import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int testCases = scanner.nextInt();
            if (testCases >= 1 && testCases <= 100) {
                for (int t = 0; t < testCases; t++) {
                    int n = scanner.nextInt();
                    if (n >= 2 && n <= 100) {
                        int[][] matrix = new int[n][n];
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                matrix[i][j] = scanner.nextInt();
                            }
                        }
                        processMatrix(matrix, t + 1);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            scanner.close();
        }
    }

    private static void processMatrix(int[][] matrix, int caseNumber) {
        int trace = calculateTrace(matrix);
        int duplicateRows = countDuplicateRows(matrix);
        int duplicateColumns = countDuplicateColumns(matrix);

        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
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
            int[] columnArray = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (hasDuplicates(columnArray)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}