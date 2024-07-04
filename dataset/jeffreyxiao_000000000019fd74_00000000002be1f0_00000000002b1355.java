import java.io.*;
import java.util.*;

public class Solution {

  static BufferedReader br;
  static PrintWriter out;
  static StringTokenizer st;

  static int T, R, C;
  static ArrayList<TreeSet<State>> rowLookup = new ArrayList<>();
  static ArrayList<TreeSet<State>> colLookup = new ArrayList<>();

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
      rowLookup.clear();
      colLookup.clear();
      for (int i = 0; i < R; i++) {
        rowLookup.add(new TreeSet<>());
      }
      for (int i = 0; i < C; i++) {
        colLookup.add(new TreeSet<>());
      }
      long currInterest = 0;
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          int skill = readInt();
          currInterest += skill;
          candidateSet.add(new Point(i, j, skill));
          rowLookup.get(i).add(new State(j, skill));
          colLookup.get(j).add(new State(i, skill));
        }
      }
      long totalInterest = currInterest;

      while (true) {
        ArrayList<Point> removedSet = new ArrayList<Point>();
        for (Point p : candidateSet) {
          State s;
          int total = 0;
          int count = 0;
          s = rowLookup.get(p.r).higher(new State(p.c, 0));
          if (s != null) {
            total += s.skill;
            count++;
          }
          s = rowLookup.get(p.r).lower(new State(p.c, 0));
          if (s != null) {
            total += s.skill;
            count++;
          }
          s = colLookup.get(p.c).higher(new State(p.r, 0));
          if (s != null) {
            total += s.skill;
            count++;
          }
          s = colLookup.get(p.c).lower(new State(p.r, 0));
          if (s != null) {
            total += s.skill;
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
        for (Point p : removedSet) {
          rowLookup.get(p.r).remove(new State(p.c, 0));
          colLookup.get(p.c).remove(new State(p.r, 0));
          currInterest -= p.skill;
          State s;
          s = rowLookup.get(p.r).higher(new State(p.c, 0));
          if (s != null) {
            candidateSet.add(new Point(p.r, s.coord, s.skill));
          }
          s = rowLookup.get(p.r).lower(new State(p.c, 0));
          if (s != null) {
            candidateSet.add(new Point(p.r, s.coord, s.skill));
          }
          s = colLookup.get(p.c).higher(new State(p.r, 0));
          if (s != null) {
            candidateSet.add(new Point(s.coord, p.c, s.skill));
          }
          s = colLookup.get(p.c).lower(new State(p.r, 0));
          if (s != null) {
            candidateSet.add(new Point(s.coord, p.c, s.skill));
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
