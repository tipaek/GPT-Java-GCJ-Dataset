/*
 * This submission is using the template from https://github.com/krka/codejamjavatemplate
 * Revision: __REVISION__
 */

// Comment this out before submitting
//package codejam20200516.golf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

  private final int caseNumber;
  private final int N;
  private final List<Coord> coords;

  private Solution(int caseNumber) {
    this.caseNumber = caseNumber;
    // Read inputs here
    N = getInt();
    coords = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int x = getInt();
      int y = getInt();
      coords.add(new Coord(x, y));
    }
  }

  private String solve() {
    if (N <= 4) {
      return "" + N;
    }

    Set<Coord> vectors = new HashSet<>();

    for (int i = 0; i < N; i++) {
      Coord src = coords.get(i);
      for (int j = 0; j < N; j++) {
        if (i == j) continue;
        Coord dest = coords.get(j);
        Coord vector = dest.subtract(src);
        vectors.add(vector.normalize());
      }
    }

    int best = 0;
    for (Coord vector : vectors) {
      best = Math.max(best, solve(vector));
    }

    return "" + best;
  }

  private int solve(Coord direction) {
    List<Coord> mergedCoords = new ArrayList<>(coords);
    for (int i = 0; i < N; i++) {
      Coord src = mergedCoords.get(i);
      for (int j = 0; j < N; j++) {
        Coord dest = mergedCoords.get(j);
        Coord vector = dest.subtract(src).normalize();
        if (vector.isZero()) {
          continue;
        }
        if (vector.equals(direction)) {
          mergedCoords.set(j, src);
        }
      }
    }

    Map<Coord, AtomicInteger> sets = new HashMap<>();
    for (Coord coord : mergedCoords) {
      sets.computeIfAbsent(coord, ignore -> new AtomicInteger()).incrementAndGet();
    }

    int lonely = 0;
    int even = 0;
    int odd = 0;
    for (AtomicInteger atomicInteger : sets.values()) {
      int value = atomicInteger.get();
      if (value == 1) {
        lonely++;
      } else if (0 == (value & 1)){
        even += value;
      } else {
        odd += value;
      }
    }

    int total;
    if (odd > 0) {
      total = even + odd + Math.min(1, lonely);
    } else {
      total = even + Math.min(2, lonely);
    }
    return total;
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

  private class Coord {
    private final int x;
    private final int y;

    public Coord(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Coord coord = (Coord) o;
      return x == coord.x &&
              y == coord.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    public Coord subtract(Coord other) {
      return new Coord(x - other.x, y - other.y);
    }

    public Coord normalize() {
      if (isZero()) {
        return this;
      }
      BigInteger bigX = BigInteger.valueOf(x);
      BigInteger bigY = BigInteger.valueOf(y);
      BigInteger gcd = bigX.gcd(bigY);
      return new Coord(bigX.divide(gcd).intValueExact(), bigY.divide(gcd).intValueExact());
    }

    private boolean isZero() {
      return x == 0 && y == 0;
    }

    @Override
    public String toString() {
      return "Coord{" +
              "x=" + x +
              ", y=" + y +
              '}';
    }
  }
}
