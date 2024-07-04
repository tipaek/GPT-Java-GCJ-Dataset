import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Reading the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Calculate trace and row duplicates
            for (int row = 0; row < size; row++) {
                boolean[] seenRow = new boolean[size + 1];
                boolean rowHasDuplicates = false;

                for (int col = 0; col < size; col++) {
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    if (seenRow[matrix[row][col]]) {
                        rowHasDuplicates = true;
                    }
                    seenRow[matrix[row][col]] = true;
                }

                if (rowHasDuplicates) {
                    rowDuplicates++;
                }
            }

            // Calculate column duplicates
            for (int col = 0; col < size; col++) {
                boolean[] seenCol = new boolean[size + 1];
                boolean colHasDuplicates = false;

                for (int row = 0; row < size; row++) {
                    if (seenCol[matrix[row][col]]) {
                        colHasDuplicates = true;
                    }
                    seenCol[matrix[row][col]] = true;
                }

                if (colHasDuplicates) {
                    colDuplicates++;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", testCase, trace, rowDuplicates, colDuplicates);
        }
        scanner.close();
    }
}