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
        createOutput();
    }

    private void readInput() {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
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
        }
    }

    private void createOutput() {
        for (int i = 0; i < amountTests; i++) {
            int trace = 0;
            int rows = 0;
            int columns = 0;
            int[][] matrix = testCases[i];
            int size = matrix.length;

            for (int j = 0; j < size; j++) {
                trace += matrix[j][j];

                boolean[] rowCheck = new boolean[size + 1];
                boolean[] colCheck = new boolean[size + 1];
                boolean rowRepeat = false;
                boolean colRepeat = false;

                for (int k = 0; k < size; k++) {
                    if (rowCheck[matrix[j][k]]) {
                        rowRepeat = true;
                    } else {
                        rowCheck[matrix[j][k]] = true;
                    }

                    if (colCheck[matrix[k][j]]) {
                        colRepeat = true;
                    } else {
                        colCheck[matrix[k][j]] = true;
                    }
                }

                if (rowRepeat) {
                    rows++;
                }
                if (colRepeat) {
                    columns++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rows + " " + columns);
        }
    }
}