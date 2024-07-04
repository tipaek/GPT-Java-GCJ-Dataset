
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	private static void solveTestCases(Scanner sc) {

		int testCaseCount = sc.nextInt();
		for (int i = 1; i <= testCaseCount; ++i) {
			System.out.println("Case #" + i + ": " + solveTestCase(sc));
		}
	}

	private static String solveTestCase(Scanner sc) {

		int n = sc.nextInt();
		Interval[] intervals = new Interval[n];

		for (int i = 0; i < n; ++i) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			intervals[i] = new Interval(i, start, end);
		}

		Arrays.sort(intervals, Comparator.comparingInt((Interval interval) -> interval.start).thenComparingInt((Interval interval) -> interval.end));

		char[] assign = new char[n];
		int camOccupiedUntil = 0;
		int jamOccupiedUntil = 0;

		for (int i = 0; i < n; ++i) {
			Interval current = intervals[i];
			if (camOccupiedUntil <= current.start) {
				assign[current.index] = 'C';
				camOccupiedUntil = current.end;
			}
			else if (jamOccupiedUntil <= current.start) {
				assign[current.index] = 'J';
				jamOccupiedUntil = current.end;
			}
			else {
				return "IMPOSSIBLE";
			}
		}

		return join("", assign);
	}

	private static final class Interval {
		public final int index;
		public final int start;
		public final int end;

		public Interval(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}
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
