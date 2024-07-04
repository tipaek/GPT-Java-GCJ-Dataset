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

    for (int i = 0; i < T; i++) {
      solve(B);
    }
  }

  private static void solve(int B) {
    int halfB = B / 2;

    int[] bits = new int[B];

    int sameBit = -1;
    int diffBit = -1;
    for (int i = 0; i < 5; i++) {
      int left = queryBit(i);
      int right = queryBit(reversed(B, i));
      if (left == right) {
        sameBit = left;
      } else {
        diffBit = left;
      }
      bits[i] = left;
      bits[reversed(B, i)] = right;
    }

    int pos1 = 5;
    int guess = 0;
    while (pos1 < halfB) {
      int pos2 = reversed(B, pos1);
      if (0 == guess % 10) {

        if (sameBit != -1) {
          int left = queryBit(sameBit);
          guess++;
          if (left != bits[sameBit]) {
            negateBits(halfB, bits);
          }
        } else {
          queryBit(0);
          guess++;
        }

        if (diffBit != -1) {
          int left = queryBit(diffBit);
          guess++;
          if ((left != bits[diffBit])) {
            reverseBits(B, bits);
          }
        } else {
          queryBit(0);
          guess++;
        }

      }
      int left = queryBit(pos1);
      int right = queryBit(pos2);
      guess += 2;
      bits[pos1] = left;
      bits[pos2] = right;
      if (left == right) {
        sameBit = left;
      } else {
        diffBit = left;
      }

      pos1++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < B; i++) {
      sb.append(bits[i]);
    }
    send(sb.toString());

    String answer = getToken();
    if (answer.equals("Y")) {
      return;
    }
    throw new RuntimeException("Wrong answer");
  }

  private static void negateBits(int halfB, int[] bits) {
    for (int i = 0; i < halfB; i++) {
      bits[i] = 1 - bits[i];
    }
  }

  private static void reverseBits(int B, int[] bits) {
    for (int i = 0; i < B; i++) {
      int tmp = bits[i];
      bits[i] = bits[reversed(B, i)];
      bits[reversed(B, i)] = tmp;
    }
  }

  private static int reversed(int B, int i) {
    return B - i - 1;
  }

  private static int queryBit(int i) {
    send(i + 1);
    return getInt();
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
