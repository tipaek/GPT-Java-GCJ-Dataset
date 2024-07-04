import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private static StringBuilder builder;

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			final int numberOfCases = in.nextInt(); // Number of cases
			for (int caseNo = 1; caseNo <= numberOfCases; caseNo++) {
				final String S = in.next();
				builder = new StringBuilder();
				int n = 0;
				int previous = -1;
				for (int i = 0; i < S.length(); i++) {
					int d = Integer.valueOf(S.substring(i, i + 1));
					if (d > previous) {
						if (previous != -1) {
							repeat(previous, n);
							n = 1;
							open(d - previous);
						} else {
							open(d);
						}
					} else if (d == previous) {
						n++;
					} else {
						repeat(previous, n);
						close(previous - d);
						n = 1;
					}

					if (previous == -1) {
						n++;
					}
					previous = d;
				}
				repeat(previous, n);
				close(previous);

				String result = builder.toString();
				System.out.println("Case #" + caseNo + ": " + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static void repeat(int d, int n) {
		for (int i = 0; i < n; i++) {
			builder.append(d);
		}
	}

	private static void close(int n) {
		for (int i = 0; i < n; i++) {
			builder.append(")");
		}
	}

	private static void open(int n) {
		for (int i = 0; i < n; i++) {
			builder.append("(");
		}
	}
}