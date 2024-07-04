import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * cd /Users/ottsjo/dev/spec/codejam/target
 * cd classes && java Solution && cd ..
 */
class Solution {

	public static void main(String[] args) {
		Solution problem = new Solution();
		problem.solve();
	}

	// paste from here :)

	private void solve() {
		Executor.executeDefault(this::getCaseResult);
	}

	private String getCaseResult(Scanner scanner) {
		String S = scanner.nextLine();
		CharBuffer buffer = CharBuffer.allocate(10*S.length());

		char[] source = S.toCharArray();
		int maxIndex = source.length - 1;

		add(buffer, toInt(source[0]));
		for (int i = 0; i < maxIndex; i++) {
			buffer.put(source[i]);
			int diff = toInt(source[i+1])-toInt(source[i]);
			add(buffer, diff);
		}
		buffer.put(source[maxIndex]);
		add(buffer, -toInt(source[maxIndex]));

		return new String(buffer.array()).trim();
	}

	private int toInt(char c) {
		return Character.getNumericValue(c);
	}

	private void add(CharBuffer buffer, int n) {

		// duplicate buffer size if needed
		if (buffer.position() + 5 > buffer.capacity()) {
			buffer = CharBuffer.allocate(2*buffer.capacity()).put(buffer);
		}

		for (int i = 0; i < Math.abs(n); i++) {
			if (n > 0) {
				buffer.put('(');
			}
			else if (n < 0) {
				buffer.put(')');
			}
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
