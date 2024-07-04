import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Solution {
	//R2020_1B_C
	
	
	public static void main(String[] args) throws IOException {
		JoinTheRanks jtr = new JoinTheRanks();
		jtr.solve();
	}

}

class JoinTheRanks {
	
	JoinTheRanks() throws IOException {
		in = new FScanner();
		t = in.nextInt();
		out = new FPrinter();
	}
	
	void analyzeCase(int tc) throws IOException {
		int r = in.nextInt();
		int s = in.nextInt();
		int ans = (r-1)*(s-1);
		out.printlnCase(tc, ans);
		int sa = r*(s - 1);
		int sb = r - 1;
		for (int i = 0; i < r-1;  i++) {
			for (int j = 0; j < s-1; j++) {
				out.printlnPair(sa, sb);
				sa--;
			}
			sb--;
		}		
	}
	
	void solve() throws IOException {
		for (int tc = 1; tc <= t; tc++) {
			analyzeCase(tc);
		}
		out.fclose();
	}
		
	int t;
	FScanner in;
	FPrinter out;
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
	
	void printlnPair(long a, long b) {
		out.print(a);
		out.print(" ");
		out.println(b);
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
		out.print(": ");
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


