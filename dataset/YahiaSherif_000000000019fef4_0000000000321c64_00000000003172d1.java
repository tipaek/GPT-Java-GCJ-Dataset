
import java.util.*;
import java.io.*;
import java.text.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		int tc = 1;
		while (t-- > 0) {
			pw.printf("Case #%d: ", tc++);
			int n = sc.nextInt();
			int d = sc.nextInt();
			long[] arr = new long[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextLong();
			}
			if (d == 2) {
				HashSet<Long> hs = new HashSet<Long>();
				for (int i = 0; i < arr.length; i++) {
					hs.add(arr[i]);
				}
				if (hs.size() == n) {
					pw.println(1);
				} else {
					pw.println(0);
				}
			} else if (d == 3) {
				TreeMap<Long, Integer> hm = new TreeMap<Long, Integer>();
				int ans = 2;
				for (int i = 0; i < arr.length; i++) {
					hm.put(arr[i], 1 + hm.getOrDefault(arr[i], 0));
				}
				for (Map.Entry<Long, Integer> e : hm.entrySet()) {
					if (e.getValue() >= 3) {
						ans = Math.min(ans, 0);
					}
					if (e.getValue() == 2) {
						if (hm.ceilingEntry(e.getKey() + 1) != null) {
							ans = Math.min(ans, 1);
						}
					}
					if (e.getKey() % 2 == 0 && hm.containsKey(e.getKey() / 2)) {
						ans = Math.min(ans, 1);
					}
				}
				pw.println(ans);
			}
		}
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public int[] nextIntArr(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = nextInt();
			return arr;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
