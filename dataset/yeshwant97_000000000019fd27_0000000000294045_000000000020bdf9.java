import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	static FastReader s;
	static PrintWriter out;

	static void solve() {
		int t = s.nextInt();
		int a = 1;
		while (t-- > 0) {
			int n = s.nextInt();
			int[][] arr = new int[n][2];
			HashMap<int[], Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				arr[i][0] = s.nextInt();
				arr[i][1] = s.nextInt();
				map.put(arr[i], i);
			}
			Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[1], o2[1]) == 0 ? Integer.compare(o1[0], o2[0])
					: Integer.compare(o1[1], o2[1]));
			int ctime = 0, jtime = 0;
			HashMap<Integer, Character> map1 = new HashMap<>();
			boolean flag = false;
			for (int[] it : arr) {
				int pos = map.get(it);
				if (ctime <= it[0]) {
					map1.put(pos, 'C');
					ctime = it[1];
				} else if (jtime <= it[0]) {
					map1.put(pos, 'J');
					jtime = it[1];
				} else {
					flag = true;
					break;
				}
			}
			if (flag)
				System.out.println("Case #" + a + ": " + "IMPOSSIBLE");
			else {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < n; i++)
					sb.append(map1.get(i));
				System.out.println("Case #" + a + ": " + sb.toString());

			}
			a++;
		}
	}

	public static void main(String[] args) {
		out = new PrintWriter(System.out);
		s = new FastReader();
		solve();
		out.flush();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}