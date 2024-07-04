import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		for (int i = 0; i < t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String moves = in.next();

			int ans = 0;
			while (ans < moves.length()) {
				char move = moves.charAt(ans);
				switch (move) {
				case 'E':
					x += 1;
					break;
				case 'W':
					x -= 1;
					break;
				case 'N':
					y += 1;
					break;
				case 'S':
					y -= 1;
					break;
				}
				
				ans += 1;
				
				if (x == 0 && y == 0) break;
				
				if (Math.abs(x) >= Math.abs(y)) {
					if (x > 0) {
						x -= 1;
					} else {
						x += 1;
					}
				} else {
					if (y > 0) {
						y -= 1;
					} else {
						y += 1;
					}
				}
			}
			
			if (x == 0 && y == 0) {
				System.out.println("Case #" + (i + 1) + ": " + ans);
			} else {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			}
		}
	}
}
