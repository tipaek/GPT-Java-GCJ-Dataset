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
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            int[] result = calculateVestigium(size, matrix);
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, result[0], result[1], result[2]);
        }
    }

    private int[] calculateVestigium(int size, int[][] matrix) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (rowCheck[matrix[i][j]]) {
                    rowHasDuplicate = true;
                } else {
                    rowCheck[matrix[i][j]] = true;
                }
                if (colCheck[matrix[j][i]]) {
                    colHasDuplicate = true;
                } else {
                    colCheck[matrix[j][i]] = true;
                }
            }
            if (rowHasDuplicate) rowRepeats++;
            if (colHasDuplicate) colRepeats++;
        }
        return new int[]{trace, rowRepeats, colRepeats};
    }
}