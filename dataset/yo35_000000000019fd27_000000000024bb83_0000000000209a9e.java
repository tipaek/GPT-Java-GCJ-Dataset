
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

		String line = sc.nextLine();
		String[] fields = line.split(" ");
		int testCaseCount = Integer.parseInt(fields[0]);
		int b = Integer.parseInt(fields[1]);
		for (int i = 1; i <= testCaseCount; ++i) {
			solveTestCase(sc, b);
		}
	}

	private static void solveTestCase(Scanner sc, int b) {

		int[] values = new int[b];

		int validUntil = 0;
		int identicalPairPosition = -1;
		int oppositePairPosition = -1;
		int queryCount = 0;

		while (validUntil < (b + 1) / 2) {

			// Resolve quantum fluctuations
			if (validUntil > 0 && queryCount % 10 == 0) {
				if (identicalPairPosition >= 0 && oppositePairPosition >= 0) {
					int v1 = query(sc, identicalPairPosition);
					int v2 = query(sc, oppositePairPosition);
					queryCount += 2;
					if (v1 == values[identicalPairPosition]) {
						if (v2 == values[oppositePairPosition]) {
							// nothing to do
						}
						else {
							swap(b, values, validUntil);
						}
					}
					else {
						if (v2 == values[oppositePairPosition]) {
							swap(b, values, validUntil);
							inverse(b, values, validUntil);
						}
						else {
							inverse(b, values, validUntil);
						}
					}
				}
				else {
					int indexResolver = Math.max(identicalPairPosition, oppositePairPosition);
					int v = query(sc, indexResolver);
					query(sc, 0);
					queryCount += 2;
					if (v != values[indexResolver]) {
						inverse(b, values, validUntil);
					}
				}
			}

			// Get data
			else {
				values[validUntil] = query(sc, validUntil);
				values[b - 1 - validUntil] = query(sc, b - 1 - validUntil);
				if (identicalPairPosition == -1 && values[validUntil] == values[b - 1 - validUntil]) {
					identicalPairPosition = validUntil;
				}
				if (oppositePairPosition == -1 && values[validUntil] != values[b - 1 - validUntil]) {
					oppositePairPosition = validUntil;
				}
				validUntil++;
				queryCount += 2;
			}

		}

		System.out.println(join("", values));
		System.out.flush();

		String line = sc.nextLine();
		if (!"Y".equals(line)) {
			throw new Error("Solution answer: " + line);
		}
	}

	private static void swap(int b, int[] values, int limit) {
		IntStream.range(0, limit).forEach(index -> {
			int tmp = values[index];
			values[index] = values[b - 1 - index];
			values[b - 1 - index] = tmp;
		});
	}

	private static void inverse(int b, int[] values, int limit) {
		IntStream.range(0, limit).forEach(index -> {
			values[index] = 1 - values[index];
			values[b - 1 - index] = 1 - values[b - 1 - index];
		});
	}

	private static int query(Scanner sc, int index) {
		System.out.println(index + 1);
		System.out.flush();

		String line = sc.nextLine();
		if ("0".equals(line)) {
			return 0;
		}
		else if ("1".equals(line)) {
			return 1;
		}
		else {
			throw new Error("Query answer: " + line);
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
