import java.io.*;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases;
    testCases = sc.nextInt();

    for (int testCase = 1; testCase <= testCases; testCase++) {
      int matrixSize = sc.nextInt();
      int trace = 0;
      int repeatingRows = 0, repeatingColumns = 0;
      int [][] data = new int[matrixSize][matrixSize];

      for (int i = 0; i < matrixSize; i++) {
        int [] row = new int[matrixSize];
        boolean rowRepeat = false;
        for (int j = 0; j < matrixSize; j++) {
          int number = sc.nextInt();
          row[number-1] += 1;
          if(row[number-1] > 1) {
            rowRepeat = true;
          }
          if (i == j) {
            trace += number;
          }
          data[i][j] = number;
        }
        if(rowRepeat) {
          repeatingRows += 1;
        }
      }

      for (int i = 0; i < matrixSize; i++) {
        int [] columns = new int[matrixSize];
        boolean columnRepeat = false;
        for (int j = 0; j < matrixSize; j++) {
          int number = data[j][i];
          columns[number-1] += 1;
          if(columns[number-1] > 1) {
            columnRepeat = true;
          }
        }
        if(columnRepeat) {
          repeatingColumns += 1;
        }
      }

      System.out.println("Case #" + testCase + ": " + trace + " " +
          repeatingRows + " " + repeatingColumns);
    }
  }
}