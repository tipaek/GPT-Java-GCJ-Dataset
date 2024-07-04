import java.util.*;

/**
 * Made and solved successfully by the Prodigy Programmer
 * Author: Julian Paniagua
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                int[] columnArray = new int[matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    columnArray[row] = matrix[row][col];
                }
                if (hasDuplicates(columnArray)) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + i + ": " + calculateTrace(matrix) + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int value : array) {
            if (!uniqueElements.add(value)) {
                return true;
            }
        }
        return false;
    }
}