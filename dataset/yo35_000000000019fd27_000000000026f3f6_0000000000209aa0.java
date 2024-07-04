
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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

		Optional<String> result = compute(N, matrix, K - N, 0);
		return result.orElse("IMPOSSIBLE");
	}

	private static String formatPositiveResult(int N, int[] matrix) {
		StringBuilder sb = new StringBuilder("POSSIBLE");
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				sb.append(c == 0 ? '\n' : ' ').append(matrix[r * N + c]);
			}
		}
		return sb.toString();
	}

	private static Optional<String> compute(int N, int[] matrix, int remaining, int pivotIndex) {

		if (remaining == 0) {
			return Optional.of(formatPositiveResult(N, matrix));
		}
		else if (pivotIndex >= N) {
			return Optional.empty();
		}

		Collection<Optional<SquareSwap>> allSquareSwapsAndIdentity = computeAllSquareSwapsAndIdentity(N, matrix);
		for (Optional<SquareSwap> squareSwap : allSquareSwapsAndIdentity) {
			int[] matrixCopy = matrix.clone();
			squareSwap.ifPresent(swap -> applySquareSwap(N, matrixCopy, swap));

			Collection<Optional<ColumnSwap>> allColumnSwapsAndIdentity = computeAllColumnSwapsAndIdentity(N, matrix, pivotIndex);
			for (Optional<ColumnSwap> columnSwap : allColumnSwapsAndIdentity) {
				int[] matrixCopyCopy = matrixCopy.clone();
				columnSwap.ifPresent(swap -> applyColumnSwap(N, matrixCopyCopy, swap));

				Optional<String> result = compute(N, matrixCopyCopy, remaining - columnSwap.map(swap -> swap.delta).orElse(0), pivotIndex + 1);
				if (result.isPresent()) {
					return result;
				}
			}
		}

		return Optional.empty();
	}

	private static Collection<Optional<ColumnSwap>> computeAllColumnSwapsAndIdentity(int N, int[] matrix, int pivotIndex) {
		List<Optional<ColumnSwap>> swaps = new ArrayList<>();
		swaps.add(Optional.empty()); // identity
		for (int otherIndex = pivotIndex + 1; otherIndex < N; ++otherIndex) {
			int delta = matrix[pivotIndex * N + otherIndex] + matrix[otherIndex * N + pivotIndex] - matrix[pivotIndex * N + pivotIndex] - matrix[otherIndex * N + otherIndex];
			swaps.add(Optional.of(new ColumnSwap(pivotIndex, otherIndex, delta)));
		}
		return swaps;
	}

	private static Collection<Optional<SquareSwap>> computeAllSquareSwapsAndIdentity(int N, int[] matrix) {
		List<Optional<SquareSwap>> swaps = new ArrayList<>();
		swaps.add(Optional.empty()); // identity
		for (int index1 = 0; index1 < N; ++index1) {
			for (int index2 = index1 + 1; index2 < N; ++index2) {
				if (matrix[index1 * N + index1] != matrix[index2 * N + index2] || matrix[index1 * N + index2] != matrix[index2 * N + index1]) {
					continue;
				}
				swaps.add(Optional.of(new SquareSwap(index1, index2)));
			}
		}
		return swaps;
	}

	private static void applyColumnSwap(int N, int[] matrix, ColumnSwap swap) {
		for (int i = 0; i < N; ++i) {
			int tmp = matrix[i * N + swap.index1];
			matrix[i * N + swap.index1] = matrix[i * N + swap.index2];
			matrix[i * N + swap.index2] = tmp;
		}
	}

	private static void applySquareSwap(int N, int[] matrix, SquareSwap swap) {
		for (int i = 0; i < N; ++i) {
			if (i == swap.index1 || i == swap.index2) {
				continue;
			}
			int tmp = matrix[i * N + swap.index1];
			matrix[i * N + swap.index1] = matrix[i * N + swap.index2];
			matrix[i * N + swap.index2] = tmp;
		}
	}

	private static class ColumnSwap {
		public final int index1;
		public final int index2;
		public final int delta;

		public ColumnSwap(int index1, int index2, int delta) {
			this.index1 = index1;
			this.index2 = index2;
			this.delta = delta;
		}
	}

	private static class SquareSwap {
		public final int index1;
		public final int index2;

		public SquareSwap(int index1, int index2) {
			this.index1 = index1;
			this.index2 = index2;
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
