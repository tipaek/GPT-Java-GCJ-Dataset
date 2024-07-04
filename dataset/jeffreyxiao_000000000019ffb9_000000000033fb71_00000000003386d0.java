import java.io.*;
import java.util.*;

public class Solution {

  static BufferedReader br;
  static PrintWriter out;
  static StringTokenizer st;

  static int T, N;
  static boolean[] linked;
  static HashMap<Integer, Integer> links;
  static Point[] p;
  static int ans;
  static boolean[] vis;
  static boolean[] entered;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(new OutputStreamWriter(System.out));
    // br = new BufferedReader(new FileReader("in.txt"));
    // out = new PrintWriter(new FileWriter("out.txt"));

    T = readInt();
    for (int t = 1; t <= T; t++) {
      N = readInt();

      ans = 4;
      p = new Point[N];
      vis = new boolean[N];
      entered = new boolean[N];
      linked = new boolean[N];
      links = new HashMap<>();

      for (int i = 0; i < N; i++) {
        p[i] = new Point(readInt(), readInt());
      }

      if (N <= 4) {
        out.printf("Case #%d: %d%n", t, N);
        continue;
      }

      solve();
      out.printf("Case #%d: %d%n", t, ans);
    }

    out.close();
  }

  static void solve() {
    for (int i = 0; i < N; i++) {
      if (linked[i]) {
        continue;
      }
      for (int j = 0; j < N; j++) {
        if (linked[j] || j == i) {
          continue;
        }
        linked[i] = true;
        linked[j] = true;
        links.put(i, j);
        links.put(j, i);
        solve();
        updateAns();
        links.remove(i);
        links.remove(j);
        linked[i] = false;
        linked[j] = false;
      }
    }
  }

  static void updateAns() {
    for (int i = 0; i < N; i++) {
      if (!linked[i]) {
        continue;
      }
      for (int j = 0; j < N; j++) {
        if (i == j) {
          continue;
        }
        vis[i] = true;
        vis[links.get(i)] = true;
        entered[links.get(i)] = true;
        simulate(i, p[i].getAngle(p[j]));
        int currAns = 0;
        for (int k = 0; k < N; k++) {
          if (vis[k]) {
            currAns++;
          }
        }
        ans = Math.max(ans, currAns);
        Arrays.fill(vis, false);
        Arrays.fill(entered, false);
      }
    }
  }

  static void simulate(int curr, Fraction angle) {
    int next = -1;
    long minDist = Long.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      if (i == curr) {
        continue;
      }
      Fraction currAngle = p[curr].getAngle(p[i]);
      long currDist = p[curr].getDist(p[i]);
      if (currAngle.equals(angle) && currDist < minDist) {
        next = i;
        minDist = currDist;
      }
    }
    if (next == -1) {
      return;
    }
    vis[next] = true;
    if (linked[next] && !entered[next]) {
      entered[next] = true;
      vis[links.get(next)] = true;
      simulate(links.get(next), angle);
    }
  }

  static class Point {
    long x, y;
    Point(long x, long y) {
      this.x = x;
      this.y = y;
    }

    Fraction getAngle(Point p) {
      return new Fraction(p.x - x, p.y - y);
    }

    long getDist(Point p) {
      return (p.x - x) * (p.x - x) + (p.y - y) * (p.y - y);
    }
  }

  static class Fraction {
    long n, d;
    Fraction(long n, long d) {
      if (n == 0) {
        if (d > 0) {
          d = 1;
        } else {
          d = -1;
        }
      } else if (d == 0) {
        if (n > 0) {
          n = 1;
        } else {
          n = -1;
        }
      } else {
        long gcd = gcd(Math.abs(n), Math.abs(d));
        this.n = n / gcd;
        this.d = d / gcd;
      }
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof Fraction) {
        Fraction f = (Fraction)o;
        return f.n == n && f.d == d;
      }
      return false;
    }

    @Override
    public int hashCode() {
      return new Long(n).hashCode() * 31 + new Long(d).hashCode();
    }
  }

  static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
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
