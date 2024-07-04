package com.codejam.vestigium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

  final static Scanner keyboard = new Scanner(System.in);


  public static void main(final String[] args) {
    final int numberOfTestCases = keyboard.nextInt();
    for (int i = 0; i < numberOfTestCases; i++) {
      final int size = keyboard.nextInt();
      final int[][] squareMatrix = readSquareMatrix(size);
      System.out.println(createResultOutput(i + 1, squareMatrix));
    }
  }

  private static String createResultOutput(final int testCase, final int[][] squareMatrix) {
    final int size = squareMatrix.length;
    int duplicatedRowsCount = 0;
    int duplicatedColumnsCount = 0;
    final List<Set<Integer>> columns = new ArrayList<>();

    int trace = 0;
    for (int i = 0; i < size; i++) {
      final Set<Integer> rows = new HashSet<>();
      for (int j = 0; j < size; j++) {
        rows.add(squareMatrix[i][j]);
        if (columns.size() - 1 < j) {
          columns.add(new HashSet<>());
        }
        columns.get(j).add(squareMatrix[i][j]);
        if (i == j) {
          trace += squareMatrix[i][j];
        }
      }
      if (size != rows.size()) {
        duplicatedRowsCount++;
      }
    }
    for (final Set<Integer> column : columns) {
      if (size != column.size()) {
        duplicatedColumnsCount++;
      }
    }
    return "Case #" + testCase + ": " + trace + " " + duplicatedRowsCount + " "
        + duplicatedColumnsCount;
  }

  private static int[][] readSquareMatrix(final int squareMatrixSize) {
    final int[][] squareMatrix = new int[squareMatrixSize][squareMatrixSize];
    for (int i = 0; i < squareMatrixSize; i++) {
      squareMatrix[i] = readSquareMatrixRow(squareMatrixSize);
    }
    return squareMatrix;
  }

  private static int[] readSquareMatrixRow(int squareMatrixSize) {
    final int[] squareMatrixRow = new int[squareMatrixSize];
    for (int i = 0; i < squareMatrixSize; i++) {
      squareMatrixRow[i] = keyboard.nextInt();
    }
    return squareMatrixRow;
  }
}
