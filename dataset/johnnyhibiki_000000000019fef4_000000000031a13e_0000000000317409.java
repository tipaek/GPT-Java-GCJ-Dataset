import java.util.Scanner;

public class Solution {

	String fnc(int x, int y, String m) {
		int px = 0;
		int py = 0;
		String ans = "IMPOSSIBLE";
		for (int i = 0; i < m.length(); i++) {
			int d = Math.abs(x - px) + Math.abs(y - py);
			if (i >= d) {
				ans = "" + i;
				break;
			}

			char c = m.charAt(i);

			if (c == 'N') {
				py--;
			} else if (c == 'E') {
				px--;
			} else if (c == 'S') {
				py++;
			} else if (c == 'W') {
				px++;
			}
		}

		if (ans.equals("IMPOSSIBLE")) {
			int d = Math.abs(x - px) + Math.abs(y - py);
			if (m.length() >= d) {
				ans = "" + m.length();
			}
		}

		return ans;
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				String m = sc.next();
				System.out.println("Case #" + t + ": " + fnc(x, y, m));
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
