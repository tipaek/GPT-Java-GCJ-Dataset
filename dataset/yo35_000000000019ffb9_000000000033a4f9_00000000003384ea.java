
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
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

		long L = sc.nextLong();
		long R = sc.nextLong();

		long cpt = 1;
		while (true) {
			if (L >= R) {
				if (cpt <= L) {
					L -= cpt;
				}
				else {
					break;
				}
			}
			else {
				if (cpt <= R) {
					R -= cpt;
				}
				else {
					break;
				}
			}
			++cpt;
		}

		return (cpt - 1) + " " + L + " " + R;
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
