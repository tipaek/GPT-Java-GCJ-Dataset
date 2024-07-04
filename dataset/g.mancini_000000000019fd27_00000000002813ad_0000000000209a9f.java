
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
		int parenthesis = 0;

		for (char charN : input.toCharArray()) {
			int n = Integer.parseInt(String.valueOf(charN));
			int needed = n - parenthesis;
			int index = n;
			List<String> current = new ArrayList<>();
			if (needed > 0) {
				for (int i = 0; i < needed; i++) {
					current.add("(");
				}
				current.add(String.valueOf(n));
				for (int i = 0; i < needed; i++) {
					current.add(")");
				}
				index = parenthesis;
				parenthesis = n;
			} else {
				current.add(String.valueOf(n));
				parenthesis = n;
			}
			result.addAll(result.size() - index, current);
		}
		return result.stream().map(String::valueOf).collect(Collectors.joining());
	}

	private static void writeSolutionLine(long index, String output) {
		System.out.println("Case #" + index + ": " + output);
	}
}
