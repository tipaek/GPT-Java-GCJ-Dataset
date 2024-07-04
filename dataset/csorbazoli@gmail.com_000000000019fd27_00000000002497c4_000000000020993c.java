import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author csorbazoli
 */
public class Solution {

  private class Data {
    int n;
    List<Set<Integer>> rows = new ArrayList<>();
    List<Set<Integer>> columns = new ArrayList<>();
    Set<Integer> wrongRows = new HashSet<>();
    Set<Integer> wrongCols = new HashSet<>();
    int trace;

    void init(int n) {
      this.n = n;
      IntStream.range(0, n).forEach(idx -> {
        rows.add(new HashSet<>());
        columns.add(new HashSet<>());
      });
    }
  }

  private String calculateOutput(Data data) {
    StringBuilder ret = new StringBuilder();
    // trace
    ret.append(data.trace).append(" ");
    // wrong rows
    ret.append(data.wrongRows.size()).append(" ");
    // wrong columns
    ret.append(data.wrongCols.size());
    return ret.toString();
  }

  protected void processTestCase(int caseNum, Scanner scan, PrintWriter out) {
    // get input
    Data data = new Data();
    data.init(scan.nextInt()); // N size of matrix
    for (int i = 0; i < data.n; i++) {
      processLine(data, scan, i);
    }
    out.print("Case #" + caseNum + ": " + calculateOutput(data) + "\n");
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
    // process input file
    try (Scanner scan = new Scanner(inStream)) {
      // open output
      PrintWriter out = new PrintWriter(outStream);
      try {
        // number of test cases
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
          processTestCase(i + 1, scan, out);
        }
      } finally {
        out.close();
      }
    }

  }

  public static void main(String[] args) {
    new Solution().process(System.in, System.out);
  }

}
