import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws NumberFormatException {
        HashSet<Integer> uniqueElements = new HashSet<>();
        int[][] matrix = new int[100][100];
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            int matrixSize = scanner.nextInt();

            // Reading the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculating the diagonal sum
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            // Checking for duplicate elements in rows
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != matrixSize) {
                    duplicateRows++;
                }
                uniqueElements.clear();
            }

            // Checking for duplicate elements in columns
            for (int col = 0; col < matrixSize; col++) {
                for (int row = 0; row < matrixSize; row++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != matrixSize) {
                    duplicateCols++;
                }
                uniqueElements.clear();
            }

            // Printing the result for the current case
            System.out.println("Case #" + caseIndex + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}