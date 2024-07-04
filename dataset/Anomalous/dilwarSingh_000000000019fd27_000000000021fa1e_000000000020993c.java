import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int[] results = analyzeMatrix(matrix, matrixSize);
            System.out.println("Case #" + caseNumber + ": " + results[0] + " " + results[1] + " " + results[2]);
        }
    }

    static int[] analyzeMatrix(int[][] matrix, int size) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < size; i++) {
            if (containsDuplicate(matrix[i])) {
                duplicateRows++;
            }
        }

        for (int col = 0; col < size; col++) {
            Set<Integer> columnValues = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!columnValues.add(matrix[row][col])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        return new int[]{trace, duplicateRows, duplicateCols};
    }

    static boolean containsDuplicate(int[] array) {
        Set<Integer> values = new HashSet<>();
        for (int value : array) {
            if (!values.add(value)) {
                return true;
            }
        }
        return false;
    }
}