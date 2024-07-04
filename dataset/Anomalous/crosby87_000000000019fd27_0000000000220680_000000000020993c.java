import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, matrixSize);
            int duplicateRows = countDuplicateRows(matrix, matrixSize);
            int duplicateCols = countDuplicateCols(matrix, matrixSize);

            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, duplicateRows, duplicateCols);
        }

        scanner.close();
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int col = 0; col < size; col++) {
                rowSet.add(matrix[row][col]);
            }
            if (rowSet.size() != size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int col = 0; col < size; col++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int row = 0; row < size; row++) {
                colSet.add(matrix[row][col]);
            }
            if (colSet.size() != size) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }
}