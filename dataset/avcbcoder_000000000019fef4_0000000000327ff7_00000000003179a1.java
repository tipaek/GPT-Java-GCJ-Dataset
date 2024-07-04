import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) throws Exception {
		int t = new Integer(br.readLine());
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}

	// **SOLUTION**
	public static void solve() throws Exception {
		int U = new Integer(br.readLine());

		Query[] query = new Query[9];

		boolean allMinusOne = true;
		HashSet<Character> dis = new HashSet<>();
		for (int i = 0; i < query.length; i++) {
			String[] ip = br.readLine().split(" ");
			query[i] = new Query(new Long(ip[0]), ip[1]);
			if (query[i].M != -1)
				allMinusOne = false;
		}

		if (allMinusOne) {
			HashSet<Character> zeroCantbe = new HashSet<>();
			for (int q = 0; q < query.length; q++) {
				String R = query[q].R;
				for (int p = 0; p < R.length(); p++) {
					if (p == 0)
						zeroCantbe.add(R.charAt(p));
					dis.add(R.charAt(p));
				}
			}
			HashSet<Character> notAvail = new HashSet<>();
			HashMap<Integer, Character> done = new HashMap<>();
			for (char c : dis) {
				if (!zeroCantbe.contains(c)) {
					done.put(0, c);
					notAvail.add(c);
					break;
				}
			}
			for (int d = 1; d < 10; d++) {
				for (char c : dis) {
					if (notAvail.contains(c))
						continue;
					if (!done.containsKey(c)) {
						done.put(d, c);
						notAvail.add(c);
						break;
					}
				}
			}
			for (int i = 0; i < 10; i++)
				System.out.print(done.get(i));
			System.out.println();
			return;
		}

		Arrays.sort(query);

		HashSet<Character>[] digit = new HashSet[10];
		for (int i = 0; i < 10; i++)
			digit[i] = new HashSet<>();

		HashMap<Character, int[]> range = new HashMap<>();

		for (int q = 0; q < query.length; q++) {
			String M = query[q].M + "";
			String R = query[q].R;

			boolean sameLength = R.length() == M.length();
			boolean mone = ((query[q].M - 1L) + "").length() < M.length();

			if (sameLength) {
				boolean nz = false;
				for (int p = 0; p < R.length(); p++) {
					int l = p == 0 ? 1 : 0;
					int r = nz ? 9 : M.charAt(p) - '0';
					char c = R.charAt(p);
					dis.add(c);
					// c => (l,r)
					if (range.containsKey(c)) {
						int pl = range.get(c)[0];
						int pr = range.get(c)[1];
						range.put(c, new int[] { Math.max(l, pl), Math.min(pr, r) });
					} else {
						range.put(c, new int[] { l, r });
					}
					int d = R.charAt(p) - '0';
					if ((p == 0 && d > 1) || (p > 0 && d > 0))
						nz = true;
				}
			} else {
				for (int p = 0; p < R.length(); p++) {
					int l = p == 0 ? 1 : 0;
					int r = 9;
					char c = R.charAt(p);
					dis.add(c);
					if (range.containsKey(c)) {
						int pl = range.get(c)[0];
						int pr = range.get(c)[1];
						range.put(c, new int[] { Math.max(l, pl), Math.min(pr, r) });
					} else {
						range.put(c, new int[] { l, r });
					}
				}
			}
		}

		HashMap<Integer, Character> done = new HashMap<>();
		int comp = 0;
		while (comp != 10) {
			for (char c : dis) {
				int l = range.get(c)[0];
				int r = range.get(c)[1];
				int idx = -1;
				int x = 0;
				for (int i = l; i <= r; i++) {
					if (!done.containsKey(i)) {
						x++;
						idx = i;
					}
				}
				if (x == 1) {
					done.put(idx, c);
					comp++;
				}
			}
		}

		for (int i = 0; i < 10; i++)
			System.out.print(done.get(i));
		System.out.println();
	}

	public static class Query implements Comparable<Query> {
		long M;
		String R;
		int idx;

		Query(long m, String r) {
			this.M = m;
			this.R = r;
		}

		@Override
		public int compareTo(Query o) {
			long diff = this.M - o.M;
			if (diff > 0)
				return 1;
			if (diff < 0)
				return -1;
			return 0;
		}

	}

	public static InputStreamReader r = new InputStreamReader(System.in);

	public static BufferedReader br = new BufferedReader(r);

	public static Scanner sc = new Scanner(System.in);
}
