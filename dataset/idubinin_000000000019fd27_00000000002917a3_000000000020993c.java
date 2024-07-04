package com.github.sabaka.gcjam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Vestigium {

  public static void main(String[] args) throws IOException {
    var input = new BufferedReader(new InputStreamReader(System.in));
    var numberOfCases = Integer.parseInt(input.readLine());
    for (int i = 0; i < numberOfCases; i++) {
      var matrixSize = Integer.parseInt(input.readLine());
      var matrix = new int[matrixSize][matrixSize];
      for (int j = 0; j < matrixSize; j++) {
        matrix[j] = Arrays.stream(input.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
      }
      var result = processMatrix(matrix);
      System.out.printf("Case #%d: %d %d %d", i + 1, result[0], result[1], result[2]);
    }
  }

  private static int[] processMatrix(int[][] matrix) {
    int trace = 0;
    int dLines = 0;
    int dCols = 0;
    for (int i = 0, j = 0; i < matrix.length; i++, j++) {
      trace += matrix[i][j];
      if (hasDups(matrix[i])) {
        dLines++;
      }
      if (hasDups(extractColumn(matrix, j))) {
        dCols++;
      }
    }
    return new int[] {trace, dLines, dCols};
  }

  private static int[] extractColumn(int[][] matrix, int index) {
    var column = new int[matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      column[i] = matrix[i][index];
    }
    return column;
  }

  private static boolean hasDups(int[] line) {
    return Arrays.stream(line).distinct().count() != line.length;
  }

}
