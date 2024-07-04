import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  private final Scanner in;

  public Solution(final Scanner in) {
    this.in = in;
  }

  public static void main(final String[] args) {
    final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    final Solution solution = new Solution(in);
    int t = in.nextInt();

    for (int i = 1; i <= t; ++i) {
      System.out.println(solution.solve(i));
    }
  }

  public String solve(final int caseNum) {
    int n = in.nextInt();
    int[][] matrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = in.nextInt();
      }
    }

    return solve(caseNum, matrix);
  }

  private String solve(int caseNum, final int[][] matrix) {
    final int k = calculateTrace(matrix);
    final int r = calculateRowsWithRepeatedNumbers(matrix);
    final int c = calculateColumnsWithRepeatedNumbers(matrix);

    return String.format("Case #%d: %d %d %d", caseNum, k, r, c);
  }

  private int calculateTrace(final int[][] matrix) {
    int trace = 0;

    for (int i = 0; i < matrix.length; i++) {
      trace += matrix[i][i];
    }

    return trace;
  }

  private int calculateRowsWithRepeatedNumbers(final int[][] matrix) {
    int rowsWithRepeatedNumbers = 0;

    for (int i = 0; i < matrix.length; i++) {
      if(isRowWithRepeatedNumbers(i, matrix)) {
        rowsWithRepeatedNumbers++;
      }
    }

    return rowsWithRepeatedNumbers;
  }

  private boolean isRowWithRepeatedNumbers(final int i, final int[][] matrix) {
    final Set<Integer> prevNumbers = new HashSet<Integer>();
    boolean result = false;

    for (int j = 0; j < matrix.length; j++) {
      if (!prevNumbers.add(matrix[i][j])) {
        result = true;
        break;
      }
    }

    return result;
  }

  private int calculateColumnsWithRepeatedNumbers(final int[][] matrix) {
    int columnsWithRepeatedNumbers = 0;

    for (int j = 0; j < matrix.length; j++) {
      if (isColumnWithRepeatedNumbers(j, matrix)) {
        columnsWithRepeatedNumbers++;
      }
    }

    return columnsWithRepeatedNumbers;
  }

  private boolean isColumnWithRepeatedNumbers(int j, int[][] matrix) {
    final Set<Integer> prevNumbers = new HashSet<Integer>();
    boolean result = false;

    for (int i = 0; i < matrix.length; i++) {
      if (!prevNumbers.add(matrix[i][j])) {
        result = true;
        break;
      }
    }

    return result;
  }

}