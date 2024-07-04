import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static final String CASE = "Case #";
	public static final char OPEN = '(';
	public static final char CLOSE = ')';

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		try {
			int testCaseNumber = in.nextInt();
			in.nextLine();
			StringBuilder sb = new StringBuilder();
			char par;
			int d, n, delta;

			for (int currentTestCase = 1; currentTestCase <= testCaseNumber; ++currentTestCase) {
				sb.setLength(0);
				par = OPEN;
				d = 0;
				String nums = in.nextLine().trim();

				for (int i = 0; i < nums.length(); i++) {
					n = nums.charAt(i) - 48;

					if (d != n) {
						delta = n - d;
						if (delta > 0) { // up
							par = OPEN;
						} else if (delta < 0) { // down
							par = CLOSE;
						}
						for (int j = 0; j < Math.abs(delta); j++) {
							sb.append(par);
							d += (delta > 0) ? 1 : -1;
						}
					}
					sb.append(n);
				}

				if (d > 0) {
					for (int j = 0; j < d; j++) {
						sb.append(CLOSE);
					}
				}

				sb.append("\n");
				System.out.println(CASE + currentTestCase + ": " + sb.toString());
			}
		} finally {
			in.close();
		}
	}
}
