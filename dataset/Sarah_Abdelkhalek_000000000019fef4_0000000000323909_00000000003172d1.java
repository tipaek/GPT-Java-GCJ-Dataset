import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		System.out.printf("Case #%d: %d\n",caseNum++,t1);
		int caseNum = 1;
		int t = sc.nextInt();
		out: while (t-- > 0) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			long arr[] = new long[n];
			long size = Long.MAX_VALUE;
			boolean flag = false;
			long min = Long.MAX_VALUE;
			TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
				min = Math.min(min, arr[i]);
				int count = map.getOrDefault(arr[i], 0) + 1;
				map.put(arr[i], count);
//				System.out.println(count + " " + arr[i]);
				if (count >= 2) {
					size = Math.min(size, arr[i]);
				}
				if (count >= d) {

					flag = true;
				}
			}
//			System.out.println(Arrays.toString(arr));
			if (flag) {
//				System.out.println(caseNum);
				System.out.printf("Case #%d: %d\n", caseNum++, 0);

			} else {
				if (size == Long.MAX_VALUE) {
					if (d == 2)
						System.out.printf("Case #%d: %d\n", caseNum++, d - 1);
					else {
						Long bigger = map.ceilingKey(min*2);
						if(bigger==null) {
							System.out.printf("Case #%d: %d\n", caseNum++, d - 1);
						}else {
							System.out.printf("Case #%d: %d\n", caseNum++, 1);

						}
						
					}
					continue;
				}
				int count = map.get(size);
				if (count == 2) {
					if (d == 3) {
						Long bigger = map.ceilingKey(size + 1);
						if (bigger == null) {
							System.out.printf("Case #%d: %d\n", caseNum++, 2);

						} else {
							System.out.printf("Case #%d: %d\n", caseNum++, 1);

						}

					}
				}
			}
		}

	}
}

class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
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
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if (x.charAt(0) == '-') {
			neg = true;
			start++;
		}
		for (int i = start; i < x.length(); i++)
			if (x.charAt(i) == '.') {
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			} else {
				sb.append(x.charAt(i));
				if (dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg ? -1 : 1);
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

}
