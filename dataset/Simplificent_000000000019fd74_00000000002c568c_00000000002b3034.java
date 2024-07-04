
import java.io.PrintWriter;
import java.util.*;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int mumCases = sc.nextInt();
		sc.nextLine();
		for (int caseNumber = 0; caseNumber < mumCases; caseNumber++) {
			pw.print("Case #" + (caseNumber + 1) + ": ");
			solve(sc, pw);
//			pw.println();
		}
		pw.println();
		pw.flush();
		pw.close();
		sc.close();
	}

	private static void solve(Scanner sc, PrintWriter pw) {
		final int N = sc.nextInt();
		sc.nextLine();

		List<String> patterns = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			String pattern = sc.nextLine();
			patterns.add(pattern);
		}

		// if we can make a name using all these patterns then print it out
		// otherwise print "*"

		String thisWorks = null;
		boolean impossible = false;
		for (String pattern : patterns) {
			String flattened = flattenPattern(pattern);
			if (thisWorks == null) {
				thisWorks = flattened;
			} else {
				String regex = pattern.replaceAll("\\*", ".*");
				if (thisWorks.matches(regex)) {
					// do nothing
				} else if (flattened.contains(thisWorks)) {
					thisWorks = flattened;
				} else {
					impossible = true;
				}
			}
		}

		if (impossible) {
			pw.println("*");
		} else {
			pw.println(thisWorks);
		}
	}

	private static String flattenPattern(String pattern) {
		return pattern.replaceAll("\\*", "");
	}

}
