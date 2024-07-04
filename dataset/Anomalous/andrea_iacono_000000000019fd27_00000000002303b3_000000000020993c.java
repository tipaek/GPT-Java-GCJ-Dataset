import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long testCases = scanner.nextLong();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            String result = analyzeMatrix(matrix, matrixSize);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String analyzeMatrix(int[][] matrix, int size) {
        int traceValue = calculateTrace(matrix);
        int duplicateRows = countDuplicateRows(matrix, size);
        int duplicateCols = countDuplicateColumns(matrix, size);

        return traceValue + " " + duplicateRows + " " + duplicateCols;
    }

    private static int calculateTrace(int[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }

        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    duplicateColCount++;
                    break;
                }
            }
        }

        return duplicateColCount;
    }
}