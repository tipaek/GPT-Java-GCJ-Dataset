import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author csorbazoli
 */
public class Solution {

  private String calculateOutput(int n, int k) {
    StringBuilder ret = new StringBuilder();
    if (k > 0 && k % n == 0) {
      ret.append("POSSIBLE\n");
      int from = k / n;
      IntStream.range(1, n + 1)
          .forEach(row -> generateRow(ret, from - row + 1, n));
    } else {
      ret.append("IMPOSSIBLE\n");
    }
    return ret.toString();
  }

  private void generateRow(StringBuilder ret, int from, int n) {
    int cur = from <= 0 ? from + n : from;
    String sep = "";
    for (int i = 0; i < n; i++) {
      if (cur > n) {
        cur = 1;
      }
      ret.append(sep).append(cur++);
      sep = " ";
    }
    ret.append('\n');
  }

  protected void processTestCase(int caseNum, Scanner scan, PrintWriter out) {
    // get input
    int n = scan.nextInt(); // size of the latin square
    int k = scan.nextInt(); // expected trace value
    out.print("Case #" + caseNum + ": " + calculateOutput(n, k));
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
