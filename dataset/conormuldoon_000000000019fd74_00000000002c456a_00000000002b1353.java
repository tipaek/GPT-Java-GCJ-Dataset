import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
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
			pw.print("Case #" + i + ": " + solve());

		}
	}

	String solve() {
		int n = readInt();

		int num = 1;

		ArrayList<int[]> p = new ArrayList<>();

		int[] first = { 1, 1 };
		p.add(first);
		int v = 1;
		while (num < n) {
			if (v == 1) {
				int[] cr = { 2, 1 };
				p.add(cr);
				num++;
				v++;
			} else if (num + v <= n) {
				int[] cr = { v + 1, 2 };
				p.add(cr);
				num += v;
				v++;
			} else {
				int[] cr = { v + 1, 1 };
				p.add(cr);
				num++;
				v++;
			}

		}
		String ret = "\n";
		for (int[] pi : p) {
			ret += pi[0] + " " + pi[1] + "\n";
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
