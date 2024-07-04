/*
 * This submission is using the template from https://github.com/krka/codejamjavatemplate
 * Revision: __REVISION__
 */

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

    int guess = 0;
    for (int i = 0; i < halfB; i++) {
      int rightI = reversed(B, i);
      if (guess > 0 && (0 == (guess % 10))) {

        if (sameBit != -1) {
          int value = queryBit(sameBit);
          guess++;
          if (value != bits[sameBit]) {
            negateBits(B, bits);
          }
        } else {
          queryBit(0);
          guess++;
        }

        if (diffBit != -1) {
          int value = queryBit(diffBit);
          guess++;
          if ((value != bits[diffBit])) {
            reverseBits(B, bits);
          }
        } else {
          queryBit(0);
          guess++;
        }
      }

      int left = queryBit(i);
      int right = queryBit(rightI);
      guess += 2;

      bits[i] = left;
      bits[rightI] = right;
      if (left == right) {
        sameBit = i;
      } else {
        diffBit = i;
      }
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
    System.exit(0);
  }

  private static void negateBits(int B, int[] bits) {
    for (int i = 0; i < B; i++) {
      bits[i] = 1 - bits[i];
    }
  }

  private static void reverseBits(int B, int[] bits) {
    int halfB = B/2;
    for (int i = 0; i < halfB; i++) {
      int rightI = reversed(B, i);
      int tmp = bits[i];
      bits[i] = bits[rightI];
      bits[rightI] = tmp;
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
