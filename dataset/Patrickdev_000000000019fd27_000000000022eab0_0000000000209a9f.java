import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

  private static void solve(int testCase) {
    char[] input = in.next().toCharArray();

    StringBuilder output = new StringBuilder();
    int depth = 0;
    for (int i = 0; i < input.length; i++) {
      int desiredDepth = input[i] - '0';
      while (desiredDepth > depth) {
        output.append("(");
        depth++;
      }
      while (desiredDepth < depth) {
        output.append(")");
        depth--;
      }
      output.append(input[i]);
    }
    while (depth > 0) {
      output.append(")");
      depth--;
    }
    System.out.printf("Case #%s: %s%n", testCase, output.toString());
  }

  // -----------

  public static void main(String[] args) {
    int testCount = in.nextInt();
    for (int testCase = 1; testCase <= testCount; testCase++) {
      solve(testCase);
    }
  }

  private static ScannerHelper in = new ScannerHelper(System.in);
  private static PrintStream out = System.out;
  private static PrintStream debug = System.err;

  static class ScannerHelper {

    private Scanner sc;

    static void override(String data) {
      System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    ScannerHelper(InputStream stream) {
      sc = new Scanner(stream);
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    BigInteger nextBigInteger() {
      return new BigInteger(next());
    }

    BigDecimal nextBigDecimal() {
      return new BigDecimal(next());
    }

    String next() {
      String word = sc.next();
      if (word != null && !word.isEmpty()) {
        return word;
      }

      sc.nextLine();
      return next();
    }

  }
}
