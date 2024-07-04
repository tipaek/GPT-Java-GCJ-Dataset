
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Google Code Jam 2020 Round 2
 */
public class Solution {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in);
				 PrintStream out = System.out;) {
			int t = in.nextInt();
			for (int i = 1; i <= t; i++) {
				String solution = solveNext(in);
				out.println("Case #" + i + ": " + solution);
//				out.println(solution);
				out.flush();
			}
		}
		System.exit(0);
	}

	public static String solveNext(Scanner in) {
		long left = in.nextLong();
		long right = in.nextLong();
		return new Solution(left, right).solve();
	}

	long left;
	long right;

	public Solution(long left, long right) {
		this.left = left;
		this.right = right;
	}

	public String solve() {
		long day = 1;
		while (this.left >= day || this.right >= day) {
			if (this.left >= this.right) {
				this.left -= day;
			} else {
				this.right -= day;
			}
			day++;
		}
		day--;
		return day + " " + this.left + " " + this.right;
	}
}
