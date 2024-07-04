
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		solve(Solution::solveNestingDepthLine);
		System.exit(0);
	}

	private static void solve(Function<Scanner, String> solveLine) {
		Scanner in = new Scanner(System.in);
		long testCases = in.nextLong();

		for (int i = 0; i < testCases; i++) {
			writeSolutionLine(i + 1, solveLine.apply(in));
		}
	}

	private static String solveNestingDepthLine(Scanner in) {
		String input = in.next();
		List<String> result = new ArrayList<>();
		int prev = -1;

		for (char charN : input.toCharArray()) {
			int n = Integer.parseInt(String.valueOf(charN));
			if (n == 0 || n > prev || prev == -1) {
				int lastIndex = result.size();
				for (int i = 0; i < n; i++) {
					result.add(lastIndex + i, "(");
				}
				result.add(String.valueOf(n));				
				for (int i = 0; i < n; i++) {
					result.add(result.size(), ")");
				}
			} else {
				result.add(result.size() - n, String.valueOf(n));
			}
			prev = n;
		}
		return result.stream().map(String::valueOf).collect(Collectors.joining());
	}

	private static void writeSolutionLine(long index, String output) {
		System.out.println("Case #" + index + ": " + output);
	}
}
