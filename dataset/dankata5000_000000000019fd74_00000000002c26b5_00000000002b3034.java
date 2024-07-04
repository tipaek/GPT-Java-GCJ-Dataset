import java.io.InputStream;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.run(System.in);
		System.out.print(result);
	}

	String run(InputStream is) {
		StringBuilder out = new StringBuilder();
		try (Scanner scanner = new Scanner(is)) {
			final int T = scanner.nextInt();
			scanner.nextLine();

			for (int t = 1; t <= T; t++) {
				int N = scanner.nextInt();
				scanner.nextLine();
				String[] P = new String[N];

				for (int i = 0; i < N; i++) {
					P[i] = scanner.nextLine();
				}

				String result = doIt(P);
				out.append("Case #" + t + ": " + result + System.lineSeparator());
			}
		}
		return out.toString();
	}

	String doIt(String[] P) {
		int N = P.length;

		// *** -> *
		for (int i = 0; i < P.length; i++) {
			String p = P[i];
			P[i] = p.replaceAll("\\*\\*+", "*");
		}

		// parse parts
		int maxPartsNum = 0;
		String[][] S = new String[N][];
		for (int i = 0; i < P.length; i++) {
			String p = P[i];
			S[i] = p.split("\\*", -1);
			maxPartsNum = Math.max(maxPartsNum, S[i].length);
		}

		String prefix = null;
		String sufix = null;
		for (int i = 0; i < S.length; i++) {
			String[] s = S[i];

			if (prefix == null) {
				prefix = s[0];
			} else {
				if (prefix.startsWith(s[0])) {
					// ok
				} else if (s[0].startsWith(prefix)) {
					prefix = s[0];
				} else {
					return "*";
				}
			}

			if (sufix == null) {
				sufix = s[1];
			} else {
				if (sufix.endsWith(s[1])) {
					// ok
				} else if (s[1].endsWith(sufix)) {
					sufix = s[1];
				} else {
					return "*";
				}
			}

		}

		String result = prefix + sufix;

		return result;
	}
}
