import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
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

            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateCols(matrix, n);

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        scanner.close();
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int n) {
        int duplicateCols = 0;
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (value > 0 && value <= array.length) {
                if (seen[value]) {
                    return true;
                }
                seen[value] = true;
            }
        }
        return false;
    }
}