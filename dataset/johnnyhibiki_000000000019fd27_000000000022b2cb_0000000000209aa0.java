import java.util.Scanner;

public class Solution {

	String fnc(int n, int k) {
		if (k % n != 0) {
			return "IMPOSSIBLE";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("POSSIBLE");
		for (int i = 0; i < n; i++) {
			sb.append(System.lineSeparator());
			for (int j = 0; j < n; j++) {
				int x = (n - 1 + i - j + k / n) % n + 1;
				sb.append(x);
				if (j != n - 1) {
					sb.append(" ");
				}
			}
		}

		return sb.toString();
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				System.out.println("Case #" + t + ": " + fnc(sc.nextInt(), sc.nextInt()));
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
