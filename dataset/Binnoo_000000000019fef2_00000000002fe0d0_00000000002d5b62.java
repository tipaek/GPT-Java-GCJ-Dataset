
import java.util.Scanner;

public class Solution {

	int t;
	Scanner s;
	int x;
	int y;
	String directionsStrings[] = { "N", "S", "E", "W" };
	int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	String bestSolution = "";
	boolean foundSolution = false;

	public Solution(int t, Scanner s) {
		super();
		this.t = t;
		this.s = s;
	}

	public void solve() {
		// read input and solve
		x = s.nextInt();
		y = s.nextInt();
		if (x % 2 == 1 && y % 2 == 1) {
			System.out.println("Case #" + t + ": IMPOSSIBLE");
			return;
		}

		StringBuilder solution = new StringBuilder();
		solveRecursive(solution, 0, 0, 0);
		if (!foundSolution) {
			bestSolution = "IMPOSSIBLE";
		}

		System.out.println("Case #" + t + ": " + bestSolution);
	}

	private void solveRecursive(StringBuilder solution, int x_i, int y_i, int i) {
		if (i == 9) {
			return;
		}
		//System.out.println(x_i+" "+y_i+" "+i);
		if ((x_i == x) && (y_i == y)) {
			if (solution.length() < bestSolution.length() || !foundSolution) {
				bestSolution = solution.toString();
				foundSolution = true;
			}
			return;
		}

		for (int d = 0; d < 4; d++) {
			x_i += directions[d][0] * (1 << i);
			y_i += directions[d][1] * (1 << i);
			solution.append(directionsStrings[d]);
			solveRecursive(solution, x_i, y_i, i + 1);
			solution.setLength(solution.length() - 1);
			x_i -= directions[d][0] * (1 << i);
			y_i -= directions[d][1] * (1 << i);
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for (int i = 0; i < testCases; i++) {
			new Solution(i + 1, s).solve();
		}

		s.close();
	}

}
