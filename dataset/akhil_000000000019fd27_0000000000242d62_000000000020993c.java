package datadef.prac;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LatinMatrix {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int numCases = scanner.nextInt();

    for (int index = 1; index <= numCases; index++) {
      int size = scanner.nextInt();
      int[][] input = new int[size][size];
      for (int rowId = 0; rowId < size; rowId++) {
        for (int colId = 0; colId < size; colId++) {
          input[rowId][colId] = new Integer(scanner.nextInt());
        }
      }
      int[] result = computeTrace(input);
      System.out.println("Case #" + index + ": " + result[0] + " " + result[1] + " " + result[2]);
    }
  }

  public static int[] computeTrace(int[][] input) {
    int sum = 0;
    int repeatedElementsRow = 0;
    int repeatedElementsCol = 0;
    for (int i = 0; i < input.length; i++) {
      Set<Integer> rowSet = new HashSet<>();
      boolean rowRepeats = false;
      for (int j = 0; j < input[i].length; j++) {
        if (i == j) {
          sum += input[i][j];
        }
        if (rowSet.contains(input[i][j])) {
          rowRepeats = true;
        } else {
          rowSet.add(input[i][j]);
        }
      }
      if (rowRepeats) {
        repeatedElementsRow++;
      }
    }
    for (int j = 0; j < input.length; j++) {
      Set<Integer> colSet = new HashSet<>();
      boolean colRepeats = false;
      for (int i = 0; i < input.length; i++) {
        if (colSet.contains(input[i][j])) {
          colRepeats = true;
          break;
        } else {
          colSet.add(input[i][j]);
        }
      }
      if (colRepeats) {
        repeatedElementsCol++;
      }
    }
    return new int[]{sum, repeatedElementsRow, repeatedElementsCol};
  }
}
