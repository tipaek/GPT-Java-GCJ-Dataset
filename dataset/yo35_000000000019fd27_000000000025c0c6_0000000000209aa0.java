
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;
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

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] matrix = new int[N * N];
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				matrix[r * N + c] = (N + c - r) % N + 1;
			}
		}

		int remaining = K - N;
		while (remaining > 0) {
			Optional<Swap> swap = computeBestSwap(N, matrix, remaining);
			if (!swap.isPresent()) {
				return "IMPOSSIBLE";
			}
			remaining -= swap.get().delta;
			applySwap(N, matrix, swap.get());
		}

		StringBuilder sb = new StringBuilder("POSSIBLE");
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				sb.append(c == 0 ? '\n' : ' ').append(matrix[r * N + c]);
			}
		}

		return sb.toString();
	}

	private static Optional<Swap> computeBestSwap(int N, int[] matrix, int remaining) {
		int bestDelta = 0;
		Swap result = null;
		for (int index1 = 0; index1 < N; ++index1) {
			for (int index2 = index1 + 1; index2 < N; ++index2) {
				int delta = matrix[index1 * N + index2] + matrix[index2 * N + index1] - matrix[index1 * N + index1] - matrix[index2 * N + index2];
				if (delta <= bestDelta || delta > remaining) {
					continue;
				}
				bestDelta = delta;
				result = new Swap(index1, index2, delta);
			}
		}
		return Optional.ofNullable(result);
	}

	private static void applySwap(int N, int[] matrix, Swap swap) {
		for (int i = 0; i < N; ++i) {
			int tmp = matrix[i * N + swap.index1];
			matrix[i * N + swap.index1] = matrix[i * N + swap.index2];
			matrix[i * N + swap.index2] = tmp;
		}
	}

	private static class Swap {
		public int index1;
		public int index2;
		public int delta;

		public Swap(int index1, int index2, int delta) {
			this.index1 = index1;
			this.index2 = index2;
			this.delta = delta;
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
