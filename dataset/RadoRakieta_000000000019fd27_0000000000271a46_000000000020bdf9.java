import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static void solve() throws Exception {
		int tests = scanInt();
		for (int test = 1; test <= tests; test++) {
			StringBuilder answer = new StringBuilder();
			List<Integer> cameronTaskBegs = new ArrayList<>();
			List<Integer> cameronTaskEnds = new ArrayList<>();
			List<Integer> jamieTaskBegs = new ArrayList<>();
			List<Integer> jamieTaskEnds = new ArrayList<>();
			boolean isPossible = true;
			int tasks = scanInt();
			for (int j = 1; j <= tasks; j++) {

				int lowerTime = Integer.valueOf(scanString());
				int upperTime = Integer.valueOf(scanString());
				boolean isAssignToCameron = isAssignToPerson(cameronTaskBegs, cameronTaskEnds, lowerTime,
						upperTime);
				if (isAssignToCameron) {
					answer.append('C');
					continue;
				}
				boolean isAssignToJamie = isAssignToPerson(jamieTaskBegs, jamieTaskEnds, lowerTime, upperTime);
				if (isAssignToJamie) {
					answer.append('J');
					continue;
				}
				isPossible = false;
			}
			if (isPossible) {
				out.println("Case #" + test + ": " + answer.toString());
			} else {
				out.println("Case #" + test + ": IMPOSSIBLE");
			}
		}
	}

	static int scanInt() throws IOException {
		return parseInt(scanString());
	}

	static String scanString() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}
	
	private static boolean isAssignToPerson(List<Integer> personTaskBegs, List<Integer> personTaskEnds, int lowerTime,
			int upperTime) {
		boolean isAssign = true;
		for (int i = 0; i < personTaskBegs.size(); i++) {
			int a1 = personTaskBegs.get(i);
			int b1 = personTaskEnds.get(i);
			if (areOverlapping(a1, b1, lowerTime, upperTime)) {
				return false;
			}
		}
		personTaskBegs.add(lowerTime);
		personTaskEnds.add(upperTime);
		return isAssign;
	}

	private static boolean areOverlapping(int a1, int b1, int a2, int b2) {
		if ((Math.max(b1, b2) - Math.min(a1, a2)) < ((b1 - a1) + (b2 - a2))) {
			return true;
		}
		return false;
	}

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;

	public static void main(String[] args) {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			exit(1);
		}
	}
}