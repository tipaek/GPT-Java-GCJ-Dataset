import java.util.Scanner;

public class Solution {

    private static void processTestCase(int testCaseNumber, Scanner scanner) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int rowDuplicates = 0, colDuplicates = 0, diagonalSum = 0;

        // Check rows for duplicates
        for (int row = 0; row < matrixSize; row++) {
            boolean[] seen = new boolean[matrixSize + 1];
            for (int col = 0; col < matrixSize; col++) {
                if (seen[matrix[row][col]]) {
                    rowDuplicates++;
                    break;
                } else {
                    seen[matrix[row][col]] = true;
                }
            }
        }

        // Check columns for duplicates
        for (int col = 0; col < matrixSize; col++) {
            boolean[] seen = new boolean[matrixSize + 1];
            for (int row = 0; row < matrixSize; row++) {
                if (seen[matrix[row][col]]) {
                    colDuplicates++;
                    break;
                } else {
                    seen[matrix[row][col]] = true;
                }
            }
        }

        // Calculate diagonal sum
        for (int i = 0; i < matrixSize; i++) {
            diagonalSum += matrix[i][i];
        }

        System.out.println("Case #" + testCaseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            processTestCase(testCase, scanner);
        }
        scanner.close();
    }
}