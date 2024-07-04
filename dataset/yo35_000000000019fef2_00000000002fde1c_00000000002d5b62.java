
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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

		long x = sc.nextLong();
		long y = sc.nextLong();

		final char dirX = x >= 0 ? 'E' : 'W';
		final char dirY = y >= 0 ? 'N' : 'S';
		final char oppX = x >= 0 ? 'W' : 'E';
		final char oppY = y >= 0 ? 'S' : 'N';

		x = Math.abs(x);
		y = Math.abs(y);

		List<Character> dir = new ArrayList<>();

		while (x != 0 || y != 0) {

			boolean xOdd = x % 2 != 0;
			boolean yOdd = y % 2 != 0;

			if (x == 0 && yOdd) {
				if (y == 1 || ((y + 1) / 2) % 2 == 0) {
					y = (y - 1) / 2;
					dir.add(dirY);
				}
				else {
					y = (y + 1) / 2;
					dir.add(oppY);
				}
			}
			else if (y == 0 && xOdd) {
				if (x == 1 || ((x + 1) / 2) % 2 == 0) {
					x = (x - 1) / 2;
					dir.add(dirX);
				}
				else {
					x = (x + 1) / 2;
					dir.add(oppX);
				}
			}
			else if (xOdd && !yOdd) {
				long nextYRemainer = (y / 2) % 2;
				if (((x + 1) / 2) % 2 == nextYRemainer) {
					x = (x - 1) / 2;
					dir.add(dirX);
				}
				else {
					x = (x + 1) / 2;
					dir.add(oppX);
				}
				y /= 2;
			}
			else if (yOdd && !xOdd) {
				long nextXRemainer = (x / 2) % 2;
				if (((y + 1) / 2) % 2 == nextXRemainer) {
					y = (y - 1) / 2;
					dir.add(dirY);
				}
				else {
					y = (y + 1) / 2;
					dir.add(oppY);
				}
				x /= 2;
			}
			else {
				return "IMPOSSIBLE";
			}
		}

		return join("", dir);
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
