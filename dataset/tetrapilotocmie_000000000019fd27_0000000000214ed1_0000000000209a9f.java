import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* **************************** */

public class Solution {

	void solve() {
		String s = scanner.nextLine();

		StringBuilder result = new StringBuilder();

		int depth = 0;
		for (char c : s.toCharArray()) {
			int value = c - '0';

			if (value > depth) {
				result.append("(".repeat(Math.max(0, value - depth)));
			}
			else
			if (depth > value) {
				result.append(")".repeat(Math.max(0, depth - value)));
			}

			result.append(c);
			depth = value;
		}

		if (depth > 0) {
			result.append(")".repeat(depth));
		}

		System.out.println(result.toString());
	}

	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = scanner.nextInt();
		scanner.nextLine();
		for (int i = 1; i <= testCases; i++) {
			System.out.print("Case #" + i + ": ");
			new Solution().solve();
		}
	}
}