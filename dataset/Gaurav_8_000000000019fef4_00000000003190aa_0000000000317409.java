

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt(), testCase = 1;
		while(testCase <= t) {
			int x = s.nextInt(), y = s.nextInt();
			String str = s.next();
			int ans = -1;
			if(Math.abs(x) + Math.abs(y) == 0) {
				ans = 0;
			}
			for(int i = 0; i < str.length() && ans == -1; i++) {
				if(str.charAt(i) == 'N') {
					y++;
				} else if(str.charAt(i) == 'S') {
					y--;
				} else if(str.charAt(i) == 'E') {
					x++;
				} else {
					x--;
				}
				if(Math.abs(x) + Math.abs(y) <= i + 1) {
					ans = i + 1;
					break;
				}
			}
			System.out.println("Case #" + testCase++ + ": " + (ans == -1 ? "IMPOSSIBLE" : ans));
		}
	}

}
