package joohoyo.y2020.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        new Vestigium().start();
    }

    private void start() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            int[] results = calculateVestigium(matrixSize, matrix);
            System.out.printf("Case #%d: %d %d %d%n", caseNum, results[0], results[1], results[2]);
        }
    }

    private int[] calculateVestigium(int size, int[][] matrix) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (rowCheck[matrix[i][j]]) {
                    rowDuplicates++;
                    break;
                }
                rowCheck[matrix[i][j]] = true;

                if (colCheck[matrix[j][i]]) {
                    colDuplicates++;
                    break;
                }
                colCheck[matrix[j][i]] = true;
            }
        }
        return new int[]{trace, rowDuplicates, colDuplicates};
    }
}