import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

  private static void solve(int testCase) {
    System.out.printf("Case #%s: %s%n", testCase, solveResult());
  }

  private static String solveResult() {

    List<Integer[]> toSchedule = new ArrayList<>();

    int N = in.nextInt();
    char[] result = new char[N];

    for (int i = 0; i < N; i++) {
      int start = in.nextInt();
      int end = in.nextInt();

      toSchedule.add(new Integer[]{start, end, i});
    }

    toSchedule.sort(Comparator.comparingInt(o -> o[0]));


    int freeAt0 = 0, freeAt1 = 0;
    for (int i = 0; i < N; i++) {
      Integer[] arr = toSchedule.get(i);
      int start = arr[0],
          end = arr[1],
          nthTask = arr[2];

      if (start >= freeAt0) {
        result[nthTask]='C';
        freeAt0 = end;
      } else if (start >= freeAt1) {
        result[nthTask]='J';
        freeAt1 = end;
      } else {
        return "IMPOSSIBLE";
      }
    }

    return new String(result);
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
