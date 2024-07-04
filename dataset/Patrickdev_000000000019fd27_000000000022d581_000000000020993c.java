import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

  private static void solve(int testCase) {

    int N = in.nextInt();

    boolean rows[][] = new boolean[N][N];
    boolean columns[][] = new boolean[N][N];

    int trace = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int Mij = in.nextInt();
        rows[i][Mij-1] = true;
        columns[j][Mij-1] = true;
        if (i == j) {
          trace += Mij;
        }
      }
    }

    int incorrectRows = getIncorrectOnes(rows, N);
    int incorrectColumns = getIncorrectOnes(columns, N);

    System.out.printf("Case #%s: %s %s %s%n", testCase, trace, incorrectRows, incorrectColumns);
  }

  private static int getIncorrectOnes(boolean[][] matrix, int N) {

    int incorrectOnes = 0;
    for (int i = 0; i < N; i++) {
      for (int Mij = 0; Mij < N; Mij++) {
        if (!matrix[i][Mij]) {
          incorrectOnes++;
          break;
        }
      }
    }
    return incorrectOnes;
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
