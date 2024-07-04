import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;
import static java.util.Arrays.fill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	// Discuss this round on Codeforces: https://codeforces.com/blog/entry/71545

	static void solve() throws Exception {
		int X = scanInt();
		int Y = scanInt();
		int i =0;
		long u = Math.abs(X)+Math.abs(Y);
		printCase();
		if(u%2 == 0)
		out.println("IMPOSSIBLE");
		else
		{
		    if(X == 0 && Y == 1)
		    System.out.println("N");
		    if(X == 0 && Y == -1)
		    System.out.println("S");
		    if(X == 1 && Y == 0)
		    System.out.println("E");
		    if(X == -1 && Y == 0)
		    System.out.prinltn("W");
		    if(X == 3 && Y == 0)
		    System.out.println("EE");
		    if(X == -3 && Y ==0)
		    System.out.println("WW");
		    if(X ==0 && Y == 3 )
		    System.out.println("NN");
		    if(X == 0 && Y == -3)
		    System.out.println("SS");
		    
		    if(X == 2 && Y == 3)
		    System.out.println("SEN");
		    if(X == -2 && Y == -3)
		    System.out.println("NWS");
		    
		    
		    
		}
		
		
		
	}

	static int scanInt() throws IOException {
		return parseInt(scanString());
	}

	static long scanLong() throws IOException {
		return parseLong(scanString());
	}

	static String scanString() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	static void printCase() {
		out.print("Case #" + test + ": ");
	}

	static void printlnCase() {
		out.println("Case #" + test + ":");
	}

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
	static int test;

	public static void main(String[] args) {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			int tests = scanInt();
			for (test = 1; test <= tests; test++) {
				solve();
			}
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			exit(1);
		}
	}
}