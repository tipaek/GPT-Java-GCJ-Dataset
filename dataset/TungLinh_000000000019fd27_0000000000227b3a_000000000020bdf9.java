import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private static final int MAX_TIME = 24 * 60 + 1;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			solve(i, n, in);
		}
		in.close();
		return;
	}

	private static void solve(int testCase, int n, Scanner in) {

		int[] Cameron = new int[MAX_TIME];
		int[] Jamie = new int[MAX_TIME];

		Arrays.fill(Cameron, 0);
		Arrays.fill(Jamie, 0);

		StringBuilder schedule = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int start = in.nextInt();
			int end = in.nextInt();

			if (Cameron[start] == 0) {
				Arrays.fill(Cameron, start, end, 1);
				schedule.append("C");
			} else if (Jamie[start] == 0) {
				Arrays.fill(Jamie, start, end, 1);
				schedule.append("J");
			} else {
				System.out.println("Case #" + testCase + ": IMPOSSIBLE");
				return;
			}
		}
		System.out.println("Case #" + testCase + ": " + schedule.toString());
	}
}