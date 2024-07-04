import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
	private static Scanner in;
	private static int t, b;
	private final static int NOOP = 1;
	private final static int XOR = 2;
	private final static int XOR_REVERSE = 3;
	private final static int REVERSE = 4;

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solve(in, System.out);
		in.close();
	}

	protected static void solve(Scanner inp, PrintStream out) {
		t = in.nextInt();
		b = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int[] ret = solveTest();
			if (ret == null) break;
			String resp = getAnswer(ret);
			if (!resp.equals("Y")) {
				break;
			}
		}
	}

	protected static int[] solveTest() {
		int[] ans = new int[b + 1];
		if (b == 10) {
			for (int i = 1; i <= b; i++) {
				int resp = Integer.parseInt(getResp(i));
				ans[i] = resp;
			}
			return ans;
		}
		if (b == 20) {
			int half = b / 2;
			boolean[] eq = new boolean[half + 1];
			for (int pos = 1; pos <= half; pos++) {
				ans[pos] = Integer.parseInt(getResp(pos));
				int rev = b - pos + 1;
				ans[rev] = Integer.parseInt(getResp(rev));
				eq[pos] = ans[pos] == ans[rev];
			}
			for (int pos = 1; pos <= half; pos++) {
				int resp = Integer.parseInt(getResp(pos));
				ans[pos] = resp;
				ans[b - pos + 1] = eq[pos] ? resp : 1 - resp;
			}
		}
		if (b == 100) {
			int half = b / 2;
			boolean[] eq = new boolean[half + 1];
			int dif = -1;
			int same = -1;
			int pos = 1;
			for (int q = 1; q <= 150 && pos <= half; q += 2) {
				if (q < 10 || ((q % 10) != 1 && (q % 10) != 2)) {
					ans[pos] = Integer.parseInt(getResp(pos));
					int rev = b - pos + 1;
					ans[rev] = Integer.parseInt(getResp(rev));
					eq[pos] = ans[pos] == ans[rev];
					if (!eq[pos]) {
						if (dif < 0) dif = pos;
					} else {
						if (same < 0) same = pos;
					}
					pos++;
				} else {
					if (dif < 0 || same < 0) {
						int p1 = Integer.parseInt(getResp(1));
						int p2 = Integer.parseInt(getResp(b - 1)); // superflous
						if (p1 != ans[1]) for (int i = 0; i <= pos; i++)
							ans[i] = 1 - ans[i];
					} else {
						int op = -1;
						int p1 = Integer.parseInt(getResp(same));
						int p2 = Integer.parseInt(getResp(dif));
						if (p1 == ans[same]) {
							op = (p2 == ans[dif] ? NOOP : REVERSE);
						} else {
							op = (p2 == ans[dif] ? XOR_REVERSE : XOR);
						}
						for (int i = 1; i <= pos; i++) {
							if (op == REVERSE && !eq[i]) ans[i] ^= 1;
							if (op == XOR) ans[i] ^= 1;
							if (op == XOR_REVERSE && eq[i]) ans[i] ^= 1;
						}
					}
				}
			}
			for (int i = 1; i <= half; i++) {
				ans[b - i + 1] = eq[i] ? ans[i] : 1 - ans[i];
			}
		}
		return ans;
	}

	static String getResp(int qry) {
		System.out.print(qry);
		System.out.println();
		System.out.flush();
		String resp = in.next();
		return resp;
	}

	static String getAnswer(int[] ans) {
		String ret = "";
		for (int i = 1; i <= b; i++) {
			ret += ans[i];
		}
		System.out.print(ret);
		System.out.println();
		System.out.flush();
		// System.err.println((ret));
		return in.next();
	}
}
