import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

	public static void main(String[] args) throws IOException {
		ParentingPartneringReturns ppr = new ParentingPartneringReturns();
		ppr.solve();
	}

}

class ParentingPartneringReturns {
	
	static class Activity implements Comparable<Activity>{
		
		Activity(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}
		
		public String toString() {
			return "[" + num + ": " + start + " -> " + end + "]";
		}
		
		public int compareTo(Activity a) {
			if (start < a.start) return -1;
			if (start > a.start) return 1;
			if (end < a.end) return -1;
			if (end > a.end) return 1;
			if (num < a.num) return -1;
			if (num > a.num) return 1;
			return 0;
		}
		
		int num;
		int start;
		int end;
	}
	
	ParentingPartneringReturns() throws IOException {
		in = new FScanner();
		out = new FPrinter();
		acts = new ArrayList<ParentingPartneringReturns.Activity>();
		res = new char[MAXN];
	}
	
	void analyzeCase(int tc) throws IOException {	
		acts.clear();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			acts.add(new Activity(i, in.nextInt(), in.nextInt()));
		}
		
		Collections.sort(acts);
		
		int timeJ = 0;
		int timeC = 0;
		
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (acts.get(i).start >= timeJ) {
				res[acts.get(i).num] = JAMIE;
				timeJ = acts.get(i).end;
			}
			else if (acts.get(i).start >= timeC) {
				res[acts.get(i).num] = CAMERON;
				timeC = acts.get(i).end;
			}
			else {
				flag = false;
				break;
			}
		}
		
		String ans = "IMPOSSIBLE";
		if (flag) {
			ans = String.copyValueOf(res, 0, n);
		}
		
		out.printlnCase(tc, ans);
		
	}
	
	void solve() throws IOException {
		t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			analyzeCase(i);
		}
		
		out.fclose();		
	}
	
	int t;
	ArrayList<Activity> acts;
	char[] res;
	
	FScanner in;
	FPrinter out;
	
	static final int MAXN = 1000;
	static final char JAMIE = 'J';
	static final char CAMERON = 'C';
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



