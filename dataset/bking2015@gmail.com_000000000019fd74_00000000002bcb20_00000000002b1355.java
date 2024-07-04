/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.Point;

class SolutionGCJ {
  int R, C;
  long[][] board;

    public void solve(FastReader in, PrintWriter out) {
        int test_cases = in.nextInt();

        for (int test_case = 0; test_case < test_cases; test_case++) {
          R = in.nextInt();
          C = in.nextInt();

          board = new long[R][C];

          for (int i = 0; i < R; i++) {
            for (int j = 0; j < C;  j++) {
              board[i][j] = in.nextLong();
            }
          }

          List<TreeSet<Integer>> rows = new ArrayList<>();
          List<TreeSet<Integer>> cols = new ArrayList<>();

          for (int i = 0; i < R; i++) rows.add(new TreeSet<>());
          for (int i = 0; i < C; i++) cols.add(new TreeSet<>());

          for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
              rows.get(i).add(j);
            }
          }

          for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
              cols.get(j).add(i);
            }
          }

          List<Point> live = new ArrayList<>();
          for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
              live.add(new Point(i, j));
            }
          }


          int death = -1;
          long total = 0;

          while (death != 0) {
            death = 0;
            total += getTotalSkill(rows, cols);

            Set<Point> nextRound = new HashSet<>();
            Set<Point> toDelete = new HashSet<>();
            for (Point p : live) {
              List<Point> nb = neighbors(p, rows, cols);
              // verify alive
              if (!rows.get(p.x).contains(p.y)) continue;

              if (willDie(p, nb)) {
                death++;
                toDelete.add(p);
                nextRound.addAll(nb);
              }
            }

            live.clear();
            live.addAll(nextRound);
            for (Point p : toDelete) {
              rows.get(p.x).remove(p.y);
              cols.get(p.y).remove(p.x);
            }
          }

          String answer = Long.toString(total);
          out.println(String.format("Case #%d: %s", test_case + 1, answer));
        }
    }

    public List<Point> neighbors(Point p, List<TreeSet<Integer>> rows, List<TreeSet<Integer>> cols) {
      List<Point> ret = new ArrayList<>();
      int i = p.x; int j = p.y;

      Integer left = rows.get(i).lower(j);
      Integer right = rows.get(i).higher(j);
      Integer up = cols.get(j).lower(i);
      Integer down = cols.get(j).higher(i);

      if (left != null) {
        ret.add(new Point(i, left));
      }
      if (right != null) {
        ret.add(new Point(i, right));
      }
      if (up != null) {
        ret.add(new Point(up, j));
      }
      if (down != null) {
        ret.add(new Point(down, j));
      }
      return ret;
    }

    public boolean willDie(Point p, List<Point> nb) {
      long sum = 0;
      for (Point q : nb) sum += board[q.x][q.y];
      if ( sum > board[p.x][p.y] * nb.size()) {
        return true;
      }
      return false;
    }

    public long getTotalSkill(List<TreeSet<Integer>> rows, List<TreeSet<Integer>> cols) {
      long total = 0;
      for (int i = 0; i < R; i++) {
        for (int j : rows.get(i)) {
          total += board[i][j];
        }
      }

      return total;
    }
}


/*******************************************************************************
********************************************************************************
********************************************************************************/


/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		SolutionGCJ solution = new SolutionGCJ();
		solution.solve(in, out);
		out.flush();
		out.close();
	}
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try { st = new StringTokenizer(br.readLine()); }
            catch (IOException  e) { e.printStackTrace(); }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try { str = br.readLine(); }
        catch (IOException e) { e.printStackTrace();
            System.exit(0);
        }
        return str;
    }
}
