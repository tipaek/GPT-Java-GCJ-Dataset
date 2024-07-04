import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		System.out.printf("Case #%d: %d\n",caseNum++,t1);
		int caseNum = 1;
		int t = sc.nextInt();
		out: while (t-- > 0) {
			int u = sc.nextInt();
			int q = 10000;
			HashMap<Integer, HashSet<Character>> map = new HashMap<Integer, HashSet<Character>>();
			HashSet<Character> notZero = new HashSet<Character>();
			HashSet<Character> available = new HashSet<Character>();
			boolean f = false;
			while (q-- > 0) {

				char num[] = sc.next().toCharArray();
				char s[] = sc.next().toCharArray();
				for (char c : s)
					available.add(c);
				notZero.add(s[0]);
				if (num[0] == '-') {
					f= true;
				} else {

					if (num.length != s.length)
						continue;
					int n = num[0] - '0';
					HashSet<Character> temp = map.getOrDefault(n, new HashSet<Character>());
					temp.add(s[0]);
					map.put(n, temp);
				}
			}
			if(f) {
				for(int i=0;i<10;i++) {
					for(char c:available) {
						int n = i;
						HashSet<Character> temp = map.getOrDefault(n, new HashSet<Character>());
						temp.add(c);
						map.put(n, temp);
					}
					
				}
			}
			HashSet<Character> used = new HashSet<Character>();
			char nums[] = new char[10];
			big: for (int i = 0; i < 10; i++) {
				HashSet<Character> set = map.getOrDefault(i, new HashSet<Character>());
				for (char c : set) {
					if (i == 0) {
						if (notZero.contains(c))
							continue;
					}
					if (!used.contains(c)) {
						nums[i] = c;
						used.add(c);
						available.remove(c);
						continue big;
					}
				}
			}
			for (char c : available) {
				nums[0] = c;
				break;
			}
			String ans = new String(nums);
//			System.out.println(ans);
			System.out.printf("Case #%d: %s\n", caseNum++, ans);

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
