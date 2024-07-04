import java.io.*;
import java.util.*;

/**
 * JoinTheRanks
 * @author: av-sharma
 */

public class Solution {
	final static double PI = Math.PI;
	final static int MOD = 1000000007;

	public static void main(String[] args) {
		try {
			FileOutputStream fo = new FileOutputStream("output.txt");
			PrintStream ps = new PrintStream(fo);
			InputStream is = new FileInputStream("input.txt");
			System.setIn(is);
			System.setOut(ps);
		} catch (Exception e) {
			// e.printStackTrace();
		}

		FastReader fr = new FastReader();
		int T = fr.nextInt();
		int t = 0;

		while (t++ < T) {
			// code below
			int R = fr.nextInt();
			int S = fr.nextInt();

			int moves = 0, count = 0;
			int l = R, r = (R * S) - R - 1;
			int lDec, rDec;
			if (R <= S) {
				lDec = 0;
				rDec = 1;
			} else {
				lDec = rDec = 1;
			}
			int[] arr = new int[R * S];
			for (int i = 0; i < R; i++) arr[i] = i + 1;
			int rep = R > S ? R : S, k = R;
			while (rep-- > 0 && k < R * S) {
				for (int j = 0; j < R; j++)
					arr[k++] = arr[j];
			}
			// System.out.print("[ ");
			// for (int i = 0; i < R * S; i++) System.out.print(arr[i] + " ");
			// System.out.println("]");

			StringBuilder sb = new StringBuilder();
			while (!sorted(arr)) {
				// System.out.println(l + " : " + r);
				sb.append(l + " " + r + "\n");
				int[] lArr = new int[l];
				int[] rArr = new int[r];
				
				for (int i = 0; i < l; i++) lArr[i] = arr[i];
				for (int i = 0; i < r; i++) rArr[i] = arr[i + l];
				for (int i = 0; i < r; i++) arr[i] = rArr[i];
				for (int i = r; i < r + l; i++) arr[i] = lArr[i - r];

				// System.out.print("[ ");
				// for (int i = 0; i < R * S; i++) System.out.print(arr[i] + " ");
				// System.out.println("]");

				l -= lDec;
				r -= rDec;
				moves++;
				count++;
				if ((R < S || R == S) && (moves + 1) % S == 0) {
					// System.out.println((moves + 1) % S == 0);
					l--;
				} else if (R > S && (count + 1) % S != 0) {
					l++;
				}
				if (R > S && (count + 1) % S == 0) count = 0;
			}
			sb.replace(sb.length() - 1, sb.length(), "");
			System.out.println("Case #" + t + ": " + moves + "\n" + sb.toString());
		}
	}

	public static boolean sorted(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) if (arr[i] > arr[i + 1]) return false;
		return true;
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