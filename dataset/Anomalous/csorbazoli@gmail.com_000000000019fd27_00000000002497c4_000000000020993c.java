import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {

  private static class Data {
    int n;
    List<Set<Integer>> rows;
    List<Set<Integer>> columns;
    Set<Integer> wrongRows;
    Set<Integer> wrongCols;
    int trace;

    Data(int n) {
      this.n = n;
      this.rows = new ArrayList<>(n);
      this.columns = new ArrayList<>(n);
      this.wrongRows = new HashSet<>();
      this.wrongCols = new HashSet<>();
      this.trace = 0;
      IntStream.range(0, n).forEach(idx -> {
        rows.add(new HashSet<>());
        columns.add(new HashSet<>());
      });
    }
  }

  private String calculateOutput(Data data) {
    return data.trace + " " + data.wrongRows.size() + " " + data.wrongCols.size();
  }

  private void processTestCase(int caseNum, Scanner scan, PrintWriter out) {
    int n = scan.nextInt();
    Data data = new Data(n);
    for (int i = 0; i < n; i++) {
      processLine(data, scan, i);
    }
    out.printf("Case #%d: %s%n", caseNum, calculateOutput(data));
  }

  private void processLine(Data data, Scanner scan, int idx) {
    for (int i = 0; i < data.n; i++) {
      int value = scan.nextInt();
      if (!data.rows.get(idx).add(value)) {
        data.wrongRows.add(idx);
      }
      if (!data.columns.get(i).add(value)) {
        data.wrongCols.add(i);
      }
      if (i == idx) {
        data.trace += value;
      }
    }
  }

  private void process(InputStream inStream, OutputStream outStream) {
    try (Scanner scan = new Scanner(inStream); PrintWriter out = new PrintWriter(outStream)) {
      int t = scan.nextInt();
      for (int i = 0; i < t; i++) {
        processTestCase(i + 1, scan, out);
      }
    }
  }

  public static void main(String[] args) {
    new Solution().process(System.in, System.out);
  }
}