/*
 * This submission is using the template from https://github.com/krka/codejamjavatemplate
 * Revision: __REVISION__
 */

// Comment this out before submitting
//package digitstring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

  private final int caseNumber;
  private final int U;
  private final List<Pair> pairs;

  private Solution(int caseNumber) {
    this.caseNumber = caseNumber;
    // Read inputs here
    U = getInt();
    pairs = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      pairs.add(new Pair(getLong(), getToken()));
    }
  }

  private String solve() {
    Map<Character, AtomicInteger> frequencies = new HashMap<>();
    Set<Character> maybeZero = new HashSet<>();

    for (Pair pair : pairs) {
      String R = pair.getR();
      for (int i = 0; i < R.length(); i++) {
        char c = R.charAt(i);
        if (i == 0) {
          frequencies.computeIfAbsent(c, ignore -> new AtomicInteger()).incrementAndGet();
        } else {
          maybeZero.add(c);
        }
      }
    }

    List<Pair> allNonZeroPairs = frequencies.entrySet().stream().map(e -> new Pair(e.getValue().get(), e.getKey().toString()))
            .sorted(Comparator.comparingLong(Pair::getQ).reversed())
            .collect(Collectors.toList());

    List<String> allNonZero = allNonZeroPairs.stream().map(Pair::getR).collect(Collectors.toList());

    List<Character> zero = maybeZero.stream().filter(c -> !allNonZero.contains(c.toString())).collect(Collectors.toList());

    if (zero.size() != 1) {
      return "WRONG ANSWER";
    }
    
    StringBuilder sb = new StringBuilder();
    sb.append(zero.get(0));
    for (String s : allNonZero) {
      sb.append(s);
    }
    return sb.toString();
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

  private static class Pair {
    final long Q;
    final String R;

    private Pair(long q, String r) {
      Q = q;
      R = r;
    }

    public long getQ() {
      return Q;
    }

    public String getR() {
      return R;
    }

    @Override
    public String toString() {
      return "Pair{" +
              "Q=" + Q +
              ", R='" + R + '\'' +
              '}';
    }
  }
}
