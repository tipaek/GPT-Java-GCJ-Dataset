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
			pw.print("Case #" + i + ": " + solve());

		}
	}

	String solve() {
		int[] arr = readIntArr();
		int n = arr[0];
		int k = arr[1];

		int[][] m = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][(i + j) % n] = j + 1;
			}
		}

		int nd = k - n;
		while (nd > 0) {
			int md = Integer.MAX_VALUE;
			int ii = -1;
			int jj = -1;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					int diff = m[i][j] - m[j][j] + m[j][i] - m[i][i];
					if (diff > 0 && diff < md) {
						md = diff;
						ii=i;
						jj=j;
					}
				}
			}
			int ic = -1;
			int jc = -1;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					int diff = m[j][i] - m[j][j] +  m[i][j] - m[i][i];
					if (diff > 0 && diff < md) {
						md = diff;
						ic=i;
						jc=j;
					}
				}
			}
			if (md == Integer.MAX_VALUE)
				return "IMPOSSIBLE";
			if(ic!=-1) {
				int[]ta=new int[n];
				for(int i=0;i<n;i++) {
					ta[i]=m[i][ic];
				}
				for(int i=0;i<n;i++) {
					m[i][ic]=m[i][jc];
					m[i][jc]=ta[i];
				}
			}else {
				int[]ta=new int[n];
				System.arraycopy(m[ii], 0, ta, 0, n);
				System.arraycopy(m[jj], 0, m[ii], 0, n);
				System.arraycopy(ta, 0, m[jj], 0, n);
			}
			nd -= md;
		}

		if (nd < 0)
			return "IMPOSSIBLE";

		String ret = "POSSIBLE\n";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ret += m[i][j];
				if (j < n - 1) {
					ret += " ";
				} else {
					ret += "\n";
				}
			}
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
