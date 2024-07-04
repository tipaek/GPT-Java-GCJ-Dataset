package com.adobe.daemonapp.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCaseCount = Integer.parseInt(scanner.nextLine());

    for (int i = 1; i <= testCaseCount; i++) {
      int matrixSize = Integer.parseInt(scanner.nextLine());
      int[][] matrix = new int[matrixSize][matrixSize];

      for (int row = 0; row < matrixSize; row++) {
        String[] rowData = scanner.nextLine().split(" ");
        for (int col = 0; col < matrixSize; col++) {
          matrix[row][col] = Integer.parseInt(rowData[col]);
        }
      }

      processMatrix(matrix, i);
    }
  }

  private static void processMatrix(int[][] matrix, int testCaseNumber) {
    int diagonalSum = 0;
    int repeatedRows = 0;
    int repeatedCols = 0;

    if (matrix == null || matrix.length == 0) {
      printResult(testCaseNumber, diagonalSum, repeatedRows, repeatedCols);
      return;
    }

    // Calculate diagonal sum
    for (int i = 0; i < matrix.length; i++) {
      diagonalSum += matrix[i][i];
    }

    // Check for repeated elements in rows
    for (int[] row : matrix) {
      if (hasDuplicates(row)) {
        repeatedRows++;
      }
    }

    // Check for repeated elements in columns
    for (int col = 0; col < matrix[0].length; col++) {
      int[] columnData = new int[matrix.length];
      for (int row = 0; row < matrix.length; row++) {
        columnData[row] = matrix[row][col];
      }
      if (hasDuplicates(columnData)) {
        repeatedCols++;
      }
    }

    printResult(testCaseNumber, diagonalSum, repeatedRows, repeatedCols);
  }

  private static boolean hasDuplicates(int[] array) {
    Set<Integer> uniqueElements = new HashSet<>();
    for (int element : array) {
      if (!uniqueElements.add(element)) {
        return true;
      }
    }
    return false;
  }

  private static void printResult(int testCaseNumber, int diagonalSum, int repeatedRows, int repeatedCols) {
    System.out.println("Case #" + testCaseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
  }
}