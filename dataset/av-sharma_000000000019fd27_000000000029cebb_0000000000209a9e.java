import java.io.*;
import java.util.*;

/**
 * ESAbATAd
 * @author: av-sharma
 */

public class Solution {

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int T = fr.nextInt();
		int B = fr.nextInt();
		boolean[] bitSet = new boolean[B];
		String in, res;

		int t = 0;
		while (t++ < T) {
			if (B == 10) {
				for (int i = 0; i < B; i++) {
					System.out.println(i + 1);
					in = fr.next();
					bitSet[i] = in.equals("1") ? true : false;
				}
				for (int i = 0; i < B; i++) System.out.print(bitSet[i] ? 1 : 0);
				System.out.println();
				res = fr.next();
				if (res.equals("Y")) continue;
				else break;
			} else {
				break;
			}
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