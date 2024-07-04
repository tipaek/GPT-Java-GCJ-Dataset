/*
 * This submission is using the template from https://github.com/krka/codejamjavatemplate
 * Revision: __REVISION__
 */

// Comment this out before submitting
//package partnering;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {

  private final int caseNumber;
  private final List<Activity> acts = new ArrayList<>();

  private Solution(int caseNumber) {
    this.caseNumber = caseNumber;
    int n = getInt();
    for (int i = 0; i < n; i++) {
      acts.add(new Activity(i, getInt(), getInt()));
    }
  }

  private String solve() {
    int cEnd = 0;
    int jEnd = 0;
    acts.sort(Comparator.comparingInt(x -> x.start));
    for (Activity act : acts) {
      if (act.start >= cEnd) {
        act.person = "C";
        cEnd = act.end;
      } else if (act.start >= jEnd) {
        act.person = "J";
        jEnd = act.end;
      } else {
        return "IMPOSSIBLE";
      }
    }
    acts.sort(Comparator.comparingInt(x -> x.i));
    return acts.stream().map(activity -> activity.person).collect(Collectors.joining(" "));
  }

  private static class Activity {
    private final int i;
    private final int start;
    private final int end;
    public String person;

    public Activity(int i, int start, int end) {
      this.i = i;
      this.start = start;
      this.end = end;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Activity activity = (Activity) o;
      return start == activity.start &&
              end == activity.end;
    }

    @Override
    public int hashCode() {
      return Objects.hash(start, end);
    }
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
}
