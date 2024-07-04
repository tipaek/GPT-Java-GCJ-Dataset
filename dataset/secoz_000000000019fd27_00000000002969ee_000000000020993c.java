import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    List<int[][]> matrixList = new ArrayList<>();
    int numberOfCases = in.nextInt();

    for (int i = 0; i < numberOfCases; i++) {
      int matrixSize = in.nextInt();
      int[][] matrix = new int[matrixSize][matrixSize];
      for (int s = 0; s < matrixSize; s++) {
        for (int c = 0; c < matrixSize; c++) {
          matrix[s][c] = in.nextInt();
        }
      }
      matrixList.add(matrix);
    }

    solution(matrixList);
  }

  public static void solution(List<int[][]> inputList) {

    int caseNum = 1;
    for (int[][] input : inputList) {
      int size = input[0].length;

      Set<Integer> rowSet;
      Set<Integer> columnSet;
      int trace = 0;

      boolean rowHasRepeated = false;
      boolean columnHasRepeated = false;
      int numberOfRepeatedRows = 0;
      int numberOfRepeatedColumns = 0;

      for (int i = 0; i < size; i++) {

        columnSet = new HashSet<>();
        columnHasRepeated = false;

        rowSet = new HashSet<>();
        rowHasRepeated = false;

        for (int j = 0; j < size; j++) {
          if (rowSet.contains(input[i][j])) {
            rowHasRepeated = true;
          }
          rowSet.add(input[i][j]);

          if (columnSet.contains(input[j][i])) {
            columnHasRepeated = true;
          }
          columnSet.add(input[j][i]);

          if (i == j) {
            trace += input[i][j];
          }
        }
        if (columnHasRepeated) {
          numberOfRepeatedColumns++;
        }
        if (rowHasRepeated) {
          numberOfRepeatedRows++;
        }
      }

      System.out
          .println("Case #" + caseNum++ + ": " + trace + " " + numberOfRepeatedRows + " " + numberOfRepeatedColumns);
    }
  }
}

