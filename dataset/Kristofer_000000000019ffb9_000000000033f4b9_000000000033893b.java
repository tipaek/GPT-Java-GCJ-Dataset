/*
 * This submission is using the template from https://github.com/krka/codejamjavatemplate
 * Revision: __REVISION__
 */

// Comment this out before submitting
//package codejam20200516.emacs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

  private final int caseNumber;
  private final int K;
  private final int Q;
  private final long[] left;
  private final long[] right;
  private final long[] jump;

  private final int[] S;
  private final int[] E;

  private final int[] sibling;

  private Solution(int caseNumber) {
    this.caseNumber = caseNumber;
    // Read inputs here
    K = getInt();
    Q = getInt();
    String program = getToken();
    left = new long[K];
    right = new long[K];
    jump = new long[K];
    for (int i = 0; i < K; i++) {
      left[i] = getLong();
    }
    for (int i = 0; i < K; i++) {
      right[i] = getLong();
    }
    for (int i = 0; i < K; i++) {
      jump[i] = getLong();
    }
    S = new int[Q];
    E = new int[Q];
    for (int i = 0; i < Q; i++) {
      S[i] = getInt() - 1;
    }
    for (int i = 0; i < Q; i++) {
      E[i] = getInt() - 1;
    }

    sibling = new int[K];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < K; i++) {
      char c = program.charAt(i);
      if (c == '(') {
        stack.push(i);
      } else {
        int other = stack.pop();
        sibling[other] = i;
        sibling[i] = other;
      }
    }
    if (!stack.isEmpty()) {
      throw new RuntimeException();
    }
  }

  private String solve() {
    HashSet<Integer> visited = new HashSet<>();
    PriorityQueue<Entry> queue = new PriorityQueue<>(Comparator.comparingLong(Entry::getCost));
    long total = 0;
    for (int i = 0; i < Q; i++) {
      total += solve(S[i], E[i], visited, queue);
    }
    return "" + total;
  }

  private long solve(int start, int end, Set<Integer> visited, PriorityQueue<Entry> queue) {
    visited.clear();
    queue.clear();

    queue.add(new Entry(start, 0));
    while (true) {
      Entry current = queue.remove();
      int pos = current.position;
      long cost = current.cost;

      if (!visited.add(pos)) {
        continue;
      }

      if (pos == end) {
        return cost;
      }

      if (pos > 0 && !visited.contains(pos - 1)) {
        queue.add(new Entry(pos - 1, cost + left[pos]));
      }
      if (pos < K - 1 && !visited.contains(pos + 1)) {
        queue.add(new Entry(pos + 1, cost + right[pos]));
      }
      if (!visited.contains(sibling[pos])) {
        queue.add(new Entry(sibling[pos], cost + jump[pos]));
      }
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

  private static class Entry {
    private final int position;
    private final long cost;

    public Entry(int position, long cost) {
      this.position = position;
      this.cost = cost;
    }

    public long getCost() {
      return cost;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Entry entry = (Entry) o;
      return position == entry.position &&
              cost == entry.cost;
    }

    @Override
    public int hashCode() {
      return Objects.hash(position, cost);
    }

    @Override
    public String toString() {
      return "Entry{" +
              "position=" + position +
              ", cost=" + cost +
              '}';
    }
  }
}
