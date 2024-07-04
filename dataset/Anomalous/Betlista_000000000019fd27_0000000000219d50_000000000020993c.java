import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final int MB = 1 << 20;
    private static final int SIZE = 20 * MB;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int readInt() throws IOException {
        return Integer.parseInt(br.readLine().trim());
    }

    private static int[] readIntArray(int n) throws IOException {
        int[] arr = new int[n];
        Scanner scanner = new Scanner(br.readLine());
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder resultBuilder = new StringBuilder();
        int testCases = readInt();
        for (int i = 0; i < testCases; ++i) {
            int matrixSize = readInt();
            int[][] matrix = new int[matrixSize][];
            for (int j = 0; j < matrixSize; ++j) {
                matrix[j] = readIntArray(matrixSize);
            }
            Result result = solve(i + 1, matrixSize, matrix);
            resultBuilder.append(result);
        }
        System.out.print(resultBuilder);
    }

    private static Result solve(int caseNumber, int matrixSize, int[][] matrix) {
        Result result = new Result();
        result.caseNumber = caseNumber;
        result.diagonalSum = calculateDiagonalSum(matrixSize, matrix);
        result.duplicateRows = countDuplicateRows(matrixSize, matrix);
        result.duplicateCols = countDuplicateCols(matrixSize, matrix);
        return result;
    }

    private static int calculateDiagonalSum(int matrixSize, int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrixSize; ++i) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int matrixSize, int[][] matrix) {
        int duplicateCount = 0;
        for (int row = 0; row < matrixSize; row++) {
            if (hasDuplicates(matrixSize, matrix, row, 0, 0, 1)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countDuplicateCols(int matrixSize, int[][] matrix) {
        int duplicateCount = 0;
        for (int col = 0; col < matrixSize; col++) {
            if (hasDuplicates(matrixSize, matrix, 0, col, 1, 0)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static boolean hasDuplicates(int matrixSize, int[][] matrix, int row, int col, int rowDelta, int colDelta) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int i = 0; i < matrixSize; i++) {
            uniqueElements.add(matrix[row][col]);
            row += rowDelta;
            col += colDelta;
        }
        return uniqueElements.size() < matrixSize;
    }

    private static class Result {
        int caseNumber, diagonalSum, duplicateRows, duplicateCols;

        @Override
        public String toString() {
            return String.format("Case #%d: %d %d %d%n", caseNumber, diagonalSum, duplicateRows, duplicateCols);
        }
    }
}