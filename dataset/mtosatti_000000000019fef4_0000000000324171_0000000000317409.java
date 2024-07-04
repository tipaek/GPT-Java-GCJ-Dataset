import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	static Map<Character, Integer[]> C = new HashMap<>();

	static {
		C.put('N', new Integer[] { 0, 1 });
		C.put('S', new Integer[] { 0, -1 });
		C.put('W', new Integer[] { -1, 0 });
		C.put('E', new Integer[] { 1, 0 });
	}

	public static int solve(int x, int y, String M, int moves) {
		if (x == 0 && y == 0) {
			return moves;
		}
		if (moves == M.length()) {
			return moves + 1;
		}

		x += C.get(M.charAt(moves))[0];
		y += C.get(M.charAt(moves))[1];

		if (x == 0 && y == 0) {
			return moves + 1;
		}
		
		int tx = Math.abs(x);
		int ty = Math.abs(y);
		
		if(tx == ty) {
			if(moves == M.length() - 1) return moves + 2;
			tx = Math.abs(x + C.get(M.charAt(moves))[0]);
			ty = Math.abs(y + C.get(M.charAt(moves))[1]);
		}
		
		if(tx > ty) {
			return solve(x > 0 ? x - 1 : x + 1, y, M, moves + 1);
		} else {
			return solve(x, y > 0 ? y - 1 : y + 1, M, moves + 1);
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int x = in.nextInt();
			int y = in.nextInt();
			String M = in.next();

			int count = solve(x, y, M, 0);

			System.out.print("Case #" + t + ": ");
			if (count <= M.length()) {
				System.out.println(count);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}

}
