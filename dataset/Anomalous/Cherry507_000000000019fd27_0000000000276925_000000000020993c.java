import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Vestigium().process();
    }
}

class Vestigium {
    private int amountTests;
    private int[][][] testCases;

    public void process() {
        readInput();
        generateOutput();
    }

    private void readInput() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        amountTests = scanner.nextInt();
        testCases = new int[amountTests][][];
        
        for (int i = 0; i < amountTests; i++) {
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
        for (int i = 0; i < amountTests; i++) {
            int[][] matrix = testCases[i];
            int trace = calculateTrace(matrix);
            int rowsWithDuplicates = countRowsWithDuplicates(matrix);
            int columnsWithDuplicates = countColumnsWithDuplicates(matrix);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowsWithDuplicates + " " + columnsWithDuplicates);
        }
    }

    private int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countRowsWithDuplicates(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }
        return count;
    }

    private int countColumnsWithDuplicates(int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        return count;
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