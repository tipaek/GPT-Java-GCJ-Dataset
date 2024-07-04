import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int testCases = scanner.nextInt();
            if (testCases >= 1 && testCases <= 100) {
                for (int testCase = 1; testCase <= testCases; testCase++) {
                    int matrixSize = scanner.nextInt();
                    if (matrixSize >= 2 && matrixSize <= 100) {
                        int[][] matrix = new int[matrixSize][matrixSize];
                        for (int i = 0; i < matrixSize; i++) {
                            for (int j = 0; j < matrixSize; j++) {
                                matrix[i][j] = scanner.nextInt();
                            }
                        }
                        processMatrix(matrix, testCase);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void processMatrix(int[][] matrix, int caseNumber) {
        int trace = calculateTrace(matrix);
        int duplicateRows = countDuplicateRows(matrix);
        int duplicateCols = countDuplicateCols(matrix);

        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix) {
        int duplicateCols = 0;
        for (int col = 0; col < matrix.length; col++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateCols++;
                    break;
                }
            }
        }
        return duplicateCols;
    }
}