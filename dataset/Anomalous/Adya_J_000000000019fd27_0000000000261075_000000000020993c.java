import java.util.Scanner;

public class Prob1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int x = 1; x <= t; x++) {
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

            System.out.print("\nCase #" + x + " : " + trace);
            countDuplicateRows(matrix, n);
            countDuplicateCols(matrix, n);
        }
    }

    private static void countDuplicateRows(int[][] matrix, int n) {
        int duplicateRowCount = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    duplicateRowCount++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        System.out.print(" " + duplicateRowCount);
    }

    private static void countDuplicateCols(int[][] matrix, int n) {
        int duplicateColCount = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[j][i]]) {
                    duplicateColCount++;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }

        System.out.print(" " + duplicateColCount);
    }
}