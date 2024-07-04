import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	final PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) {

		Solution solution = new Solution();

		solution.solveCases();
		solution.close();

	}

	void solveCases() {

		int t = readInt();
		for (int i = 1; i <= t; i++) {
			pw.println("Case #" + i + ": " + solve());

		}
	}

	String solve() {
		int[] arr = readIntArr();
		long x = arr[0];
		long y = arr[1];

		boolean xf = false;
		boolean yf = false;
		String s = "";

		xf = x < 0;
		yf = y < 0;
		x = Math.abs(x);
		y = Math.abs(y);

		int prv = -1;

		while (x > 0 && y > 0) {

			if (x % 2 + y % 2 != 1)
				return "IMPOSSIBLE";
			if (x % 2 == 1) {
				if (prv == 1) {
					s += "-";
				}
				prv = 0;
				s += 'E';
				x ^= 1;
				y /= 2;

			} else if (y % 2 == 1) {
				if (prv == 0) {
					s += "-";
				}
				prv = 1;
				s += 'N';
				y ^= 1;
				x /= 2;

			} else {
				return "IMPOSSIBLE";
			}

		}

		// System.out.println(s);

		// System.out.println(x+" "+y);
		int ln = s.length() - 1;

		String sn = "";
		for (int i = 0; i < ln; i++) {
			if (s.charAt(i) == '-')
				continue;
			if (s.charAt(i + 1) == '-') {
				if (s.charAt(i) == 'E') {
					sn += 'W';
				} else {
					sn += 'S';
				}
			} else {
				sn += s.charAt(i);
			}
		}
		if (ln > -1 && s.charAt(ln) != '-') {
			sn += s.charAt(ln);
		}
		s = sn;
		while (x > 0) {
			if (x % 2 == 0) {
				return "IMPOSSIBLE";
			}
			s += 'E';
			x /= 2;
		}

		while (y > 0) {
			if (y % 2 == 0) {
				return "IMPOSSIBLE";
			}
			s += 'N';
			y /= 2;
		}
		String ret = "";
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (xf) {
				if (s.charAt(i) == 'E') {
					ret += 'W';
					continue;
				} else if (s.charAt(i) == 'W') {
					ret += 'E';
					continue;
				}
			}
			if (yf) {
				if (s.charAt(i) == 'N') {
					ret += 'S';
					continue;
				} else if (s.charAt(i) == 'S') {
					ret += 'N';
					continue;
				}
			}
			ret += s.charAt(i);
		}
		return ret;

	}

	void close() {

		pw.close();

	}

	String readLine() {
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;

	}

	String readString() {
		return readLine();

	}

	long readLong() {
		return Long.parseLong(readLine());
	}

	int readInt() {
		return Integer.parseInt(readLine());
	}

	String[] stringArray() {

		StringTokenizer st = new StringTokenizer(readLine());
		int n = st.countTokens();
		String ret[] = new String[n];
		for (int i = 0; i < n; i++) {
			ret[i] = st.nextToken();
		}
		return ret;

	}

	int[] readIntArr() {
		String[] str = stringArray();
		int arr[] = new int[str.length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(str[i]);
		return arr;
	}

	double[] readDoubleArr() {
		String[] str = stringArray();
		double arr[] = new double[str.length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Double.parseDouble(str[i]);
		return arr;
	}

	long[] readLongArr() {
		String[] str = stringArray();
		long arr[] = new long[str.length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = Long.parseLong(str[i]);
		return arr;
	}

	double readDouble() {
		return Double.parseDouble(readLine());
	}
}
