import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Vestigium().process();
    }
}

class Vestigium {
    private int numberOfTests;
    private int[][][] testCases;

    public void process() {
        readInput();
        generateOutput();
    }

    private void readInput() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        numberOfTests = scanner.nextInt();
        testCases = new int[numberOfTests][][];

        for (int i = 0; i < numberOfTests; i++) {
            int size = scanner.nextInt();
            testCases[i] = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    testCases[i][j][k] = scanner.nextInt();
                }
            }
        }
        scanner.close();
    }

    private void generateOutput() {
        for (int i = 0; i < numberOfTests; i++) {
            int trace = calculateTrace(testCases[i]);
            int rowDuplicates = countRowDuplicates(testCases[i]);
            int columnDuplicates = countColumnDuplicates(testCases[i]);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }

    private int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countRowDuplicates(int[][] matrix) {
        int rowDuplicates = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                rowDuplicates++;
            }
        }
        return rowDuplicates;
    }

    private int countColumnDuplicates(int[][] matrix) {
        int columnDuplicates = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                columnDuplicates++;
            }
        }
        return columnDuplicates;
    }

    private boolean hasDuplicates(int[] array) {
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