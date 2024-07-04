import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	private final int X;
	private final int Y;

	public Solution(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}

	private String solve() {
		return solve(X, Y);
	}

	private String solve(int x, int y) {
		if (x == 0 && y == 0) {
			return "";
		}
 		if (Math.abs(x % 2) == Math.abs(y % 2)) {
			return null;
		}
 		if (y == 0) {
			if (x == 1) return "E";
			if (x == -1) return "W";
		}
 		if (x == 0) {
 			if (y == 1) return "N";
 			if (y == -1) return "S";
		}


		String sol1 = null, sol2 = null;
  		if (Math.abs(x % 2) == 1) {
  			String solve = solve((x-1)/2, y/2);
  			if (solve != null) {
				sol1 = "E" + solve;
			}
  			solve = solve((x+1)/2, y/2);
  			if (solve != null) {
				sol2 = "W" + solve;
			}
		}
 		if (Math.abs(y % 2) == 1) {
			String solve = solve(x/2, (y-1)/2);
			if (solve != null) {
				sol1 = "N" + solve;
			}
			solve = solve(x/2, (y+1)/2);
			if (solve != null) {
				sol2 = "S" + solve;
			}
		}

 		if (sol1 == null && sol2 == null) {
 			return null;
		}
 		if (sol1 == null) {
			return sol2;
		}
 		if (sol2 == null) {
 			return sol1;
		}

		return sol1.length() < sol2.length() ?  sol1 : sol2;
	}

	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = scanner.nextInt();
		for (int i = 1; i <= testCases; i++) {
			System.out.print("Case #" + i + ": ");
			String solution = new Solution(scanner.nextInt(), scanner.nextInt()).solve();
			System.out.println(solution == null ? "IMPOSSIBLE" : solution);
		}
	}
}