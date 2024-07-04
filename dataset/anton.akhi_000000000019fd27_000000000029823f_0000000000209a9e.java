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
			return p;
		}

		public Pattern inverse() {
			Pattern p = new Pattern(a.length);
			for (int i = 0; i < a.length; i++) {
				p.a[i] = a[i] == '1' ? '0' : a[i] == '0' ? '1' : '?';
			}
			return p;
		}

		public boolean set(int bestPos, char bit) {
			if (a[bestPos] != '?' && a[bestPos] != bit) {
				return false;
			}
			a[bestPos] = bit;
			return true;
		}

		public boolean good() {
			for (int i = 0; i < a.length; i++) {
				if (a[i] == '?') {
					return false;
				}
			}
			return true;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < a.length; i++) {
				sb.append(a[i]);
			}
			return sb.toString();
		}
	}

	HashMap<Pattern, Double> hs;

	private void solve(int bits) {
		hs = new HashMap<>();
		Pattern start = new Pattern(bits);
		hs.put(start, 1.0);
		for (int i = 0; i < 150; i++) {
			if (i % 10 == 0) {
				System.err.println(hs.size());
				flipPatterns();
				System.err.println(hs.size());
			}
			if (hs.size() == 1) {
				Pattern p = hs.keySet().iterator().next();
				if (p.good()) {
					break;
				}
			}
			ArrayList<Integer> bp = new ArrayList<>();
			int value = 0;
			int v2 = 0;
			for (int j = 0; j < bits; j++) {
				int zero = 0;
				int one = 0;
				int quest = 0;
				for (Pattern p : hs.keySet()) {
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
					value = v;
					v2 = quest;
					bp.clear();
				}
				if (v == value && v2 == quest) {
					bp.add(j);
				}
			}
			Collections.shuffle(bp);
			int bestPos = bp.get(0);
			out.println(bestPos + 1);
			out.flush();
			char bit = (char) (nextInt() + '0');
			HashMap<Pattern, Double> next = new HashMap<>();
			for (Pattern p : hs.keySet()) {
				double prob = hs.get(p);
				if (p.set(bestPos, bit)) {
					next.put(p, next.getOrDefault(p, 0.0) + prob);
				}
			}
			hs = next;
		}
		double max = 0.0;
		double mm = 0.0;
		Pattern ans = null;
		Pattern bad = null;
		for (Pattern p : hs.keySet()) {
			if (p.good() && hs.get(p) > max) {
				ans = p;
				max = hs.get(p);
			}
			if (hs.get(p) > mm) {
				mm = hs.get(p);
				bad = p;
			}
		}
		if (ans == null) {
			for (int i = 0; i < bad.a.length; i++) {
				out.print(bad.a[i] == '1' ? '1' : '0');
			}
			out.println();
		} else {
			out.println(ans);
		}
		out.flush();
		if (nextToken().equals("N")) {
			System.exit(255);
		}
	}

	private void flipPatterns() {
		HashMap<Pattern, Double> next = new HashMap<>();
		double sum = 0;
		for (Pattern p : hs.keySet()) {
			double prob = hs.get(p) * 0.25;
			if (prob < 1e-8) {
				continue;
			}
			sum += 4 * prob;
			next.put(p, next.getOrDefault(p, 0.0) + prob);
			p = p.inverse();
			next.put(p, next.getOrDefault(p, 0.0) + prob);
			p = p.reverse();
			next.put(p, next.getOrDefault(p, 0.0) + prob);
			p = p.inverse();
			next.put(p, next.getOrDefault(p, 0.0) + prob);
		}
		hs = next;
		for (Pattern p : hs.keySet()) {
			hs.put(p, hs.get(p) / sum);
		}
	}
}
