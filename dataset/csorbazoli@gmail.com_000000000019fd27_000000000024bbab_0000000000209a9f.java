import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author csorbazoli
 */
public class Solution {

  private String calculateOutput(String s) {
    StringBuilder ret = new StringBuilder();
    AtomicInteger curVal = new AtomicInteger(0);
    s.chars().map(c -> c - '0')
        .forEach(n -> appendParenthesis(ret, curVal, n));
    while (curVal.decrementAndGet() >= 0) {
      ret.append(')');
    }
    return ret.toString();
  }

  private void appendParenthesis(StringBuilder ret, AtomicInteger latestDigit, int digit) {
    while (digit > latestDigit.get()) {
      ret.append('(');
      latestDigit.incrementAndGet();
    }
    while (digit < latestDigit.get()) {
      ret.append(')');
      latestDigit.decrementAndGet();
    }
    ret.append(digit);
  }

  protected void processTestCase(int caseNum, Scanner scan, PrintWriter out) {
    // get input
    String s = scan.next(); // line with 0-1
    out.print("Case #" + caseNum + ": " + calculateOutput(s) + "\n");
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
