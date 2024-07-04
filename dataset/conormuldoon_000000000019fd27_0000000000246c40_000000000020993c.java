import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
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
		int n = readInt();

		int[][] mat = new int[n][n];
		for (int i = 0; i < n; i++) {
			mat[i] = readIntArr();
		}
		int t = 0;
		for (int i = 0; i < n; i++) {
			t += mat[i][i];
		}
		int r = 0;

		for (int i = 0; i < n; i++) {
			Set<Integer> st = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if (st.contains(mat[i][j])) {
					r++;
					break;
				}
				st.add(mat[i][j]);
			}
		}

		int c = 0;

		for (int i = 0; i < n; i++) {
			Set<Integer> st = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if (st.contains(mat[j][i])) {
					c++;
					break;
				}
				st.add(mat[j][i]);
			}
		}

		return t + " " + r + " " + c;
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
