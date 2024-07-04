
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	private static void solveTestCases(Scanner sc) {

		int testCaseCount = sc.nextInt();
		for (int i = 1; i <= testCaseCount; ++i) {
			System.out.println("Case #" + i + ": " + solveTestCase(sc));
		}
	}

	private static String solveTestCase(Scanner sc) {

		int n = sc.nextInt();
		int[] matrix = new int[n * n];
		for (int i = 0; i < n * n; ++i) {
			matrix[i] = sc.nextInt();
		}

		int trace = computeTrace(n, matrix);
		int rowCount = (int) IntStream.range(0, n).filter(r -> isRowWithRepetitions(n, matrix, r)).count();
		int columnCount = (int) IntStream.range(0, n).filter(c -> isColumnWithRepetitions(n, matrix, c)).count();

		return trace + " " + rowCount + " " + columnCount;
	}

	private static int computeTrace(int n, int[] matrix) {
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			sum += matrix[i * n + i];
		}
		return sum;
	}

	private static boolean isRowWithRepetitions(int n, int[] matrix, int r) {
		boolean[] alreadySeen = new boolean[n];
		for (int i = 0; i < n; ++i) {
			int index = matrix[r * n + i] - 1;
			if (alreadySeen[index]) {
				return true;
			}
			else {
				alreadySeen[index] = true;
			}
		}
		return false;
	}

	private static boolean isColumnWithRepetitions(int n, int[] matrix, int c) {
		boolean[] alreadySeen = new boolean[n];
		for (int i = 0; i < n; ++i) {
			int index = matrix[i * n + c] - 1;
			if (alreadySeen[index]) {
				return true;
			}
			else {
				alreadySeen[index] = true;
			}
		}
		return false;
	}

	// #####################################################################################################################
	// #####################################################################################################################
	// #####################################################################################################################
	// *** DO NOT EDIT BELOW ***
	// #####################################################################################################################
	// #####################################################################################################################
	// #####################################################################################################################

	public static String join(char[] values) {
		return join(" ", values);
	}

	public static String join(int[] values) {
		return join(" ", values);
	}

	public static String join(long[] values) {
		return join(" ", values);
	}

	public static String join(double[] values) {
		return join(" ", values);
	}

	public static <T> String join(T[] values) {
		return join(" ", values);
	}

	public static String join(Collection<?> values) {
		return join(" ", values);
	}

	public static String join(String delimiter, char[] values) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < values.length; ++i) {
			if (i != 0) sb.append(delimiter);
			sb.append(values[i]);
		}
		return sb.toString();
	}

	public static String join(String delimiter, int[] values) {
		return Arrays.stream(values).mapToObj(value -> Integer.toString(value)).collect(Collectors.joining(delimiter));
	}

	public static String join(String delimiter, long[] values) {
		return Arrays.stream(values).mapToObj(value -> Long.toString(value)).collect(Collectors.joining(delimiter));
	}

	public static String join(String delimiter, double[] values) {
		return Arrays.stream(values).mapToObj(value -> Double.toString(value)).collect(Collectors.joining(delimiter));
	}

	public static <T> String join(String delimiter, T[] values) {
		return Arrays.stream(values).map(value -> value.toString()).collect(Collectors.joining(delimiter));
	}

	public static String join(String delimiter, Collection<?> values) {
		return values.stream().map(value -> value.toString()).collect(Collectors.joining(delimiter));
	}

	public static void run(InputStream stream) {
		try {
			Scanner sc = new Scanner(new BufferedInputStream(stream));
			sc.useLocale(Locale.ROOT);
			solveTestCases(sc);
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	public static void main(String[] args) {
		run(System.in);
	}
}
