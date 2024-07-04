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

		Set<String> st = new HashSet<>();
		int cl = 0;
		for (int i = 0; i < n; i++) {
			String s = readLine();
			cl = Math.max(cl, s.length());
			st.add(s);
		}

		String ret = "";

		String ms = "";
		String me = "";
		for (String s : st) {
			int ln = s.length();
			for (int i = 0; i < ln; i++) {
				char c = s.charAt(i);
				if (c == '*') {
					
					if (i > ms.length()) {
						ms = s.substring(0, i);
					}
					break;
				}
			}
			for (int i = ln; i-- > 0;) {
				char c = s.charAt(i);
				if (c == '*') {
					if (ln - (i + 1) > me.length()) {
						me = s.substring(i + 1);
					}
					break;
				}
			}
		}
		
		

		int sl = ms.length();
		int el = me.length();

		Set<String> sn = new HashSet<>();

		if (!ms.equals("")) {
			for (String s : st) {
				if (s.startsWith(ms)) {
					sn.add(s.substring(sl));
				} else {
					for (int i = 0; i < s.length(); i++) {
						if (s.charAt(i) == '*') {
							sn.add(s.substring(i));
							break;
						} else {
							if (s.charAt(i) != ms.charAt(i))
								return "*";
						}
					}
				}
			}
			st = sn;
			sn = new HashSet<>();
		}

		if (!me.equals("")) {
			for (String s : st) {

				if (s.endsWith(me)) {

					sn.add(s.substring(0, s.length() - el));
				} else {
					int lns = s.length();

					for (int i = el; i-- > 0;) {

						if (s.charAt(lns - (el - i)) == '*') {
							sn.add(s.substring(0, lns - (el - i) + 1));
						
							break;
						} else {

							if (s.charAt(lns - (el - i)) != me.charAt(i)) {

								return "*";
							}
						}
					}
				}
			}
			st = sn;
		}
		
		;
		ret = ms;
		for (String s : st) {
			ret += s.replaceAll("\\*", "");
		}
		ret += me;
		

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
