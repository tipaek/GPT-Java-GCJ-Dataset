
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Google Code Jam 2020 Round 1A
 */
public class Solution {

	final int n;

	public Solution(Scanner scanner) {
		this.n = scanner.nextInt();
	}

	public String solve() {
		String binary = Integer.toBinaryString(this.n);
		int length = binary.length();
		int oneCount = 0;
		for (int i = 0; i < length; i++) {
			if (binary.charAt(i) == '1') {
				oneCount++;
			}
		}

		int maxSkip = oneCount;
		if (this.n % 2 == 1) {
			maxSkip--;
		}

		boolean skipLastRowThing = false;
		int extraNeeded = 0;
		int skipNeeded = length - oneCount;
		if (skipNeeded > maxSkip) {
			skipLastRowThing = true;
			extraNeeded = length - skipNeeded;
			skipNeeded = 0;
		}

		ArrayList<Integer[]> steps = new ArrayList<>();
		int row = length;
		int lastMax = skipLastRowThing ? row - 2 : row;
		for (int i = lastMax; i > 1; i--) {
			steps.add(new Integer[]{row, i});
		}
		if (skipNeeded == 0) {
			steps.add(new Integer[]{row, 1});
		} else {
			skipNeeded--;
		}
		int direction = 1;
		for (int i = 1; i < length; i++) {
			row--;
			if (binary.charAt(i) != '1') {
				if (extraNeeded > 0 && extraNeeded == row - 1) {
					if (direction > 0) {
						steps.add(new Integer[]{row, 1});
						steps.add(new Integer[]{row, 2});
					} else {
						steps.add(new Integer[]{row, row});
						steps.add(new Integer[]{row, row - 1});
					}
					extraNeeded = 0;
				} else {
					steps.add(new Integer[]{row, direction > 0 ? 1 : row});
				}
				continue;
			}
			if (direction == 1) {
				for (int k = 1; k < row; k++) {
					steps.add(new Integer[]{row, k});
				}
				if (skipNeeded == 0) {
					steps.add(new Integer[]{row, row});
				} else {
					skipNeeded--;
				}
				direction = -1;
			} else {
				for (int k = row; k > 1; k--) {
					steps.add(new Integer[]{row, k});
				}
				if (skipNeeded == 0) {
					steps.add(new Integer[]{row, 1});
				} else {
					skipNeeded--;
				}
				direction = 1;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = steps.size() - 1;
						i >= 0; i--) {
			Integer[] step = steps.get(i);
			sb.append("\n").append(step[0]).append(" ").append(step[1]);
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
