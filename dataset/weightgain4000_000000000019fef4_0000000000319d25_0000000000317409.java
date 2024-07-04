import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * cd /Users/ottsjo/dev/spec/codejam/target
 * cd classes && java Solution && cd ..
 *
 * python interactive_runner.py python testing_tool_XX.py 0 -- java Solution
 */
class Solution {

	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {
		Solution problem = new Solution();
		problem.solve();
	}

	// paste from here :)
	private void solve() {
		Executor.executeDefault(this::getCaseResult);
	}

	private String getCaseResult(Scanner scanner) {
		String data = scanner.nextLine();

		String[] split = data.split(" ");
		// X and Y, and a string of characters M
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		char[] path = split[2].toCharArray();

		int numberOfSteps = 0;
		int distance = Math.abs(x) + Math.abs(y);

		if (distance <= numberOfSteps) {
			return String.valueOf(numberOfSteps);
		}

		for (char c : path) {
			numberOfSteps++;
			switch (c) {
				case 'N': y++;
				case 'S': y--;
				case 'E': x++;
				case 'W': x--;
			}
			distance = Math.abs(x) + Math.abs(y);
			if (distance <= numberOfSteps) {
				return String.valueOf(numberOfSteps);
			}
		}

		return "IMPOSSIBLE";
	}

	private static class Executor {

		static void executeDefault(Function<Scanner, String> getCaseResult) {
			Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			execute(input, getCaseResult, System.out::println);
		}

		private static void execute(Scanner reader, Function<Scanner, String> getCaseResult, Consumer<String> resultConsumer) {
			int numberOfCases = ScannerExtensions.getInt(reader);
			for (int i = 0; i < numberOfCases; i++) {
				String result = getCaseResult.apply(reader);
				String caseString = createCaseString(i+1, result);
				resultConsumer.accept(caseString);
			}
		}

		static String createCaseString(long caseNumber, String result) {
			return "Case #" + caseNumber + ": " + result;
		}
	}

	private static class ScannerExtensions {

		private ScannerExtensions() {}

		static int getInt(Scanner scanner) {
			return Integer.parseInt(scanner.nextLine());
		}

		static long getLong(Scanner scanner) {
			return Long.parseLong(scanner.nextLine());
		}

		static double getDouble(Scanner scanner) {
			return Double.parseDouble(scanner.nextLine());
		}

		static int[] getIntArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		static long[] getLongArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
		}

		static double[] getDoubleArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		}
	}
}
