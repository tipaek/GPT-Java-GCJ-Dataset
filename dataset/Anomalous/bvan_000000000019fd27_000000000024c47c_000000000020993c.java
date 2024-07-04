import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = scanner.nextMatrix(matrixSize, matrixSize);
            int traceValue = calculateTrace(matrix);
            int duplicateRows = countRowsWithDuplicates(matrix);
            int duplicateCols = countColsWithDuplicates(matrix);
            System.out.printf("Case #%d: %d %d %d%n", t, traceValue, duplicateRows, duplicateCols);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowsWithDuplicates(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countColsWithDuplicates(int[][] matrix) {
        int duplicateCols = 0;
        for (int col = 0; col < matrix.length; col++) {
            if (hasDuplicates(getColumn(matrix, col))) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int element : array) {
            if (!uniqueElements.add(element)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][colIndex];
        }
        return column;
    }
}

class FastScanner {

    private final StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public int nextInt() {
        try {
            tokenizer.nextToken();
            return (int) tokenizer.nval;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public int[][] nextMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = nextInt();
            }
        }
        return matrix;
    }
}