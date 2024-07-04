import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();

            for (int t = 1; t <= testCases; t++) {
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];
                int[] rowCounts = new int[matrixSize];
                int[] colCounts = new int[matrixSize];
                boolean[] rowHasDuplicates = new boolean[matrixSize];
                boolean[] colHasDuplicates = new boolean[matrixSize];

                int diagonalSum = 0;
                int rowDuplicates = 0;
                int colDuplicates = 0;

                for (int row = 0; row < matrixSize; row++) {
                    for (int col = 0; col < matrixSize; col++) {
                        int value = scanner.nextInt();
                        matrix[row][col] = value;

                        // Check for duplicates in the row
                        if (++rowCounts[value - 1] > 1 && !rowHasDuplicates[row]) {
                            rowHasDuplicates[row] = true;
                            rowDuplicates++;
                        }

                        // Check for duplicates in the column
                        if (++colCounts[value - 1] > 1 && !colHasDuplicates[col]) {
                            colHasDuplicates[col] = true;
                            colDuplicates++;
                        }

                        // Sum the main diagonal
                        if (row == col) {
                            diagonalSum += value;
                        }
                    }

                    // Reset row counts for the next row
                    rowCounts = new int[matrixSize];
                }

                // Reset column counts for the next test case
                colCounts = new int[matrixSize];

                System.out.printf("Case #%d: %d %d %d%n", t, diagonalSum, rowDuplicates, colDuplicates);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}