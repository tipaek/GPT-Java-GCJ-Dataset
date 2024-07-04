import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int testCases = scanner.nextInt();

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];

                int repeatRowCount = 0;
                int repeatColCount = 0;
                int diagonalSum = 0;

                int[][] columnValues = new int[matrixSize][matrixSize];
                boolean[] columnRepeats = new boolean[matrixSize];

                for (int row = 0; row < matrixSize; row++) {
                    int[] rowValues = new int[matrixSize];
                    boolean rowRepeat = false;

                    for (int col = 0; col < matrixSize; col++) {
                        int value = scanner.nextInt();
                        matrix[row][col] = value;

                        // Check for row repeats
                        rowValues[value - 1]++;
                        if (rowValues[value - 1] > 1) {
                            rowRepeat = true;
                        }

                        // Check for column repeats
                        columnValues[col][value - 1]++;
                        if (columnValues[col][value - 1] > 1 && !columnRepeats[col]) {
                            columnRepeats[col] = true;
                            repeatColCount++;
                        }

                        // Sum the main diagonal
                        if (row == col) {
                            diagonalSum += value;
                        }
                    }

                    if (rowRepeat) {
                        repeatRowCount++;
                    }
                }

                System.out.println("Case #" + testCase + ": " + diagonalSum + " " + repeatRowCount + " " + repeatColCount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}