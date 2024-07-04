import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution implements Runnable {
		
	
	static class Interval implements Comparable<Interval> {
		int i, l, r;

		public Interval(int ii, int ll, int rr) {
			i = ii; l = ll; r = rr;
		}
		
		public int compareTo(Interval o) {
			return Integer.compare(r, o.r);
		}
		
		public String toString() {
			return i + " " + l + " " + r;
		}
		
	}
	
	private void solve() throws IOException {
		int t = nextInt();
		outer: while (t-- > 0) {
			int n = nextInt();
			Interval[] intervals = new Interval[n];
			for (int i = 0; i < n; i++) {
				intervals[i] = new Interval(i, nextInt(), nextInt());
			}
			
			Arrays.parallelSort(intervals);
			
			//pl(Arrays.toString(intervals));
			
			int[] ans = new int[n];
			Arrays.fill(ans, -1);
			//pl(intervals[0].l, intervals[0].r);
			
			ans[intervals[0].i] = 1;
			int rF = intervals[0].r;
			for (int j = 1; j < n; j++) {
				int lF = intervals[j].l;
				int rL = intervals[j].r;
				int idx = intervals[j].i;
				
				if (lF >= rF) {
					ans[idx] = 1;
					rF = rL;
				}
			}
			
			int left = -1, right = -1;
			for (int j = 0; j < n; j++) {
				if (ans[intervals[j].i] == -1) {
					left = intervals[j].l;
					right = intervals[j].r;
					ans[intervals[j].i] = 0;
					break;
				}
			}
			
			for (int j = 0; j < n; j++) {
				if (ans[intervals[j].i] == -1) {
					if (Math.max(left, intervals[j].l) < Math.min(right, intervals[j].r)) {
						pf(); pl("IMPOSSIBLE"); continue outer;
					}
					left = Math.min(left, intervals[j].l);
					right = Math.max(right, intervals[j].r);
					ans[intervals[j].i] = 0;
				}
			}
			StringBuilder res = new StringBuilder();
			pf(); 
			for (int i = 0; i < ans.length; i++) {
				if (ans[i] == -1) {
					pl("IMPOSSIBLE"); continue outer;
				}
				res.append(ans[i] == 1 ? "J" : "C");
			}
			pl(res);
			
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() {
		try {
			reader = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
			writer = new PrintWriter(System.out);
			tokenizer = null;
			solve();
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	BigInteger nextBigInteger() throws IOException {
		return new BigInteger(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	void p(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	void pl(Object... objects) {
		p(objects);
		writer.println();
	}

	int cc;

	void pf() {
		writer.printf("Case #%d: ", ++cc);
	}

}