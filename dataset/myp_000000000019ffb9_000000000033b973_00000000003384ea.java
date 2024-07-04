import java.util.*;
import java.io.*;

public class Solution {

  static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {
    int T = s.nextInt();
    for (int t = 1; t <= T; t++) {
      long L = s.nextLong(), R = s.nextLong();

      long D = Math.abs(L - R);
      long m = (long)Math.sqrt(2 * D);
      // System.out.println("L:" + L + " R:" + R + " D:" + D + " m:" + m);

      if (L >= R) {
        L -= m * (m + 1) / 2;
      } else {
        R -= m * (m + 1) / 2;
      }
      // System.out.println("L:" + L + " R:" + R);

      long right = (long) Math.sqrt((L + R) * 2);
      if (L >= R) {
        if (L >= m + 1) {
          m++;
          L -= m;
        }
      } else {
        if (R >= m + 1) {
          m++;
          R -= m;
        }
      }
      long left = m;

      while (left < right) {
        long mid = (left + right + 1) / 2;
        long[] result = calc(m, mid, L, R);
        if (result[0] >= 0 && result[1] >= 0) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
      long[] ans = calc(m, left, L, R);
      System.out.println(String.format("Case #%d: %d %d %d", t, left, ans[0], ans[1]));
    }
  }

  private static long[] calc(long m, long n, long L, long R) {
    if (m == n) {
      return new long[] {L, R};
    }

    if ((n - m - 1) % 2 == 0) {
      // n = m + 3
      long first = (m + 1 + n) * (n - m + 1) / 4;
      long second = (m + 2 + n - 1) * (n - 1 - m) / 4;
      if (L >= R) {
        L -= first;
        R -= second;
      } else {
        L -= second;
        R -= first;
      }
    } else {
      // n = m + 2
      // m + 1 .. n - 1
      long first = (m + n) * (n - m) / 4;
      long second = (m + 2 + n) * (n - m) / 4;
      if (L >= R) {
        L -= first;
        R -= second;
      } else {
        L -= second;
        R -= first;
      }
    }

    return new long[] {L, R};
  }
}
