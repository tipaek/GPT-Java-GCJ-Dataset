/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.Point;

class SolutionGCJ {
    int MAXL = 30;

    public void solve(FastReader in, PrintWriter out) {
        int test_cases = in.nextInt();
        for (int test_case = 0; test_case < test_cases; test_case++) {
          int N = in.nextInt();
          int current = 0;
          List<Integer> rows = new ArrayList<>();

          int log = MAXL;

          while (log >= 0) {
            int x = (1 << log);
            if (current + x + log <= N) {
              rows.add(log);
              current += x;
            } else if (rows.size() != 0){
              current += 1;
            }
            log--;
          }

          // System.out.println(rows);

          Point p = new Point(0, 0);
          List<Point> output = new ArrayList<>();

          int total = 0;

          for (int i = rows.size() - 1; i >= 0; i--) {
            int row = rows.get(i);
            while (p.x < row) {
              output.add(new Point(p));
              total++;
              p.x++;
              if (p.y != 0) p.y++;
            }

            // walk the whole row
            if (p.y == 0) {
              while (p.y <= p.x) {
                output.add(new Point(p));
                p.y++;
              }
              p.y--;

              total += (1 << row);
              p.y++;
              p.x++;
            } else {
              while (p.y >= 0) {
                output.add(new Point(p));
                p.y--;
              }
              p.y++;

              total += (1 << row);
              p.x++;
            }
          }

          while (total < N) {
            output.add(new Point(p));
            total++;
            p.x++;
            if (p.y != 0) p.y++;
          }

          out.println(String.format("Case #%d:", test_case + 1));

          for (Point q : output) {
            out.println(String.format("%d %d", q.x + 1, q.y + 1));
          }
        }
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
