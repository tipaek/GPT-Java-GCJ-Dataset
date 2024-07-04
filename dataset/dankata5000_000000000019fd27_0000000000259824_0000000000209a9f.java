import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.run();
	}

	void run() {
		try (Scanner scanner = new Scanner(System.in)) {
			final int T = scanner.nextInt();
			scanner.nextLine();

			for (int t = 1; t <= T; t++) {
				String s = scanner.nextLine();
				String result = doIt(s);
				System.out.println("Case #" + t + ": " + result);
			}
		}
	}

	String doIt(String s) {
		StringBuilder result = new StringBuilder();
		int opened = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			String d = String.valueOf(c);
			int n = Integer.parseInt(d);
			int toOpen = Math.max(n - opened, 0);
			int toClose = Math.max(opened - n, 0);
			for (int j = 0; j < toOpen; j++) {
				result.append("(");
			}
			for (int j = 0; j < toClose; j++) {
				result.append(")");
			}
			result.append(c);
			opened = n;
		}

		for (int j = 0; j < opened; j++) {
			result.append(")");
		}

		return result.toString();
	}
}
