/*
 * This submission is using the template from https://github.com/krka/codejamjavatemplate
 * Revision: __REVISION__
 */

// Comment this out before submitting
//package interactive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {

  private static void solve() {
    int T = getInt();
    int B = getInt();
    if (B != 10) {
      throw new RuntimeException("Not implemented");
    }

    for (int i = 0; i < T; i++) {
      solve(B);
    }
  }

  private static void solve(int B) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      send(1 + i);
      String token = getToken();
      if (token.equals("1") || token.equals("0")) {
        sb.append(token);
      } else {
        throw new RuntimeException("Unexpected " + token);
      }
    }

    send(sb.toString());

    String answer = getToken();
    if (answer.equals("Y")) {
      return;
    }
    throw new RuntimeException("Wrong answer");
  }

  private static void send(String s) {
    System.out.println(s);
    System.out.flush();
  }

  private static void send(int i) {
    System.out.println(i);
    System.out.flush();
  }

  /**
   * ONLY BOILERPLATE BELOW THIS POINT
   */

  private static BufferedReader reader;
  private static StringTokenizer tokenizer = new StringTokenizer("");

  public static void main(String[] args) {
    reader = new BufferedReader(new InputStreamReader(System.in), 1);
    solve();
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
