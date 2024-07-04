package qualification;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AVestigium {
    public static void main(String[] args) {
        new AVestigium().run();
    }

    private Scanner scanner;

    public void run() {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            processTestCase(i);
        }
    }

    private void processTestCase(int testCaseNumber) {
        int[][] matrix = readMatrix();
        int trace = calculateTrace(matrix);
        int duplicateColumns = countDuplicateColumns(matrix);
        int duplicateRows = countDuplicateRows(matrix);

        System.out.println("Case #" + (testCaseNumber + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private int[][] readMatrix() {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> columnValues = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!columnValues.add(matrix[row][col])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }

    private int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int row = 0; row < matrix.length; row++) {
            Set<Integer> rowValues = new HashSet<>();
            for (int col = 0; col < matrix.length; col++) {
                if (!rowValues.add(matrix[row][col])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }
}