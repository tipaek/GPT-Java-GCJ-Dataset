import java.util.*;
import java.io.*;

public class Solution {
	static FastReader sc;
//	static int mod = (int) Math.pow(10, 9) + 7;
	static BufferedWriter bufferedWriter;
//	static ArrayPrinter ap;
	static String yes = "YES";
	static String no = "NO";

	public static void main(String[] args) throws IOException {
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		sc = new FastReader();
//		ap=new ArrayPrinter();
		int tp = sc.nextInt();
//		int tp = 1;
		for (int i_t = 0; i_t < tp; i_t++) {

			int n = sc.nextInt();
			String[] patterns = new String[n];
			for (int i = 0; i < n; i++) {
				patterns[i] = sc.next();
			}
			String ans = solve(patterns, n);
//			bufferedWriter.write(ans+"\n");
			ans=ans==null?"*":ans.replace("*","");
			bufferedWriter.write("Case #" + (i_t + 1) + ": " + ans + "\n");
		}
		bufferedWriter.flush();

	}

	private static String solve(String[] patterns, int n) {
		String ans = null;
		ans = combine(patterns[0], patterns[1], patterns[0].length(), patterns[1].length(), 0, 0, "");
		for (int i = 2; i < n; i++) {
			if (ans == null)
				return null;
			ans = combine(patterns[i], ans, patterns[i].length(), ans.length(), 0, 0, "");
		}
		// remove *
		return ans;
	}

	private static String combine(String s, String t, int n, int m, int i, int j, String ans) {
		if (i == n && j == m)
			return ans;
		if (i == n ) {
			if(s.charAt(i-1)!='*')
				return null;
			return ans+t.substring(j);
		}
		if (j == m ) {
			if(t.charAt(j-1)!='*')
				return null;
			return ans+s.substring(i);
		}
		
		if (s.charAt(i) != '*' && t.charAt(j) != '*') {
			if (s.charAt(i) != t.charAt(j)) {
				return null;
			}
			return combine(s, t, n, m, i + 1, j + 1, ans + s.charAt(i));
		}

		if (s.charAt(i) == '*' && t.charAt(j) == '*') {

			for (int x = 1; j + x < m; x++) {
				String answ = combine(s, t, n, m, i + 1, j + x, ans + t.substring(j, j + x));
				if (answ != null)
					return answ;
			}

			for (int x = 1; i + x < n; x++) {
				String answ = combine(s, t, n, m, i + x, j + 1, ans + s.substring(i, i + x));
				if (answ != null)
					return answ;
			}
			return null;

		} else {
			if (s.charAt(i) == '*') {
				for (int x = 0; j + x < m; x++) {
					String answ = combine(s, t, n, m, i + 1, j + x, ans + t.substring(j, j + x));
					if (answ != null)
						return answ;
				}
				return null;
			}
			for (int x = 0; i + x < n; x++) {
				String answ = combine(s, t, n, m, i + x, j + 1, ans + s.substring(i, i + x));
				if (answ != null)
					return answ;
			}
			return null;
		}
	}

}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br=new  BufferedReader(new InputStreamReader(System.in));
		
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

	String nextLine() {
		String s = "";
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}
