import java.io.*;
import java.util.*;

public class Solution {

  static BufferedReader br;
  static PrintWriter out;
  static StringTokenizer st;

  static int T;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(new OutputStreamWriter(System.out));
    // br = new BufferedReader(new FileReader("in.txt"));
    // out = new PrintWriter(new FileWriter("out.txt"));

    T = readInt();
    for (int t = 1; t <= T; t++) {
      long L = readLong();
      long R = readLong();
      // bf(L, R);
      long lo = 1;
      long hi = (long)(3e9);
      while (lo <= hi) {
        long mid = (lo + hi) / 2;
        if ((mid + 1) * (mid) / 2 > Math.abs(R - L)) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      }
      long curr = hi + 1;
      if (L >= R) {
        L -= (hi + 1) * hi / 2;
      } else {
        R -= (hi + 1) * hi / 2;
      }

      lo = 1;
      hi = (long)(3e9);
      while (lo <= hi) {
        long mid = (lo + hi) / 2;
        long sum = (curr + mid - 1) * mid;
        if (sum > Math.max(R, L)) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      }
      long larger = hi;

      lo = 1;
      hi = (long)(3e9);
      while (lo <= hi) {
        long mid = (lo + hi) / 2;
        long sum = (curr + 1 + mid - 1) * mid;
        if (sum > Math.min(R, L)) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      }
      long smaller = hi;
      larger = Math.min(larger, smaller + 1);
      smaller = Math.min(smaller, larger);
      if (L >= R) {
        L -= (curr + larger - 1) * larger;
        R -= (curr + 1 + smaller - 1) * smaller;
      } else {
        R -= (curr + larger - 1) * larger;
        L -= (curr + 1 + smaller - 1) * smaller;
      }

      out.printf("Case #%d: %d %d %d%n", t, curr - 1 + larger + smaller, L, R);
    }

    out.close();
  }

  static void bf(long L, long R) {
    long i = 1;
    while (L - i >= 0 || R - i >= 0) {
      if (L >= R) {
        L -= i;
      } else {
        R -= i;
      }
      i++;
    }
    out.printf("%d %d %d%n", i - 1, L, R);
  }

  static String next() throws IOException {
    while (st == null || !st.hasMoreTokens())
      st = new StringTokenizer(br.readLine().trim());
    return st.nextToken();
  }

  static long readLong() throws IOException {
    return Long.parseLong(next());
  }

  static int readInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double readDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static char readCharacter() throws IOException {
    return next().charAt(0);
  }

  static String readLine() throws IOException {
    return br.readLine().trim();
  }
}
