/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class SolutionGCJ {


    public void solve(FastReader in, PrintWriter out) {
        int test_cases = in.nextInt();
        for (int test_case = 0; test_case < test_cases; test_case++) {
          String s = in.next();
          StringBuilder sb = new StringBuilder();
          int open = 0;
          for (char c : s.toCharArray()) {
            int i = (c - '0');
            while (open < i) {
              sb.append('(');
              open++;
            }
            while(open > i) {
              open--;
              sb.append(')');
            }
            sb.append(i);
          }
          while (open != 0) {
            sb.append(')');
            open--;
          }

          out.println(String.format("Case #%d: %s", test_case + 1, sb.toString()));
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
