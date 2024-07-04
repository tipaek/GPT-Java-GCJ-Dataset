import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int testCases = scanner.nextInt();
            if (testCases >= 1 && testCases <= 100) {
                for (int t = 1; t <= testCases; t++) {
                    int n = scanner.nextInt();
                    if (n >= 2 && n <= 100) {
                        int[][] matrix = new int[n][n];
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                matrix[i][j] = scanner.nextInt();
                            }
                        }
                        analyzeMatrix(matrix, t);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            scanner.close();
        }
    }

    private static void analyzeMatrix(int[][] matrix, int caseNumber) {
        int trace = calculateTrace(matrix);
        int duplicateRows = countDuplicateRows(matrix);
        int duplicateCols = countDuplicateCols(matrix);

        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
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

    private static int countDuplicateCols(int[][] matrix) {
        int duplicateCols = 0;
        for (int j = 0; j < matrix.length; j++) {
            int[] col = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                col[i] = matrix[i][j];
            }
            if (hasDuplicates(col)) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}