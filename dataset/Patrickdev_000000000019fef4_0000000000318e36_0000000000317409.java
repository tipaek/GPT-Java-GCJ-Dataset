
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {


  private static void solve(int testCase) {
    out.printf("Case #%s: %s%n", testCase, solve());
    out.flush();
  }

  private static String solve() {

    int X = in.nextInt(),
        Y = in.nextInt();
    String M = in.next();

    for (int turn = 0; turn < M.length(); turn++) {
      int step = M.charAt(turn);
      switch (step) {
        case 'S':
          Y--;
          break;
        case 'N':
          Y++;
          break;
        case 'E':
          X++;
          break;
        case 'W':
          X--;
          break;
      }

      int distance = Math.abs(X) + Math.abs(Y);
      if (distance <= turn + 1) {
        return String.valueOf(turn + 1);
      }
    }

    return "IMPOSSIBLE";
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
