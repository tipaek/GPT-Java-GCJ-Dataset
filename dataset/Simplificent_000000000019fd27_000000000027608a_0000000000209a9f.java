

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("WrongPackageStatement")
class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int mumCases = sc.nextInt();
		sc.nextLine();
		for (int caseNumber = 0; caseNumber < mumCases; caseNumber++) {
			pw.print("Case #" + (caseNumber + 1) + ": ");
			solve(sc, pw);
			pw.println();
		}
		pw.println();
		pw.flush();
		pw.close();
		sc.close();
	}

	private static void solve(Scanner sc, PrintWriter pw) {
		String S = sc.nextLine(); // S should be composed of digits.  We need to break S into its component digits and nest properly.

		// would it just work to nest naively and then remove )( type patterns?
		StringBuilder naivelyNested = new StringBuilder();

		for (int i = 0; i < S.length(); i++) {
			int digit = Integer.parseInt(S.substring(i, i + 1));
			naivelyNested.append(nest(digit));
		}

		// now reduce the nesting
		String reduced = reduce(naivelyNested.toString());

		pw.print(reduced);
	}

	private static String nest(int digit) {
		StringBuilder result = new StringBuilder();
		if (digit == 0) {
			return "0";
		} else {
			for (int i = 0; i < digit; i++) {
				result.append("(");
			}
			result.append(digit);
			for (int i = 0; i < digit; i++) {
				result.append(")");
			}
		}
		return result.toString();
	}

	private static String reduce(String input) {
		while (input.contains(")(")) {
			input = input.replaceAll("\\)\\(", "");
		}
		return input;
	}

}
