import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            processTestCase(testCase, matrixSize, matrix);
        }
    }

    private static void processTestCase(int testCaseNumber, int size, int[][] matrix) {
        int diagonalSum = calculateDiagonalSum(size, matrix);
        int duplicateRows = countDuplicateRows(size, matrix);
        int duplicateColumns = countDuplicateColumns(size, matrix);

        System.out.println("Case #" + testCaseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int calculateDiagonalSum(int size, int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int size, int[][] matrix) {
        int duplicateCount = 0;

        for (int row = 0; row < size; row++) {
            boolean[] seen = new boolean[size];
            boolean hasDuplicates = false;

            for (int col = 0; col < size; col++) {
                int value = Math.abs(matrix[row][col]) - 1;
                if (seen[value]) {
                    hasDuplicates = true;
                }
                seen[value] = true;
                matrix[row][value] *= -1;
            }

            if (hasDuplicates) {
                duplicateCount++;
            }

            for (int col = 0; col < size; col++) {
                matrix[row][col] = Math.abs(matrix[row][col]);
            }
        }

        return duplicateCount;
    }

    private static int countDuplicateColumns(int size, int[][] matrix) {
        int duplicateCount = 0;

        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size];
            boolean hasDuplicates = false;

            for (int row = 0; row < size; row++) {
                int value = Math.abs(matrix[row][col]) - 1;
                if (seen[value]) {
                    hasDuplicates = true;
                }
                seen[value] = true;
                matrix[value][col] *= -1;
            }

            if (hasDuplicates) {
                duplicateCount++;
            }

            for (int row = 0; row < size; row++) {
                matrix[row][col] = Math.abs(matrix[row][col]);
            }
        }

        return duplicateCount;
    }
}