
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	private static void solveTestCases(Scanner sc) {

		String header = sc.nextLine();
		String[] fields = header.trim().split(" ");

		int testCaseCount = Integer.parseInt(fields[0]);

		long N = 1_000_000_000;
		long A = Long.parseLong(fields[1]);
		long B = Long.parseLong(fields[2]);

		for (int i = 0; i < testCaseCount; ++i) {
			runTestCase(N, A, B, sc);
		}
	}

	private static void runTestCase(long N, long A, long B, Scanner sc) {

		// if (A != B) {
		// throw new Error("Cannot work with test set 3");
		// }
		// long R = A;

		try {
			Pt pt0 = findDartBoard(N, A, sc);
			long x0 = pt0.x;
			long y0 = pt0.y;

			long leftEdge = findLeftEdge(N, x0, y0, sc);
			long rightEdge = findRightEdge(N, x0, y0, sc);
			long xF = (leftEdge + rightEdge) / 2;

			long topEdge = findTopEdge(N, xF, y0, sc);
			long bottomEdge = findBottomEdge(N, xF, y0, sc);
			long yF = (topEdge + bottomEdge) / 2;

			sendDart(xF, yF, sc);
			throw new Error("Center should be at x=" + xF + " yF=" + yF + " but it's not...");
		}
		catch (EndOfTestCase e) {}
	}

	private static Pt findDartBoard(long N, long A, Scanner sc) throws EndOfTestCase {
		for (long x = -N + A; x <= N; x += A) {
			for (long y = -N + A; y <= N; y += A) {
				if (sendDart(x, y, sc)) {
					return new Pt(x, y);
				}
			}
		}
		throw new Error("Dartboard is nowhere...");
	}

	private static long findLeftEdge(long N, long x0, long y0, Scanner sc) throws EndOfTestCase {
		long r = -N - 1;
		long s = x0;

		while (s - r >= 2) {
			long mid = (s + r) / 2;
			if (sendDart(mid, y0, sc)) {
				s = mid;
			}
			else {
				r = mid;
			}
		}
		return s;
	}

	private static long findRightEdge(long N, long x0, long y0, Scanner sc) throws EndOfTestCase {
		long r = x0;
		long s = N + 1;

		while (s - r >= 2) {
			long mid = (s + r) / 2;
			if (sendDart(mid, y0, sc)) {
				r = mid;
			}
			else {
				s = mid;
			}
		}
		return r;
	}

	private static long findTopEdge(long N, long x0, long y0, Scanner sc) throws EndOfTestCase {
		long r = -N - 1;
		long s = y0;

		while (s - r >= 2) {
			long mid = (s + r) / 2;
			if (sendDart(x0, mid, sc)) {
				s = mid;
			}
			else {
				r = mid;
			}
		}
		return s;
	}

	private static long findBottomEdge(long N, long x0, long y0, Scanner sc) throws EndOfTestCase {
		long r = y0;
		long s = N + 1;

		while (s - r >= 2) {
			long mid = (s + r) / 2;
			if (sendDart(x0, mid, sc)) {
				r = mid;
			}
			else {
				s = mid;
			}
		}
		return r;
	}

	private static boolean sendDart(long x, long y, Scanner sc) throws EndOfTestCase {
		System.out.println(x + " " + y);
		System.out.flush();

		String line = sc.nextLine().trim();
		if ("CENTER".equals(line)) {
			throw new EndOfTestCase();
		}
		else if ("HIT".equals(line)) {
			return true;
		}
		else if ("MISS".equals(line)) {
			return false;
		}
		else {
			throw new Error("Invalid response: " + line);
		}
	}

	@SuppressWarnings("serial")
	private static class EndOfTestCase extends Exception {
		public EndOfTestCase() {}
	}

	private static class Pt {
		final long x;
		final long y;

		public Pt(long x, long y) {
			this.x = x;
			this.y = y;
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
