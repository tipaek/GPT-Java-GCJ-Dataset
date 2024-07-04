package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMatrices = scanner.nextInt();

        ArrayList<int[][]> matrices = new ArrayList<>();
        for (int i = 0; i < numberOfMatrices; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            matrices.add(matrix);
        }

        for (int i = 0; i < numberOfMatrices; i++) {
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int size = matrices.get(i).length;

            // Calculate trace
            for (int j = 0; j < size; j++) {
                trace += matrices.get(i)[j][j];
            }

            // Check for row and column repeats
            for (int j = 0; j < size; j++) {
                boolean[] rowCheck = new boolean[size];
                boolean[] colCheck = new boolean[size];

                for (int k = 0; k < size; k++) {
                    rowCheck[matrices.get(i)[j][k] - 1] = true;
                    colCheck[matrices.get(i)[k][j] - 1] = true;
                }

                for (int k = 0; k < size; k++) {
                    if (!rowCheck[k]) {
                        rowRepeats++;
                        break;
                    }
                }

                for (int k = 0; k < size; k++) {
                    if (!colCheck[k]) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}