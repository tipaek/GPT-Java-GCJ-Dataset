package test;

import java.util.Scanner;
import java.util.TreeSet;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposedMatrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = sc.nextInt();
                    transposedMatrix[j][i] = matrix[i][j];
                }
            }

            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            TreeSet<Integer> rowSet = new TreeSet<>();
            TreeSet<Integer> colSet = new TreeSet<>();

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                    colSet.add(transposedMatrix[i][j]);
                }
                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }
                if (colSet.size() != matrixSize) {
                    duplicateCols++;
                }
                rowSet.clear();
                colSet.clear();
            }

            output.append("Case #").append(t + 1).append(": ")
                  .append(trace).append(" ")
                  .append(duplicateRows).append(" ")
                  .append(duplicateCols).append("\n");
        }
        System.out.print(output.toString());
    }
}