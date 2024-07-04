import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            int[][] matrix = new int[matrixSize][matrixSize];
            boolean[][] seenInCol = new boolean[matrixSize + 1][matrixSize + 1];
            boolean[] colDuplicateFlags = new boolean[matrixSize + 1];
            boolean[][] seenInRow = new boolean[matrixSize + 1][matrixSize + 1];
            boolean[] rowDuplicateFlags = new boolean[matrixSize + 1];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    if (row == col) {
                        trace += value;
                    }

                    if (seenInCol[value][col] && !colDuplicateFlags[col]) {
                        colDuplicates++;
                        colDuplicateFlags[col] = true;
                    }
                    seenInCol[value][col] = true;

                    if (seenInRow[row][value] && !rowDuplicateFlags[row]) {
                        rowDuplicates++;
                        rowDuplicateFlags[row] = true;
                    }
                    seenInRow[row][value] = true;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}