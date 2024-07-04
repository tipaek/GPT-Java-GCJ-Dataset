import java.util.Scanner;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Solution {
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int c = s.nextInt();
    for(int i = 0; i < c; i++) {
      int n = s.nextInt();
      LatinSquare square = new LatinSquare(i + 1, n);
      for(int j = 0; j < n; j++) {
        for(int k = 0; k < n; k++) {
          square.setCell(j, k, s.nextInt());
        }
      }
      System.out.println(square);
    }
    s.close();
  }
}

class LatinSquare {
  public int[][] matrix;
  public int n;
  public int c;

  public LatinSquare(int c, int n) {
    this.c = c;
    this.n = n;
    matrix = new int[n][n];
  }

  public void setCell(int r, int c, int v) {
    matrix[r][c] = v;
  }

  public int trace() {
    int trace = 0;
    for (int i = 0; i < n; i++) {
      trace += matrix[i][i];
    }
    return trace;
  }

  public int repeatedRows() {
    int repeatedRows = 0;
    for(int i = 0; i < n; i++) {
      int[] values = new int[n];
      for(int j = 0; j < n; j++) {
        values[matrix[i][j] - 1] += 1;
      }
      if(Arrays.stream(values).summaryStatistics().getMax() > 1)
        repeatedRows++;
    }
    return repeatedRows;
  }

  public int repeatedColumns() {
    int repeatedColumns = 0;
    for(int i = 0; i < n; i++) {
      int[] values = new int[n];
      for(int j = 0; j < n; j++) {
        values[matrix[j][i] - 1] += 1;
      }
      if(Arrays.stream(values).summaryStatistics().getMax() > 1)
        repeatedColumns++;
    }
    return repeatedColumns;
  }

  public String toString() {
    return "Case #" + c + ": " + trace() + " " + repeatedRows() + " " + repeatedColumns();
  }
}