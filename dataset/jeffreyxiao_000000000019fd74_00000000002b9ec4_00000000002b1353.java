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
      out.printf("Case #%d:%n", t);
      int N = readInt();
      int a = N;
      int b = 1;
      int row = 1;
      while (a > 1) {
        a /= 2;
        b *= 2;
        row++;
      }
      if (b + row - 1 > N) {
        row--;
        b /= 2;
      }
      HashSet<Integer> rows = new HashSet<Integer>();
      a = N;
      for (int i = row; i > 0; i--) {
        if (a - (i - 1) >= b) {
          a -= b;
          rows.add(i);
        } else {
          a--;
        }
        b /= 2;
      }
      int r = 1;
      int c = 1;
      int curr = 1;
      for (int j = 1; j <= row; j++) {
        if (rows.contains(r)) {
          if (c == 1) {
            for (int i = 1; i <= r; i++) {
              out.printf("%d %d%n", r, i);
            }
            c = r + 1;
          } else {
            for (int i = r; i >= 1; i--) {
              out.printf("%d %d%n", r, i);
            }
            c = 1;
          }
          N -= curr;
        } else {
          out.printf("%d %d%n", r, c);
          N--;
          if (c == 1) {
            c = 1;
          } else {
            c++;
          }
        }
        r++;
        curr *= 2;
      }
      while (N > 0) {
        out.printf("%d %d%n", r, c);
        N--;
        if (c == 1) {
          c = 1;
        } else {
          c++;
        }
        r++;
      }
    }

    out.close();
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
