
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

  public static Scanner scanner = new Scanner(System.in);
  public static PrintStream out = System.out;

  public static void main(String[] args) throws IOException {

    int testCases = scanner.nextInt();
    for (int i = 1; i <= testCases; i++) {
      int n = scanner.nextInt();
      int[][] matrix = new int[n][n];
      for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
          matrix[r][c] = scanner.nextInt();
        }
      }

      int[] resp = solve(matrix);
      out.printf("Case #%d: %d %d %d\n", i, resp[0], resp[1], resp[2]);
    }

  }

  private static int[] solve(int[][] matrix) {
    int[] result = new int[3];
    Map<Integer, Set<Integer>> rowVals = new HashMap<Integer, Set<Integer>>();
    Map<Integer, Set<Integer>> colVals = new HashMap<Integer, Set<Integer>>();
    for (int i = 0; i < matrix.length; i++) {
      rowVals.put(i, new HashSet<Integer>());
      colVals.put(i, new HashSet<Integer>());
    }
    for (int r = 0; r < matrix.length; r++) {
      for (int c = 0; c < matrix.length; c++) {
        if (c == r) {
          result[0] += matrix[r][c];
        }

        if (colVals.containsKey(c)) {
          if (colVals.get(c).contains(matrix[r][c])) {
            result[2]++;
            colVals.remove(c);
          } else {
            colVals.get(c).add(matrix[r][c]);
          }
        }

        if (rowVals.containsKey(r)) {
          if (rowVals.get(r).contains(matrix[r][c])) {
            result[1]++;
            rowVals.remove(r);
          } else {
            rowVals.get(r).add(matrix[r][c]);
          }
        }

      }
    }
    return result;
  }

}