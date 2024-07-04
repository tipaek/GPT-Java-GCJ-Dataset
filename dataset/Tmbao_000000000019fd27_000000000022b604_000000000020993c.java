import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;

/** Built using CHelper plug-in Actual solution is at the top */
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Vestigium solver = new Vestigium();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static class Vestigium {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
      int N = in.nextInt();
      int[][] M = new int[N][N];
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          M[i][j] = in.nextInt();
        }
      }

      long trace = 0;
      HashSet<Integer>[] rowValues = new HashSet[N], colValues = new HashSet[N];
      for (int i = 0; i < N; ++i) {
        rowValues[i] = new HashSet<>();
        colValues[i] = new HashSet<>();
      }
      for (int i = 0; i < N; ++i) {
        trace += M[i][i];
        for (int j = 0; j < N; ++j) {
          rowValues[i].add(M[i][j]);
          colValues[j].add(M[i][j]);
        }
      }
      long repeatedRows = Arrays.stream(rowValues).filter(rowValue -> rowValue.size() < N).count();
      long repeatedCols = Arrays.stream(colValues).filter(colValue -> colValue.size() < N).count();

      out.println(
          String.format("Case #%s: %s %s %s", testNumber, trace, repeatedRows, repeatedCols));
    }
  }
}
