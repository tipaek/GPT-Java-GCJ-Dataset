import java.util.Scanner;

public class MatrixTraceAndDuplicates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.print("\nCase #" + x + " : " + trace);
            countDuplicateRows(matrix, n);
            countDuplicateCols(matrix, n);
        }
        sc.close();
    }

    private static void countDuplicateRows(int[][] matrix, int n) {
        int duplicateRowCount = 0;

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRowCount++;
            }
        }

        System.out.print(" " + duplicateRowCount);
    }

    private static void countDuplicateCols(int[][] matrix, int n) {
        int duplicateColCount = 0;

        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = matrix[i][j];
            }
            if (hasDuplicates(col)) {
                duplicateColCount++;
            }
        }

        System.out.print(" " + duplicateColCount);
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (seen.contains(value)) {
                return true;
            }
            seen.add(value);
        }
        return false;
    }
}