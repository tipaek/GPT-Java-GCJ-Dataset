import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		NestingDepth nd = new NestingDepth();
		nd.solve();
	}

}

class NestingDepth{
	
	NestingDepth() throws IOException {
		in = new FScanner();
		out = new FPrinter();
		resstr = new char[MAXLEN];
	}
	
	void analyzeCase(int tc) throws IOException {	
		char[] st = in.next().toCharArray();
		int len = st.length;

		
		int depth = 0;
		int laq = 0;		
		
		for (int i = 0; i < len; i++) {
			int diff = depth - ((int)st[i] - ZERO);
			char bk = (diff < 0)? BRA: KET;
			diff = Math.abs(diff);
			for (int j = 0; j < diff; j++) {
				resstr[laq] = bk;
				laq++;
			}
			resstr[laq] = st[i];
			laq++;
			depth = (int)st[i] - ZERO;
		}
		
		for (int j = 0; j < depth; j++) {
			resstr[laq] = KET;
			laq++;
		}
		
		String ans = String.copyValueOf(resstr, 0, laq);
		out.printlnCase(tc, ans);
	}
	
	void solve() throws IOException {
		t = in.nextInt();
		in.in.ordinaryChars('0', '9');
		in.in.wordChars('0', '9');
		
		for (int i = 1; i <= t; i++) {
			analyzeCase(i);
		}
		
		out.fclose();		
	}
	
	int t;
	char[] resstr;
	
	FScanner in;
	FPrinter out;
	
	static final int ZERO = (int)'0';
	static final char BRA = '(';
	static final char KET = ')';
	static int MAXLEN = 2000;
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


