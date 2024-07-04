import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
	private static Scanner in;
	private static int t, b;

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
		int half = b / 2;
		boolean[] eq = new boolean[half + 1];
		Arrays.fill(ans, -1);
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
//		 System.err.println((ret));
		return in.next();
	}
}
