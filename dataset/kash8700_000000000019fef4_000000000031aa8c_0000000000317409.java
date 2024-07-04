package codejam;

import java.util.Scanner;

import stacknqueues.next_greater;

public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = scn.nextInt();
		int tc = 0;
		while (t-- > 0) {
			tc++;

			int x = scn.nextInt();
			int y = scn.nextInt();
			String s = scn.next();
			int time = 0;
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < s.length(); i++) {
				time++;
				if (s.charAt(i) == 'S') {
					y--;
				} else if (s.charAt(i) == 'N') {
					y++;
				} else if (s.charAt(i) == 'E') {
					x++;
				} else {
					x--;
				}
				if (time >= (Math.abs(x) + Math.abs(y))) {
					ans = Math.min(ans, time);
				}

			}

			sb.append("Case #" + tc + ": " + (ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : ans)+"\n");
		}
		System.out.println(sb);

	}

}
