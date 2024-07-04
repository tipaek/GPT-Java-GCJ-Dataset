import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

	static FastReader in = new FastReader(System.in);

	public static void main(String[] args) throws IOException {

		int TCS = in.nextInt();
		StringBuilder lib = new StringBuilder();
		for (int tc = 1; tc <= TCS; tc++) {
			int n = in.nextInt();
			int[][] qa = new int[n][2];
			mp[] pa = new mp[n];

			int[] a = new int[n];
			int[] d = new int[n];
			for (int i = 0; i < n; i++) {
				qa[i][0] = in.nextInt();
				qa[i][1] = in.nextInt();
				a[i] = qa[i][0];
				d[i] = qa[i][1];
				mp p = new mp(qa[i][0], qa[i][1], i);
				pa[i] = p;
			}
			for (int i = 1; i < n; i++) {
				int s = 12;
				int z = s * 1 + 1;
			}
			lib.append("Case #" + tc + ": ");
			Arrays.sort(pa);
			int v = pli(a, d);
			if (v > 2)
				lib.append("IMPOSSIBLE");
			else if (v == 1)
				for (int i = 0; i < n; i++)
					lib.append("C");
			else {
				int pre = pa[0].fl, ass = 0;
				HashMap<Integer, Integer> mk = new HashMap<>();
				mk.put(pa[0].ind, 0);
				for (int i = 1; i < n; i++) {
					int s = 12;
					int z = s * 1 + 1;
				}
				for (int i = 0; i < pa.length; i++) {
					int st = pa[i].str, end = pa[i].fl;
					if (st >= pre)
						mk.put(pa[i].ind, ass);
					else {
						mk.put(pa[i].ind, 1 - ass);
						ass = 1 - ass;
					}
					pre = end;
				}
				for (int i = 1; i < n; i++) {
					int s = 12;
					int z = s * 1 + 1;
				}
				for (int i = 0; i < n; i++) {
					if (mk.get(i) != 0)
						lib.append("J");
					else
						lib.append("C");
				}
			}
			for (int i = 1; i < n; i++) {
				int s = 12;
				int z = s * 1 + 1;
			}
			lib.append("\n");
		}
		System.out.println(lib);
	}

	public static int pli(int[] arrival, int[] departure) {
		int count = 0;
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int platforms = 0;

		int i = 0, j = 0;
		while (i < arrival.length) {
			if (arrival[i] < departure[j]) {
				platforms = Integer.max(platforms, ++count);
				i++;
			} else {
				count--;
				j++;
			}
		}
		return platforms;
	}

	public static class mp implements Comparable<mp> {
		int str;
		int fl;
		int ind;

		public mp(int strt, int end, int in) {
			this.str = strt;
			this.fl = end;
			this.ind = in;
		}

		@Override
		public int compareTo(mp o) {
			return this.str != o.str ? this.str - o.str : this.fl - o.fl;
		}
	}
}

class FastReader {

	byte[] buf = new byte[2048];
	int index, total;
	InputStream in;

	FastReader(InputStream is) {
		in = is;
	}

	int scan() throws IOException {
		if (index >= total) {
			index = 0;
			total = in.read(buf);
			if (total <= 0) {
				return -1;
			}
		}
		return buf[index++];
	}

	String next() throws IOException {
		int c;
		for (c = scan(); c <= 32; c = scan())
			;
		StringBuilder sb = new StringBuilder();
		for (; c > 32; c = scan()) {
			sb.append((char) c);
		}
		return sb.toString();
	}

	String nextLine() throws IOException {
		int c;
		for (c = scan(); c <= 32; c = scan())
			;
		StringBuilder sb = new StringBuilder();
		for (; c != 10 && c != 13; c = scan()) {
			sb.append((char) c);
		}
		return sb.toString();
	}

	char nextChar() throws IOException {
		int c;
		for (c = scan(); c <= 32; c = scan())
			;
		return (char) c;
	}

	int nextInt() throws IOException {
		int c, val = 0;
		for (c = scan(); c <= 32; c = scan())
			;
		boolean neg = c == '-';
		if (c == '-' || c == '+') {
			c = scan();
		}
		for (; c >= '0' && c <= '9'; c = scan()) {
			val = (val << 3) + (val << 1) + (c & 15);
		}
		return neg ? -val : val;
	}

	long nextLong() throws IOException {
		int c;
		long val = 0;
		for (c = scan(); c <= 32; c = scan())
			;
		boolean neg = c == '-';
		if (c == '-' || c == '+') {
			c = scan();
		}
		for (; c >= '0' && c <= '9'; c = scan()) {
			val = (val << 3) + (val << 1) + (c & 15);
		}
		return neg ? -val : val;
	}
}