
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

		long b0;
		if (L >= R) {
			b0 = computeInit(L - R);
			L -= computeS(1, b0);
		}
		else {
			b0 = computeInit(R - L);
			R -= computeS(1, b0);
		}

		b0++;

		long cptMax;
		if (L >= R) {
			if (b0 % 2 == 0) {
				long bMaxOnL = computeEvenThreshold(L, b0 / 2);
				long bMaxOnR = computeOddThreshold(R, b0 / 2);
				if (bMaxOnL > bMaxOnR) {
					bMaxOnL = bMaxOnR + 1;
					cptMax = bMaxOnL * 2;
				}
				else if (bMaxOnL < bMaxOnR) {
					bMaxOnR = bMaxOnL;
					cptMax = bMaxOnR * 2 + 1;
				}
				else { // bMaxOnL == bMaxOnR
					cptMax = bMaxOnR * 2 + 1;
				}
				L -= computeSumEven(b0 / 2, bMaxOnL);
				R -= computeSumOdd(b0 / 2, bMaxOnR);
			}
			else {
				long bMaxOnL = computeOddThreshold(L, b0 / 2);
				long bMaxOnR = computeEvenThreshold(R, b0 / 2 + 1);
				if (bMaxOnL > bMaxOnR) {
					bMaxOnL = bMaxOnR;
					cptMax = bMaxOnL * 2 + 1;
				}
				else if (bMaxOnL < bMaxOnR) {
					bMaxOnR = bMaxOnL + 1;
					cptMax = bMaxOnR * 2;
				}
				else { // bMaxOnL == bMaxOnR
					cptMax = bMaxOnL * 2 + 1;
				}
				L -= computeSumOdd(b0 / 2, bMaxOnL);
				R -= computeSumEven(b0 / 2 + 1, bMaxOnR);
			}
		}

		else {
			if (b0 % 2 == 0) {
				long bMaxOnL = computeEvenThreshold(R, b0 / 2);
				long bMaxOnR = computeOddThreshold(L, b0 / 2);
				if (bMaxOnL > bMaxOnR) {
					bMaxOnL = bMaxOnR + 1;
					cptMax = bMaxOnL * 2;
				}
				else if (bMaxOnL < bMaxOnR) {
					bMaxOnR = bMaxOnL;
					cptMax = bMaxOnR * 2 + 1;
				}
				else { // bMaxOnL == bMaxOnR
					cptMax = bMaxOnR * 2 + 1;
				}
				R -= computeSumEven(b0 / 2, bMaxOnL);
				L -= computeSumOdd(b0 / 2, bMaxOnR);
			}
			else {
				long bMaxOnL = computeOddThreshold(R, b0 / 2);
				long bMaxOnR = computeEvenThreshold(L, b0 / 2 + 1);
				if (bMaxOnL > bMaxOnR) {
					bMaxOnL = bMaxOnR;
					cptMax = bMaxOnL * 2 + 1;
				}
				else if (bMaxOnL < bMaxOnR) {
					bMaxOnR = bMaxOnL + 1;
					cptMax = bMaxOnR * 2;
				}
				else { // bMaxOnL == bMaxOnR
					cptMax = bMaxOnL * 2 + 1;
				}
				R -= computeSumOdd(b0 / 2, bMaxOnL);
				L -= computeSumEven(b0 / 2 + 1, bMaxOnR);
			}
		}

		return cptMax + " " + L + " " + R;
	}

	private static long computeEvenThreshold(long delta, long a) {
		return (long) Math.floor(Math.sqrt(a * a - a + delta + 1 / 4d) - 1 / 2d);
	}

	private static long computeOddThreshold(long delta, long a) {
		return (long) Math.floor(Math.sqrt(a * a + delta) - 1);
	}

	private static long computeInit(long delta) {
		return (long) Math.floor(Math.sqrt(2 * delta + 1 / 4d) - 1 / 2d);
	}

	private static long computeSumEven(long a, long b) {
		return computeS(a, b) * 2;
	}

	private static long computeSumOdd(long a, long b) {
		return computeS(a, b) * 2 + (b - a + 1);
	}

	private static long computeS(long a, long b) {
		return (a + b) * (b - a + 1) / 2;
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
