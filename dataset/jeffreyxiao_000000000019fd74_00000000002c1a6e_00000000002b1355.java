import java.io.*;
import java.util.*;

public class Solution {

  static BufferedReader br;
  static PrintWriter out;
  static StringTokenizer st;

  static int T, R, C;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(new OutputStreamWriter(System.out));
    //br = new BufferedReader(new FileReader("in.txt"));
    //out = new PrintWriter(new FileWriter("out.txt"));

    T = readInt();
    for (int t = 1; t <= T; t++) {
      R = readInt();
      C = readInt();
      HashSet<Point> candidateSet = new HashSet<Point>();
      Point[][] ps = new Point[R][C];
      long currInterest = 0;
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          int skill = readInt();
          currInterest += skill;
          ps[i][j] = new Point(i, j, skill);
          candidateSet.add(ps[i][j]);
        }
      }
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (i > 0) {
            ps[i][j].n = ps[i - 1][j];
          }
          if (i < R - 1) {
            ps[i][j].s = ps[i + 1][j];
          }
          if (j > 0) {
            ps[i][j].w = ps[i][j - 1];
          }
          if (j < C - 1) {
            ps[i][j].e = ps[i][j + 1];
          }
        }
      }
      long totalInterest = currInterest;

      while (true) {
        HashSet<Point> removedSet = new HashSet<Point>();
        for (Point p : candidateSet) {
          State s;
          int total = 0;
          int count = 0;
          if (p.n != null) {
            total += p.n.skill;
            count++;
          }
          if (p.e != null) {
            total += p.e.skill;
            count++;
          }
          if (p.s != null) {
            total += p.s.skill;
            count++;
          }
          if (p.w != null) {
            total += p.w.skill;
            count++;
          }
          if (p.skill * count < total) {
            removedSet.add(p);
          }
        }
        candidateSet.clear();
        if (removedSet.isEmpty()) {
          break;
        }
        HashSet<Point> candidateCandidateSet = new HashSet<>();
        for (Point p : removedSet) {
          if (p.n != null) {
            p.n.s = p.s;
            candidateCandidateSet.add(p.n);
          }
          if (p.s != null) {
            p.s.n = p.n;
            candidateCandidateSet.add(p.s);
          }
          if (p.e != null) {
            p.e.w = p.w;
            candidateCandidateSet.add(p.e);
          }
          if (p.w != null) {
            p.w.e = p.e;
            candidateCandidateSet.add(p.w);
          }
          currInterest -= p.skill;
        }
        for (Point p : candidateCandidateSet) {
          if (!removedSet.contains(p)) {
            candidateSet.add(p);
          }
        }
        totalInterest += currInterest;
      }
      out.printf("Case #%d: %d%n", t, totalInterest);
    }

    out.close();
  }

  static class State implements Comparable<State> {
    int coord, skill;
    State (int coord, int skill) {
      this.coord = coord;
      this.skill = skill;
    }

    @Override
    public int compareTo(State s) {
      return coord - s.coord;
    }
  }

  static class Point {
    int r, c, skill;
    Point n, e, s, w;
    Point (int r, int c, int skill) {
      this.r = r;
      this.c = c;
      this.skill = skill;
    }

    @Override
    public int hashCode() {
      return Integer.hashCode(r) * 31 * 31 + Integer.hashCode(c) * 31 + Integer.hashCode(skill);
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof Point) {
        Point p = (Point)o;
        return r == p.r && c == p.c && skill == p.skill;
      }
      return false;
    }
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
