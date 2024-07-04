import java.io.*;
import java.util.*;

/**
 * Indicium
 * @author: av-sharma
 */

public class Solution {

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int T = fr.nextInt();
		
		int t = 0;
		while (t++ < T) {
			int n = fr.nextInt();
			int k = fr.nextInt();
			String latinSq = "";

			switch (n) {
				case 2:
					if (k == 4) latinSq = "2 1\n1 2\n";
					break;

				case 3:
					if (k == 3) latinSq = "1 2 3\n3 1 2\n2 3 1\n";
					else if (k == 6) latinSq = "2 3 1\n1 2 3\n3 1 2\n";
					else if (k == 9) latinSq = "3 1 2\n2 3 1\n1 2 3\n";
					break;

				case 4:
					if (k == 4) latinSq = "1 2 3 4\n4 1 2 3\n3 4 1 2\n2 3 4 1\n";
					else if (k == 6) latinSq = "1 2 4 3\n2 1 3 4\n4 3 2 1\n3 4 1 2\n";
					else if (k == 7) latinSq = "1 2 3 4\n3 1 4 2\n4 3 2 1\n2 4 1 3\n";
					else if (k == 8) latinSq = "2 3 4 1\n1 2 3 4\n4 1 2 3\n3 4 1 2\n";
					else if (k == 9) latinSq = "4 1 3 2\n1 3 2 4\n2 4 1 3\n3 2 4 1\n";
					else if (k == 10) latinSq = "4 1 2 3\n1 4 3 2\n2 3 1 4\n3 2 4 1\n";
					else if (k == 11) latinSq = "4 1 3 2\n2 4 1 3\n1 3 2 4\n3 2 4 1\n";
					else if (k == 12) latinSq = "4 2 3 1\n2 4 1 3\n3 1 2 4\n1 3 4 2\n";
					else if (k == 13) latinSq = "4 3 2 1\n2 4 1 3\n1 2 3 4\n3 1 4 2\n";
					else if (k == 14) latinSq = "4 3 2 1\n3 4 1 2\n1 2 3 4\n2 1 4 3\n";
					else if (k == 16) latinSq = "4 1 2 3\n3 4 1 2\n2 3 4 1\n1 2 3 4\n";
					break;

				case 5:
					if (k == 5) latinSq = "1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n";
					else if (k == 7) latinSq = "1 2 3 4 5\n5 1 2 3 4\n2 4 1 5 3\n3 5 4 2 1\n4 3 5 1 2\n";
					else if (k == 8) latinSq = "1 2 3 4 5\n2 1 5 3 4\n3 4 2 5 1\n4 5 1 2 3\n5 3 4 1 2\n";
					else if (k == 9) latinSq = "4 1 5 3 2\n1 2 3 4 5\n2 4 1 5 3\n5 3 2 1 4\n3 5 4 2 1\n";
					else if (k == 10) latinSq = "5 1 2 3 4\n1 2 3 4 5\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n";
					else if (k == 11) latinSq = "5 4 1 3 2\n1 2 5 4 3\n3 1 2 5 4\n2 3 4 1 5\n4 5 3 2 1\n";
					else if (k == 12) latinSq = "5 1 3 4 2\n2 3 1 5 4\n1 4 2 3 5\n4 2 5 1 3\n3 5 4 2 1\n";
					else if (k == 13) latinSq = "5 1 2 3 4\n1 5 4 2 3\n2 3 1 4 5\n3 4 5 1 2\n4 2 3 5 1\n";
					else if (k == 14) latinSq = "5 1 4 3 2\n2 3 1 5 4\n4 2 3 1 5\n1 4 5 2 3\n3 5 2 4 1\n";
					else if (k == 15) latinSq = "5 1 2 3 4\n3 4 5 1 2\n1 2 3 4 5\n4 5 1 2 3\n2 3 4 5 1\n";
					else if (k == 16) latinSq = "5 2 3 4 1\n2 5 4 1 3\n1 4 2 3 5\n3 1 5 2 4\n4 3 1 5 2\n";
					else if (k == 17) latinSq = "5 1 2 3 4\n4 5 1 2 3\n1 3 5 4 2\n2 4 3 1 5\n3 2 4 5 1\n";
					else if (k == 18) latinSq = "5 1 2 3 4\n2 5 1 4 3\n3 4 5 1 2\n1 3 4 2 5\n4 2 3 5 1\n";
					else if (k == 19) latinSq = "5 2 3 4 1\n1 5 2 3 4\n2 4 5 1 3\n3 1 4 2 5\n4 3 1 5 2\n";
					else if (k == 20) latinSq = "5 2 4 1 3\n3 5 2 4 1\n1 3 5 2 4\n2 4 1 3 5\n4 1 3 5 2\n";
					else if (k == 21) latinSq = "5 2 3 1 4\n4 5 2 3 1\n1 4 5 2 3\n2 3 1 4 5\n3 1 4 5 2\n";
					else if (k == 22) latinSq = "5 3 1 2 4\n4 5 3 1 2\n2 4 5 3 1\n3 1 2 4 5\n1 2 4 5 3\n";
					else if (k == 23) latinSq = "5 4 3 2 1\n1 5 4 3 2\n4 2 5 1 3\n2 3 1 4 5\n3 1 2 5 4\n";
					else if (k == 25) latinSq = "5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n";
					break;

				default:
					break;
			}

			System.out.print("Case #" + t + ": ");
			if (latinSq.length() == 0) System.out.println("IMPOSSIBLE");
			else System.out.print("POSSIBLE\n" + latinSq);
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