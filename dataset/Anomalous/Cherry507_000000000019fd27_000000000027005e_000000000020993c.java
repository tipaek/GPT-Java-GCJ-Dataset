import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Vestigium().process();
    }
}

class Vestigium {
    private int numTests;
    private int[][][] testCases;

    public void process() {
        readInput();
        generateOutput();
    }

    private void readInput() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        numTests = scanner.nextInt();
        testCases = new int[numTests][][];
        
        for (int i = 0; i < numTests; i++) {
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
        for (int i = 0; i < numTests; i++) {
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            int[][] matrix = testCases[i];
            int size = matrix.length;

            for (int j = 0; j < size; j++) {
                trace += matrix[j][j];
                if (hasDuplicates(matrix[j])) {
                    duplicateRows++;
                }

                int[] column = new int[size];
                for (int k = 0; k < size; k++) {
                    column[k] = matrix[k][j];
                }
                if (hasDuplicates(column)) {
                    duplicateColumns++;
                }
            }
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, duplicateRows, duplicateColumns);
        }
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