/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.Point;

class SolutionGCJ {


    public void solve(FastReader in, PrintWriter out) {
        int test_cases = in.nextInt();
        for (int test_case = 0; test_case < test_cases; test_case++) {
          int N = in.nextInt();
          List<Point> activities = new ArrayList<>();
          List<Integer> index = new ArrayList<>();
          List<Integer> output=  new ArrayList<>();

          for (int i = 0; i < N; i++) {
            activities.add(new Point(in.nextInt(), in.nextInt()));
            index.add(i);
            output.add(0);
          }

          Collections.sort(index, (a,b) -> activities.get(a).x - activities.get(b).x);


          int cam = -1000;
          int jam = -1000;
          boolean fail = false;

          for (int i : index) {
            Point p = activities.get(i);
            if (cam <= p.x) {
              output.set(i, 0);
              cam = p.y;
            } else if (jam <= p.x) {
              output.set(i, 1);
              jam = p.y;
            } else {
              out.println(String.format("Case #%d: IMPOSSIBLE", test_case + 1));
              fail = true;
              break;
            }
          }

          if (fail) continue;

          StringBuilder sb = new StringBuilder();
          for (int i : output) {
            if (i == 0) {
              sb.append("J");
            } else {
              sb.append("C");
            }
          }

          String res = sb.toString();

          out.println(String.format("Case #%d: %s", test_case + 1, res));
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
