/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.Point;

class SolutionGCJ {
  PrintWriter outt;
  FastReader inn;
  int query_count = 0;
  final int NOTHING = 0;
  final int NOT = 1;
  final int REV = 2;
  final int NOTREV = 3;

    public void solve(FastReader in, PrintWriter out) {
      outt = out; inn = in;
        int test_cases = in.nextInt();
        int B = in.nextInt();
        for (int test_case = 0; test_case < test_cases; test_case++) {
          int[] A = new int[B];
          int same = -1;
          int diff = -1;
          // throw away first query
          int x = q(0); int y;
          int i = 0;

          if (B == 1) {
            x = q(0);
            out.println(x);
            out.flush();
            continue;
          }

          while (query_count <= 148) {
            x = q(i);
            y = q(B-1-i);

            if (i != B-1-i && x != y && diff == -1 ) {
              diff = i;
            } else if (i != B-1-i && x == y && same == -1){
              same = i;
            }
            A[i] = x;
            A[B - i - 1] = y;
            i++;
            if (i > (B-1)/2) {
              if (query_count % 10 != 1) {
                break;
              } else {
                i--;
              }
            }

            if (query_count % 10 == 0) {
                q(0);
            }

            if (query_count % 10 == 1) { // figure out what happened
              boolean ss = false; boolean dd = false;
              if (same != -1) {
                ss = A[same] == q(same);
              }
              if (diff != -1) {
                dd = A[diff] == q(diff);
              }

              if (ss && dd) {
                // no change
              } else if (ss && !dd) {
                reverse(A);
              } else if (!ss && dd) {
                complement(A);
                reverse(A);
              } else {
                complement(A);
              }

            }

          }

          for (int j : A) {
            out.print(j);
          }
          out.println();
          out.flush();

        }
    }

    public void reverse(int[] A) {
      for (int i = 0; i < A.length/2; i++) {
        int tmp = A[i];
        A[i] =  A[A.length - 1 - i];
        A[A.length - 1 - i] = tmp;
      }
    }

    public void complement(int[] A) {
      for (int i = 0; i < A.length; i++) {
        A[i] = (A[i] == 0) ? 1 : 0;
      }
    }

    public int q(int pos) {
      outt.println(pos + 1);
      outt.flush();
      query_count++;
      return inn.nextInt();
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
