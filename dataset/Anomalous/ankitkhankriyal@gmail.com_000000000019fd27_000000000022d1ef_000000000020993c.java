import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading the matrix values
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int duplicateRows = 0, duplicateCols = 0;

            // Checking for duplicates in each row
            for (int row = 0; row < matrixSize; row++) {
                int[] frequency = new int[101];
                for (int col = 0; col < matrixSize; col++) {
                    frequency[matrix[row][col]]++;
                }
                for (int value = 1; value <= 100; value++) {
                    if (frequency[value] > 1) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Checking for duplicates in each column
            for (int col = 0; col < matrixSize; col++) {
                int[] frequency = new int[101];
                for (int row = 0; row < matrixSize; row++) {
                    frequency[matrix[row][col]]++;
                }
                for (int value = 1; value <= 100; value++) {
                    if (frequency[value] > 1) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            // Calculating the sum of the diagonal
            int diagonalSum = 0;
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            // Printing the result
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
            caseNumber++;
        }
    }
}