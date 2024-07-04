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
				if (i == 0) {
					for (int j = 0; j < n; j++) sb.append('(');
					sb.append(ch);
					continue;
				}
				if (i > 0 && i < str.length()) {
					int prevC = (int) str.charAt(i - 1) - (int) '0';
					int currO = (int) str.charAt(i) - (int) '0';
					int diff = Math.abs(prevC - currO);
					if (prevC > currO) for (int j = 0; j < diff; j++) sb.append(')');
					else for (int j = 0; j < diff; j++) sb.append('(');
					sb.append(ch);
				}
			}
			char ch = str.charAt(str.length() - 1);
			int n = (int) ch - (int) '0';
			for (int i = 0; i < n; i++) sb.append(')');
			System.out.println("Case #" + t + ": " + sb);
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