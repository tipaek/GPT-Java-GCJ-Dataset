import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
		int u = readInt();

		String[] r = new String[10000];
		Set<Character> dig = new HashSet<>();

		Map<Character, Integer> mp = new HashMap<>();
		for (int i = 0; i < 10000; i++) {
			r[i] = stringArray()[1];
			char[] c = r[i].toCharArray();
			for (int j = 0; j < c.length; j++) {
				Integer nm = mp.get(c[j]);
				if (nm == null) {
					nm = 0;
				}
				nm++;
				mp.put(c[j], nm);
			}
			if (r[i].length() == 1)
				dig.add(r[i].charAt(0));

		}

		String ret = "";

		Set<Character> st = mp.keySet();

		while (st.size() > 0) {
			int mx = 0;
			char mc = '#';
			for (Character c : st) {
				if (mp.get(c) >= mx) {
					mx = mp.get(c);
					mc = c;
				}
			}
			if (st.size() == 1) {
				ret = mc + ret;
			} else
				ret += mc;
			st.remove(mc);
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
