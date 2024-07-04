import java.util.*;
import java.io.*;

public class Solution {

  static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {
    int T = s.nextInt();
    for (int t = 1; t <= T; t++) {
      long L = s.nextLong(), R = s.nextLong();
      // long L = t % 1000, R = t / 1000;
      // long[] ans2 = solve(L, R);

      long D = Math.abs(L - R);
      long m = getIndex(D);
      // System.out.println("L:" + L + " R:" + R + " D:" + D + " m:" + m);
      long right = getIndex(L + R);

      if (L >= R) {
        L -= m * (m + 1) / 2;
      } else {
        R -= m * (m + 1) / 2;
      }
      // System.out.println("L:" + L + " R:" + R);


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

      // System.out.println("L:" + L + " R:" + R + " m:" + m + " left:" + left + " right:" + right);

      while (left < right) {
        long mid = (left + right + 1) / 2;
        long[] result = calc(m, mid, L, R);
        // System.out.println("m:" + m + " mid:" + mid + " result:" + Arrays.toString(result));
        if (result[0] >= 0 && result[1] >= 0) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
      long[] ans = calc(m, left, L, R);
      System.out.println(String.format("Case #%d: %d %d %d", t, left, ans[0], ans[1]));
      // if (left != ans2[0] || ans[0] != ans2[1] || ans[1] != ans2[2]) {
        // System.out.println("Wrong:" + Arrays.toString(ans2) + " " + (t % 1000) + " " + (t / 1000));
        // System.out.println(String.format("Case #%d: %d %d %d", t, left, ans[0], ans[1]));
        // return;
      // }
    }
  }

  private static long getIndex(long D) {
    long left = 1, right = (long)Math.sqrt(2 * D);
    while (left < right) {
      long mid = (left + right + 1) / 2;
      if (mid * (mid + 1) / 2 <= D) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private static long[] solve(long L, long R) {
    long m = 1;
    while (m <= Math.max(L, R)) {
      if (L >= R) {
        L -= m;
      } else {
        R -= m;
      }
      m++;
    }
    return new long[] {m - 1, L, R};
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
