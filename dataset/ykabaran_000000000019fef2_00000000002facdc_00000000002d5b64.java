
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Code Jam 2020 Round 1B
 */
public class Solution {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in);
				 PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));) {
			int t = in.nextInt();
			for (int i = 1; i <= t; i++) {
				String solution = solveNext(in);
				out.println("Case #" + i + ": " + solution);
			}
			out.flush();
		}
		System.exit(0);
	}

	public static String solveNext(Scanner in) {
		int ranks = in.nextInt();
		int suits = in.nextInt();
		return new Solution(ranks, suits).solve();
	}

	final int ranks;
	final int suits;

	public Solution(int ranks, int suits) {
		this.ranks = ranks;
		this.suits = suits;
	}

	public String solve() {
		int numMoves = (this.ranks - 1) * (this.suits - 1);

		StringBuilder sb = new StringBuilder();
		sb.append(numMoves);

		int currRank = this.ranks;
		int currProgress = 0;
		for (int i = 0; i < numMoves; i++) {
			sb.append("\n");
			int b = currRank - 1;
			int a = (currRank * this.suits) - (1 + currProgress + b);
			sb.append(a).append(" ").append(b);
			currProgress++;
			if (currProgress == this.suits - 1) {
				currProgress = 0;
				currRank--;
			}
		}
		return sb.toString();
	}

}
