
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Code Jam 2020 Round 1C
 */
public class Solution {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in);
				 PrintStream out = System.out;) {
			int t = in.nextInt();
			for (int i = 1; i <= t; i++) {
				String solution = solveNext(in);
				out.println("Case #" + i + ": " + solution);
				out.flush();
			}
		}
		System.exit(0);
	}

	public static String solveNext(Scanner in) {
		int x = in.nextInt();
		int y = in.nextInt();
		String path = in.next();
		return new Solution(x, y, path).solve();
	}

	int x;
	int y;
	String path;

	public Solution(int x, int y, String path) {
		this.x = x;
		this.y = y;
		this.path = path;
	}

	public String solve() {
		int currX = this.x;
		int currY = this.y;
		for (int i = 0; i < this.path.length(); i++) {
			char curr = this.path.charAt(i);
			switch (curr) {
				case 'N':
					currY++;
					break;
				case 'S':
					currY--;
					break;
				case 'W':
					currX--;
					break;
				case 'E':
					currX++;
					break;
			}

			int dist = Math.abs(currX) + Math.abs(currY);
			if (dist <= (i + 1)) {
				return Integer.toString(i + 1);
			}
		}

		return "IMPOSSIBLE";
	}
}
