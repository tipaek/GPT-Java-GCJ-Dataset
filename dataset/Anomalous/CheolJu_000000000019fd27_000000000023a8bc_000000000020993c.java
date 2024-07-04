import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine();

            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
                scanner.nextLine();
            }

            int duplicateRows = countDuplicateRows(matrix, matrixSize);
            int duplicateCols = countDuplicateCols(matrix, matrixSize);

            System.out.println("Case #" + (testIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            if (hasDuplicates(matrix[row])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int col = 0; col < size; col++) {
            int[] columnArray = new int[size];
            for (int row = 0; row < size; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (hasDuplicates(columnArray)) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}