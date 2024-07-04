//package codejam.Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Sample {
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(in.readLine());
		for (int x = 1; x <= t; x++) {
			System.out.print("Case #" + x + ": ");
			solve();
			System.out.println();
		}
	}

	public static void solve() throws IOException {
		String[] s = in.readLine().split(" ");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);
		String m = s[2];
		int time = 0;
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < m.length(); i++) {
			char ch = m.charAt(i);
			if (ch == 'N') y++;
			else if (ch == 'S') y--;
			else if (ch == 'E') x++;
			else if (ch == 'W') x--;
			time++;

			if (Math.abs(x) + Math.abs(y) <= time) {
				ans = Math.min(time, ans);
			}
		}

		System.out.print(ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans);
	}
}
