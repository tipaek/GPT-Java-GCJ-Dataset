import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		for (int i = 0; i < t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String moves = in.next();

			HashMap<Character, Integer> myMoves = new HashMap<>();

			int ans = 0;
			while (ans < moves.length()) {
				boolean twice = false;
				char move = moves.charAt(ans);
				if (myMoves.getOrDefault(move, 0) > 0) {
					myMoves.put(move, myMoves.get(move) - 1);
					twice = true;
				}
				if (!twice) {
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
				}

				ans += 1;

				if (x == 0 && y == 0)
					break;

				if (Math.abs(x) >= Math.abs(y)) {
					if (x > 0) {
						x -= 1;
						myMoves.put('W', myMoves.getOrDefault('W', 0) + 1);
					} else {
						x += 1;
						myMoves.put('E', myMoves.getOrDefault('E', 0) + 1);
					}
				} else {
					if (y > 0) {
						y -= 1;
						myMoves.put('S', myMoves.getOrDefault('S', 0) + 1);
					} else {
						y += 1;
						myMoves.put('N', myMoves.getOrDefault('N', 0) + 1);
					}
				}
				
				if (x == 0 && y == 0)
					break;
				
				if (twice) {
					if (Math.abs(x) >= Math.abs(y)) {
						if (x > 0) {
							x -= 1;
							myMoves.put('W', myMoves.getOrDefault('W', 0) + 1);
						} else {
							x += 1;
							myMoves.put('E', myMoves.getOrDefault('E', 0) + 1);
						}
					} else {
						if (y > 0) {
							y -= 1;
							myMoves.put('S', myMoves.getOrDefault('S', 0) + 1);
						} else {
							y += 1;
							myMoves.put('N', myMoves.getOrDefault('N', 0) + 1);
						}
					}
				}
				
				if (x == 0 && y == 0)
					break;
			}

			if (x == 0 && y == 0) {
				System.out.println("Case #" + (i + 1) + ": " + ans);
			} else {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			}
		}
	}
}