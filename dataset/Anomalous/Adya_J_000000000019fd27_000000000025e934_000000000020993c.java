import java.util.Scanner;

public class Prob1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            int trace = 0;
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.print("\nCase #" + x + ": " + trace);
            countDuplicateRows(matrix, n);
            countDuplicateCols(matrix, n);
        }

        sc.close();
    }

    private static void countDuplicateRows(int[][] matrix, int n) {
        int duplicateRowCount = 0;

        for (int i = 0; i < n; i++) {
            boolean hasDuplicates = false;
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (matrix[i][j] == matrix[i][k]) {
                        hasDuplicates = true;
                        break;
                    }
                }
                if (hasDuplicates) {
                    duplicateRowCount++;
                    break;
                }
            }
        }

        System.out.print(" " + duplicateRowCount);
    }

    private static void countDuplicateCols(int[][] matrix, int n) {
        int duplicateColCount = 0;

        for (int i = 0; i < n; i++) {
            boolean hasDuplicates = false;
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (matrix[j][i] == matrix[k][i]) {
                        hasDuplicates = true;
                        break;
                    }
                }
                if (hasDuplicates) {
                    duplicateColCount++;
                    break;
                }
            }
        }

        System.out.print(" " + duplicateColCount);
    }
}