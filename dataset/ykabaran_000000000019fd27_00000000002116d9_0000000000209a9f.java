
import java.util.Scanner;

/**
 * Google CodeJam 2020 Quals
 */
public class Solution {

	private final String str;

	public Solution(Scanner scanner) {
		this.str = scanner.next();
	}

	public String solve() {
		StringBuilder sb = new StringBuilder();
		int curr = 0;
		for (int i = 0; i < this.str.length(); i++) {
			int val = Integer.parseInt(this.str.substring(i, i + 1));
			while (curr < val) {
				sb.append("(");
				curr++;
			}
			while (curr > val) {
				sb.append(")");
				curr--;
			}
			sb.append(Integer.toString(val));
		}
		while (curr > 0) {
			sb.append(")");
			curr--;
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in);) {
			int T = scanner.nextInt();
			for (int i = 1; i <= T; i++) {
				String solution = new Solution(scanner).solve();
				System.out.println("Case #" + i + ": " + solution);
			}
		}
		System.exit(0);
	}

}
