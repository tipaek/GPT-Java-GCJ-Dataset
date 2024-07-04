import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;


public class Solution {

	public static void main(String[] args) throws IOException {
		Vestigium v = new Vestigium();
		v.solve();
	}

}

class Vestigium {
	Vestigium() throws IOException {
		in = new FScanner();
		out = new FPrinter();
		check = new int[MAXN + 1];
		sql = new int[MAXN][MAXN];
	}

	
	void analyzeCase(int tc) throws IOException {
		int n = in.nextInt();
		int trace = 0;
		int rrows = 0;
		int rcols = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sql[i][j] = in.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			trace += sql[i][i];
		}
				
		Arrays.fill(check, 0);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				check[sql[i][j]]++;
			}
			boolean flag = true;
			for (int k = 1; k <= n; k++) {
				flag = flag && (check[k] == i+1);
				check[k] = i+1;
			}
			rrows += (flag? 0: 1);
		}
		
		Arrays.fill(check, 0);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				check[sql[j][i]]++;
			}
			boolean flag = true;
			for (int k = 1; k <= n; k++) {
				flag = flag && (check[k] == i+1);
				check[k] = i+1;
			}
			rcols += (flag? 0: 1);
		}		
		
		out.printCase(tc);
		out.printSpace(trace);
		out.printSpace(rrows);
		out.printSpace(rcols);
		out.println();
	}
	
	void solve() throws IOException {
		t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			analyzeCase(i);
		}
		
	//	in.close();
		out.fclose();		
	}
	
	FScanner in;
	FPrinter out;
	
	int t;
	int[] check;
	int[][] sql;
	
	static final int MAXN = 100;
	
}

class FScanner {
	
	FScanner() throws IOException {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	}
	
	int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
	}
	
	double nextDouble() throws IOException {
		in.nextToken();
		return in.nval;
	}
	
	String next() throws IOException {
		in.nextToken();
		return in.sval;
	}

	StreamTokenizer in;
}

class FPrinter {
	
	FPrinter() throws IOException {
		out = new PrintWriter(System.out);
	}
	
	void printSpace(long ans) {
		out.print(" ");
		out.print(ans);
	}
	
	void println() {
		out.println();
	}
	
	void printCase(int tc) throws IOException {
		out.print("Case #");
		out.print(tc);
		out.print(":");
	}
	
	void printlnCase(int tc, String ans) throws IOException {
		printCase(tc);
		out.println(ans);
	}
	
	void printlnCase(int tc, long ans) throws IOException {
		printCase(tc);
		out.println(ans);
	}	
	
	void fclose() {
		out.flush();
		out.close();
	}
	
	PrintWriter out;
}


