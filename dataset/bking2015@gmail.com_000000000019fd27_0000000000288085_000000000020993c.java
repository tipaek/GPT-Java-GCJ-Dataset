/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class SolutionGCJ {


    public void solve(FastReader in, PrintWriter out) {
        int test_cases = in.nextInt();
        for (int test_case = 0; test_case < test_cases; test_case++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int failr = 0;
            int trace = 0;
            for (int i = 0; i < N; i++) trace += matrix[i][i];

            Set<Integer> seen = new HashSet<>();
            for (int[] row : matrix) {
                seen.clear();
                for (int i : row) seen.add(i);
                if (seen.size() != N) failr++;
            }

            int failc = 0;
            for (int j = 0; j < N; j++) {
                seen.clear();
                for (int i = 0; i < N; i++) {
                    seen.add(matrix[i][j]);
                }
                if (seen.size() != N) failc++;
            }

            out.println(String.format("Case #%d: %d %d %d", test_case + 1, trace, failr, failc));
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
