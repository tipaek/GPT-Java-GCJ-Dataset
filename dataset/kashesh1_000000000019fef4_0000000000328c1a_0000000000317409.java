

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

	private void canMeet(int x, int y, String m, int caseNo) {
		int cnt = 0;
		int myX = 0, myY = 0;

		for (char ch : m.toCharArray()) {
			cnt++;
			switch (ch) {
			case 'N':
				y++;
				break;
			case 'S':
				y--;
				break;
			case 'E':
				x++;
				break;
			case 'W':
				x--;
				break;
			}

			if (Math.abs(y) >= Math.abs(x)) {
				if (y >= 0)
					myY++;
				else
					myY--;
			} else {
				if (x >= 0)
					myX++;
				else
					myX--;
			}

			if (x == myX && y == myY) {
				System.out.println("Case #" + caseNo + ": " + cnt);
				return;
			}
		}
		System.out.println("Case #" + caseNo + ": " + "IMPOSSIBLE");
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int X = in.nextInt();
			int Y = in.nextInt();
			String M = in.next();
			obj.canMeet(X, Y, M, i);

		}
	}
}
