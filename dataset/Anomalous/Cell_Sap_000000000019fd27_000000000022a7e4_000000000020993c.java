import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int diagonalSum = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            // Checking for duplicate values in each row
            int[] frequency = new int[101];
            for (int row = 0; row < matrixSize; row++) {
                Arrays.fill(frequency, 0);
                for (int col = 0; col < matrixSize; col++) {
                    frequency[matrix[row][col]]++;
                    if (frequency[matrix[row][col]] > 1) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Checking for duplicate values in each column
            for (int col = 0; col < matrixSize; col++) {
                Arrays.fill(frequency, 0);
                for (int row = 0; row < matrixSize; row++) {
                    frequency[matrix[row][col]]++;
                    if (frequency[matrix[row][col]] > 1) {
                        columnDuplicates++;
                        break;
                    }
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }

        scanner.close();
    }
}