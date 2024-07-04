import java.io.*;
import java.util.*;

public class Solution {

	static int INF = (int) 1e9;

	static long sum(long n) {
		return n * (n + 1) / 2;
	}

	static long sum(long l, long r) {
		return sum(r) - sum(l - 1);
	}

	static long bs(long val) {
		long lo = 0, hi = INF;
		long ans = -1;
		while (lo <= hi) {
			long mid = lo + hi >> 1;
			if (sum(mid) > val) {
				ans = mid;
				hi = mid - 1;
			} else
				lo = mid + 1;
		}
		return ans;
	}

	static long sumOdd(long l, long r) {
		return sumOdd(r) - sumOdd(l - 1);
	}

	static long sumOdd(long x) {
		x = (x + 1) / 2;
		return x * x;
	}

	static long sumEven(long l, long r) {
		return sum(l, r) - sumOdd(l, r);
	}

	static long sumEven(long r) {
		return sumEven(1, r);
	}

	static long sumStart(long l, long r) {
		long ans;
		if (l % 2 == 0)
			ans = sumEven(r) - sumEven(l - 1);
		else
			ans = sumOdd(r) - sumOdd(l - 1);
		return ans;
	}

	static long[] solve(long[] a, long alt) {
		boolean swap = a[1] > a[0];
		if (swap) {
			long tmp = a[0];
			a[0] = a[1];
			a[1] = tmp;
		}
		long[] ans = new long[] { a[0], a[1], alt };
		alt++;
		long lo = 0, hi = INF;
		while (lo <= hi) {
			long mid = lo + hi >> 1;
			long end = alt + mid - 1;
			long[] take = new long[] { sumStart(alt, end), sum(alt, end) - sumStart(alt, end) };
			if (take[0] <= a[0] && take[1] <= a[1]) {
				ans[0] = a[0] - take[0];
				ans[1] = a[1] - take[1];
				ans[2] = end;
				lo = mid + 1;
			} else
				hi = mid - 1;
		}
		if (swap) {
			long tmp = ans[0];
			ans[0] = ans[1];
			ans[1] = tmp;
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			out.printf("Case #%d: ", t);
			long l = sc.nextLong(), r = sc.nextLong();
			long[] a = new long[2];
			a[0] = l;
			a[1] = r;
			long alt;
			if (a[0] >= a[1]) {
				alt = bs(a[0] - a[1]);
				if (a[0] - sum(alt) < 0)
					alt--;
				a[0] -= sum(alt);
			} else {
				alt = bs(a[1] - a[0] - 1);
				if (a[1] - sum(alt) < 0)
					alt--;
				a[1] -= sum(alt);
			}

//			out.println(alt);
//			out.println(Arrays.toString(a));
			long[] ans = solve(a, alt);
			out.printf("%d %d %d\n", ans[2], ans[0], ans[1]);
		}
		out.close();

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

		int[] nxtArr(int n) throws IOException {
			int[] ans = new int[n];
			for (int i = 0; i < n; i++)
				ans[i] = nextInt();
			return ans;
		}

	}

	static void sort(int[] a) {
		shuffle(a);
		Arrays.sort(a);
	}

	static void shuffle(int[] a) {
		int n = a.length;
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			int tmpIdx = rand.nextInt(n);
			int tmp = a[i];
			a[i] = a[tmpIdx];
			a[tmpIdx] = tmp;
		}
	}

}