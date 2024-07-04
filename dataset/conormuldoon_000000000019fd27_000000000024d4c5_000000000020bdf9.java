import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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

	class Activity implements Comparable<Activity> {
		int ind;
		int s, e;

		public Activity(int i, int s, int e) {
			ind = i;
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Activity arg) {
			return Integer.compare(s, arg.s);
		}

	}

	String solve() {
		int n = readInt();

		Activity[] arr = new Activity[n];
		for (int i = 0; i < n; i++) {
			int[] se = readIntArr();
			arr[i] = new Activity(i, se[0], se[1]);
		}

		Arrays.sort(arr);
		boolean[] hv = new boolean[n];
		hv[0] = true;
		int lh = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i].s >= arr[lh].e) {
				lh = i;
				hv[i] = true;
			}
		}

		int pi = 0;
		for (int i = 1; i < n; i++) {
			if (!hv[i]) {
				if (pi == 0) {
					pi = i;
				} else {
					if (arr[i].s < arr[pi].e)
						return "IMPOSSIBLE";
					pi = i;
				}
			}
		}

		boolean hn[] = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (hv[i]) {
				hn[arr[i].ind] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (hn[i]) {
				sb.append('C');
			} else {
				sb.append('J');
			}
		}
		return sb.toString();
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
