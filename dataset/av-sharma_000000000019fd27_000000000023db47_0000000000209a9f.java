import java.io.*;
import java.util.*;

/**
 * NestingDepth
 * @author: av-sharma
 */

public class Solution {

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		long T = fr.nextLong();
		long t = 0;
		StringBuffer sb = new StringBuffer();

		while (t++ < T) {
			String str = fr.nextLine();
			sb.delete(0, sb.length());

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				int n = (int) ch - (int) '0';
				for (int j = 0; j < n; j++) sb.append('(');
				sb.append(ch);
				for (int j = 0; j < n; j++) sb.append(')');
			}

			System.out.print("Case #" + t + ": ");
			for (int i = 0; i < sb.length(); i++) {
				char ch = sb.charAt(i);
				System.out.print(ch);
				if (ch == '(' || ch == ')') continue;
				int n = (int) ch - (int) '0';
				if ((1 + i + 2 * n) < sb.length() && sb.charAt(1 + i + 2 * n) == ch) i = i + 2 * n;
			}
			System.out.println();
		}
	}
}

// FastReader Util Class
class FastReader {
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

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	Long nextLong() {
		return Long.parseLong(next());
	}

	Double nextDouble() {
		return Double.parseDouble(next());
	}
}