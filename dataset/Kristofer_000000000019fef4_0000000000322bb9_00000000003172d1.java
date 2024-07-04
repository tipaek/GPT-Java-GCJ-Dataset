/*
 * This submission is using the template from https://github.com/krka/codejamjavatemplate
 * Revision: __REVISION__
 */

// Comment this out before submitting
//package radialcuts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

  private final int caseNumber;
  private final int N;
  private final int D;
  private final long[] slices;
  private final Rational maxSlicePerPerson;

  private Solution(int caseNumber) {
    this.caseNumber = caseNumber;
    // Read inputs here
    N = getInt();
    D = getInt();
    slices = new long[N];
    for (int i = 0; i < N; i++) {
      slices[i] = getLong();
    }
    Arrays.sort(slices);

    long total = 0;
    for (long slice : slices) {
      total += slice;
    }

    maxSlicePerPerson = new Rational(total, D);

  }

  private String solve() {
    int bestCuts = Integer.MAX_VALUE;
    Set<Rational> sizes = new HashSet<>();
    for (int i = 0; i < N; i++) {
      for (int subdivision = 1; subdivision <= D; subdivision++) {
        long p = slices[i];
        if (p * maxSlicePerPerson.Q <= maxSlicePerPerson.P * subdivision) {
          sizes.add(new Rational(p, subdivision));
        }
      }
    }
    for (Rational size : sizes) {
      bestCuts = Math.min(bestCuts, trySize(size));
    }
    if (bestCuts == Integer.MAX_VALUE) {
      throw new RuntimeException();
    }

    return "" + bestCuts;
  }

  private int trySize(Rational size) {
    int piecesLeft = D;
    int cuts = 0;

    // Consume all exact matches
    for (int i = 0; i < N; i++) {
      long slice = slices[i];
      if (slice * size.Q == size.P) {
        piecesLeft--;
      }
      if (piecesLeft == 0) {
        return 0;
      }
    }

    // Consume from exact multiples
    for (int i = 0; i < N; i++) {
      long slice = slices[i];
      long subslices = size.Q * slice / size.P;
      if (subslices > 1 && subslices * size.P == slice * size.Q) {

        if (subslices == piecesLeft) {
          cuts += subslices - 1;
          return cuts;
        }

        if (subslices > piecesLeft) {
          cuts += piecesLeft;
          return cuts;
        }

        piecesLeft -= subslices;
        cuts += (subslices - 1);

      }
    }

    // Consume from non-multiples
    for (int i = 0; i < N; i++) {
      long slice = slices[i];
      long subslices = size.Q * slice / size.P;
      if (subslices * size.P != slice * size.Q) {

        if (subslices == piecesLeft) {
          cuts += piecesLeft;
          return cuts;
        }

        if (subslices > piecesLeft) {
          cuts += piecesLeft;
          return cuts;
        }

        piecesLeft -= subslices;
        cuts += subslices;
      }
    }

    return Integer.MAX_VALUE;
  }

  /**
   * ONLY BOILERPLATE BELOW THIS POINT
   */

  private static BufferedReader reader;
  private static StringTokenizer tokenizer = new StringTokenizer("");

  public static void main(String[] args) {
    reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      runCases();
    } finally {
      System.out.flush();
    }
  }

  private static void runCases() {
    int cases = getInt();
    for (int c = 1; c <= cases; c++) {
      String answer = new Solution(c).solve();
      String s = "Case #" + c + ": " + answer;
      System.out.println(s);
    }
  }

  private static String readLine() {
    try {
      return reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static String getToken() {
    while (true) {
      if (tokenizer.hasMoreTokens()) {
        return tokenizer.nextToken();
      }
      String s = readLine();
      if (s == null) {
        return null;
      }
      tokenizer = new StringTokenizer(s, " \t\n\r");
    }
  }

  private static double getDouble() {
    return Double.parseDouble(getToken());
  }

  private static int getInt() {
    return Integer.parseInt(getToken());
  }

  private static long getLong() {
    return Long.parseLong(getToken());
  }

  private static BigInteger getBigInt() {
    return new BigInteger(getToken());
  }

  private static BigDecimal getBigDec() {
    return new BigDecimal(getToken());
  }

  private static class Rational {
    final long P;
    final long Q;

    private Rational(long p, long q) {
      P = p;
      Q = q;
    }

    @Override
    public String toString() {
      return "Rational{" +
              "P=" + P +
              ", Q=" + Q +
              '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Rational other = (Rational) o;
      return P * other.Q == other.P * Q;
    }

    @Override
    public int hashCode() {
      return Double.hashCode((double) P / (double) Q);
    }
  }
}
