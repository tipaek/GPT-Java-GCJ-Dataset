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
		try {
			solution.solveCases();
		} catch (Exception e) {
			System.out.println("Incorrect answer");
			System.exit(1);
		}
		solution.close();

	}

	void solveCases() throws Exception {

		int arr[] = readIntArr();
		for (int i = 1; i <= arr[0]; i++) {
			pw.println(solve(arr[1]));
			pw.flush();
			if (readLine().equals("N")) {
				throw new Exception();
			}

		}
	}

	String solve(int b) {

		int[] c = new int[b + 1];
		Arrays.fill(c, -1);

		for (int i = 1; i < 6; i++) {
			pw.println(i);
			pw.flush();
			c[i] = readInt();
			pw.println(b - i + 1);
			pw.flush();
			c[b - i + 1] = readInt();

		}
		int ci = 6;
		
		
		while (ci <= b / 2) {

			int hsi = -1;
			int hdi = -1;
			for (int i = 1; i < ci; i++) {
				if (c[i] == c[b - i + 1]) {
					if (hsi == -1) {
						hsi = i;
						break;
					}
				}
			}
			for (int i = 1; i < ci; i++) {
				if (c[i] != c[b - i + 1]) {
					if (hdi == -1) {
						hdi = i;
						break;
					}
				}
			}

		

			boolean flipped = false;
			if (hsi != -1) {
				pw.println(hsi);
				pw.flush();
				int cf = readInt();
				if (cf != c[hsi])
					flipped = true;
				
			}

			boolean flippedD = false;
			if (hdi != -1) {
				pw.println(hdi);
				pw.flush();

				int cf = readInt();
				if (cf != c[hdi])
					flippedD = true;
				

			}
			
			if (hsi == -1 || hdi == -1) {
				pw.println(1);
				pw.flush();
				readInt();
				
			}

			if (flipped) {
				for (int i = 1; i < ci; i++) {
					if (c[i] == 1)
						c[i] = 0;
					else
						c[i] = 1;
					if (c[b - i + 1] == 1)
						c[b - i + 1] = 0;
					else
						c[b - i + 1] = 1;
				}
				if (!flippedD) {
					for (int i = 1; i < ci; i++) {
						int tmp = c[i];
						c[i] = c[b - i + 1];
						c[b - i + 1] = tmp;

					}
				}
			} else {
				if (flippedD) {
					for (int i = 1; i < ci; i++) {
						int tmp = c[i];
						c[i] = c[b - i + 1];
						c[b - i + 1] = tmp;

					}
				}
			}

			int cip = ci;
			ci += 4;
			ci = Math.min(ci, b / 2 + 1);
			for (int i = cip; i < ci; i++) {
				
				pw.println(i);
				pw.flush();
				c[i] = readInt();
				pw.println(b - i + 1);
				pw.flush();
				c[b - i + 1] = readInt();
				
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= b; i++) {
			sb.append(c[i]);
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
