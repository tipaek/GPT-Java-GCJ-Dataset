import java.io.*;
import java.util.*;
import java.nio.file.*;
import static java.lang.Math.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		int cases = i();
		for(int c =0; c<cases; c++){
			int n = i();
			int[][] matrix = new int[n][n];

			int trace =0;
			for(int j=0; j<n; j++)
				for(int k =0; k<n; k++){
					matrix[j][k] = i();
					if(j==k)
						trace+=matrix[j][k];
				}

			int rowcount = 0;
			for(int j =0; j<n; j++){
				HashSet<Integer> rows = new HashSet<Integer>();
				for(int k =0; k<n; k++){
					if(rows.contains(matrix[j][k])){
						rowcount++;
						break;
					}
					rows.add(matrix[j][k]);
				}
			}

			int colcount = 0;
			for(int j=0; j<n; j++){
				HashSet<Integer> cols = new HashSet<Integer>();
				for(int k =0; k<n; k++){
					if(cols.contains(matrix[k][j])){
						colcount++;
						break;
					}
					cols.add(matrix[k][j]);
				}
			}

			out.println("Case #"+c+": "+trace+" "+rowcount+" "+colcount);

		}

		out.close();
	}

	static BufferedReader in;
	static StringTokenizer st = new StringTokenizer("");
	static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static {
		try {
			in = Files.newBufferedReader(Paths.get("test.in"));
		} catch (Exception e) {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	static void check() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
	}
	static String s() throws Exception { check(); return st.nextToken(); }
	static int i() throws Exception { return Integer.parseInt(s()); }
	static long l() throws Exception { return Long.parseLong(s()); }
	static double d() throws Exception { return Double.parseDouble(s()); }
}
