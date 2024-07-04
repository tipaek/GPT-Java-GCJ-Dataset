
import java.util.Scanner;

/**
 * Submit without package declaration!
 */
public class Solution {

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final int nTestCases = in.nextInt();
		final int b = in.nextInt();
		for (int t = 1; t <= nTestCases; t++) {
			// magic
			if (b == 10) {
				System.out.println(read(in, 1, 10));
			} else if (b == 20) {
				final String b10a = read(in, 1, 10);
				final String b20a = read(in, 11, 20);
				final String b10b = read(in, 1, 10);
				final String b20b = read(in, 11, 20);
				System.out.println();
			} else {
				System.out.println();
			}
			final String answer = in.next();
			if ("N".equals(answer)) break;
		}
	}

	private static String read(Scanner in, int start, int end) {
		final StringBuilder sb = new StringBuilder();
		for (int j = start; j <= end; j++) {
			System.out.println(j);
			sb.append(in.nextInt());
		}
		return sb.toString();
	}

	private static boolean isComplemented(String a, String b) {
		return complement(a).equals(b);
	}

	private static String complement(String a) {
		final StringBuilder sb = new StringBuilder(a);
		for (int i = 0; i < sb.length(); i++) {
			final char c = sb.charAt(i) == '0' ? '1' : '0';
			sb.setCharAt(i, c);
		}
		return sb.toString();
	}

	private static boolean isReversed(String a, String b) {
		return reverse(a).equals(b);
	}

	private static String reverse(String a) {
		return new StringBuilder(a).reverse().toString();
	}

	private static boolean isComplementedAndReversed(String a, String b) {
		return reverse(complement(a)).equals(b);
	}

}
