import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		new Solution().run();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof = false;

	void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		int testn = nextInt();
		int bits = nextInt();
		for (int test = 1; test <= testn; test++) {
			solve(bits);
		}
		out.close();
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "0";
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	class Pattern {
		public Pattern(int bits) {
			a = new char[bits];
			Arrays.fill(a, '?');
		}

		char[] a;
		boolean inverse;
		boolean reverse;

		public int hashCode() {
			return Arrays.hashCode(a);
		}

		public boolean equals(Object o) {
			return (o instanceof Pattern) && Arrays.equals(a, ((Pattern) o).a);
		}

		public Pattern reverse() {
			Pattern p = new Pattern(a.length);
			for (int i = 0; i < a.length; i++) {
				p.a[a.length - 1 - i] = a[i];
			}
			p.inverse = inverse;
			p.reverse = !reverse;
			return p;
		}

		public Pattern inverse() {
			Pattern p = new Pattern(a.length);
			for (int i = 0; i < a.length; i++) {
				p.a[i] = a[i] == '1' ? '0' : a[i] == '0' ? 1 : '?';
			}
			p.inverse = !inverse;
			p.reverse = reverse;
			return p;
		}

		public boolean set(int bestPos, char bit) {
			if (a[bestPos] != '?' && a[bestPos] != bit) {
				return false;
			}
			a[bestPos] = bit;
			return true;
		}
	}

	private void solve(int bits) {
		Pattern start = new Pattern(bits);
		HashSet<Pattern> hs = new HashSet<>();
		hs.add(start);
		for (int i = 0; i < 150; i++) {
			if (i % 10 == 0) {
				flipPatterns(hs);
			}
			int bestPos = 0;
			int value = 0;
			int v2 = 0;
			for (int j = 0; j < bits; j++) {
				int zero = 0;
				int one = 0;
				int quest = 0;
				for (Pattern p : hs) {
					if (p.a[j] == '0') {
						zero++;
					} else if (p.a[j] == '1') {
						one++;
					} else {
						quest++;
					}
				}
				int v = Math.min(one, zero);
				if (v > value || v == value && v2 < quest) {
					bestPos = j;
					value = v;
					v2 = quest;
				}
			}
			out.println(bestPos + 1);
			out.flush();
			char bit = (char) (nextInt() + '0');	
			HashSet<Pattern> next = new HashSet<>();
			for (Pattern p : hs) {
				if (p.set(bestPos, bit)) {
					next.add(p);
				}
			}
			hs = next;
		}
		for (Pattern p : hs) {
			for (int i = 0; i < p.a.length; i++) {
				out.print(p.a[i]);
			}
			out.println();
			out.flush();
			break;
		}
		nextToken();
	}

	private void flipPatterns(HashSet<Pattern> hs) {
		HashSet<Pattern> next = new HashSet<>();
		for (Pattern p : hs) {
			next.add(p);
			next.add(p.reverse());
			next.add(p.inverse());
			next.add(p.inverse().reverse());
		}
		hs = next;
	}
}
