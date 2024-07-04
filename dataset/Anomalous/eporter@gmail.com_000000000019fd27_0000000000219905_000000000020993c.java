package a;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            Solution.processCases(scanner);
        }
    }

    private static void processCases(Scanner scanner) {
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            new Solution(scanner).processSingleCase(caseIndex);
        }
    }

    public Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    private void processSingleCase(int caseIndex) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int trace = 0, rowDuplicates = 0, columnDuplicates = 0;

        for (int row = 0; row < matrixSize; row++) {
            boolean[] rowCheck = new boolean[matrixSize + 1];
            boolean rowValid = true;
            for (int col = 0; col < matrixSize; col++) {
                int value = scanner.nextInt();
                matrix[row][col] = value;
                if (row == col) {
                    trace += value;
                }
                if (rowCheck[value]) {
                    rowValid = false;
                }
                rowCheck[value] = true;
            }
            if (!rowValid) {
                rowDuplicates++;
            }
        }

        for (int col = 0; col < matrixSize; col++) {
            boolean[] colCheck = new boolean[matrixSize + 1];
            boolean colValid = true;
            for (int row = 0; row < matrixSize; row++) {
                int value = matrix[row][col];
                if (colCheck[value]) {
                    colValid = false;
                }
                colCheck[value] = true;
            }
            if (!colValid) {
                columnDuplicates++;
            }
        }

        printFormattedResult(caseIndex, trace, rowDuplicates, columnDuplicates);
    }

    private static void printFormattedResult(int caseIndex, int trace, int rowDuplicates, int columnDuplicates) {
        System.out.printf("Case #%d: %d %d %d%n", caseIndex, trace, rowDuplicates, columnDuplicates);
    }
}