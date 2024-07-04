import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class C {


  private static void solve(int testCase) {
    int R = in.nextInt(),
        S = in.nextInt();

    int A = R * (S - 1);
    final int initialWait = S - 1;
    int currentWait = initialWait;

    int second = R - 1;


    out.printf("Case #%s: %s%n", testCase, A - S + 1);
    while (A >= S) {
      if (currentWait == 0) {
        currentWait = initialWait;
        second--;
      }
      out.printf("%s %s%n", A, second);
      A--;
      currentWait--;
    }

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
