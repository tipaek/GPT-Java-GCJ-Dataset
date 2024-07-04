import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
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

	public static void main(String[] args) {
		Solution problem = new Solution();
		problem.solve();
	}

	/*

5
2 3
-2 -3
3 0
-1 1
15 0

	 */

	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	private void solve() {
		Executor.executeDefault(this::getCaseResult);
	}

	private static final Integer[] POWERS = new Integer[] {1, 2,	4,	8,	16,	32,	64,	128,	256,	512,	1024,	2048,	4096,	8192,	16384,	32768,	65536,	131072,	262144,	524288,	1048576,	2097152,4194304,8388608,16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824};

	private String getCaseResult(Scanner scanner) {
		int[] goal = ScannerExtensions.getIntArray(scanner);
		Position position = new Position(goal[0], goal[1]);
		StringBuilder inversePath = new StringBuilder();

		for (int max = 0; max < POWERS.length; max++) {
			String solution = solveForMaxIndex(position, inversePath, max);
			if (!IMPOSSIBLE.equals(solution)) {
				return solution;
			}
			// reset
			position = new Position(goal[0], goal[1]);
			inversePath = new StringBuilder();
		}
		return IMPOSSIBLE;
	}

	private String solveForMaxIndex(Position position, StringBuilder inversePath, int maxIndex) {
		for (int i = maxIndex; i >= 0; i--) {

			Integer nextStep = POWERS[i];
			if (nextStep - Math.abs(position.x) <  Math.abs(position.x)) {
				if (position.x < 0) {
					inversePath.append(position.moveRight(nextStep));
				}
				else {
					inversePath.append(position.moveLeft(nextStep));
				}
			}
			else if (nextStep - Math.abs(position.y) <  Math.abs(position.y)) {
				if (position.y < 0) {
					inversePath.append(position.moveUp(nextStep));
				}
				else {
					inversePath.append(position.moveDown(nextStep));
				}
			}
			else return IMPOSSIBLE;
		}

		if (position.isDone()) {
			return inversePath.reverse().toString();
		}
		return IMPOSSIBLE;
	}

	private int getMaxIndex(Position position) {
		int max = Math.max(Math.abs(position.x), Math.abs(position.y));
		for (int i = POWERS.length-1; i >= 0; i--) {
			if (max > POWERS[i]/2) {
				return i;
			}
		}
		return -1;
	}

	private static class Position {
		private int x;
		private int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		private boolean isDone() {
			return x == 0 && y == 0;
		}


		// inverse moves

		private char moveUp(int length) {
			y+=length;
			return 'S';
		}

		private char moveDown(int length) {
			y-=length;
			return 'N';
		}

		private char moveRight(int length) {
			x+=length;
			return 'W';
		}

		private char moveLeft(int length) {
			x-=length;
			return 'E';
		}

		@Override
		public String toString() {
			return x + " " + y;
		}
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
