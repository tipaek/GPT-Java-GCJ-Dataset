import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	boolean solve() {
		int N = scanner.nextInt();
		scanner.nextLine();
		Set<String> patterns = new HashSet<>();


		String sol = "";
		for (int i = 0; i < N; i++) {
			patterns.add(scanner.nextLine());
		}

		//System.err.println(patterns);
		String resultLeft = "";
		String resultRight = "";
		while (!patterns.isEmpty()) {
			boolean ok = false;
			for (String pattern : patterns) {
				if (pattern.equals("*")) {
					patterns.remove(pattern);
					ok = true;
					break;
				}
				if (pattern.endsWith("*") && !pattern.startsWith("*")) {
					String part = pattern.substring(0, pattern.length()-1);
					patterns.remove(pattern);
					if (part.contains("*")) {
						Set<String> newPatterns = new HashSet<>();
						for (String p : patterns) {
							newPatterns.add(part + p);
						}
						patterns = newPatterns;
					} else {
						resultLeft = resultLeft + part;
					}
					if (patterns.isEmpty()) {
						resultLeft = resultLeft + part.replace("*", "");
					}
					ok = true;
					break;
				}
				if (pattern.startsWith("*") && !pattern.endsWith("*")) {
					String part = pattern.substring(1) + resultRight;
					patterns.remove(pattern);
					if (part.contains("*")) {
						Set<String> newPatterns = new HashSet<>();
						for (String p : patterns) {
							newPatterns.add(p + part);
						}
						patterns = newPatterns;
					} else {
						resultRight = part + resultRight;
					}
					if (patterns.isEmpty()) {
						resultRight = part.replace("*", "") + resultRight;
					}
					ok = true;
					break;
				}
			}
			if (!ok) {
				char cut = 0;
				for (String pattern : patterns) {
					char c = pattern.charAt(0);
					if (c == '*') continue;
					if (cut == 0) {
						cut = c;
					}
					else {
						if (cut != c)
							return false;
					}
				}
				Set<String> newPatterns = new HashSet<>();
				for (String pattern : patterns) {
					if (pattern.charAt(0) != '*' || cut == 0 && pattern.charAt(0) == '*') {
						newPatterns.add(pattern.substring(1));
					} else {
						newPatterns.add(pattern);
					}
				}
				patterns = newPatterns;
				if (cut>0)
					resultLeft += cut;

				cut = 0;
				for (String pattern : patterns) {
					char c = pattern.charAt(pattern.length()-1);
					if (c == '*') continue;
					if (cut == 0) {
						cut = c;
					}
					else {
						if (cut != c)
							return false;
					}
				}
				newPatterns = new HashSet<>();
				for (String pattern : patterns) {
					if (pattern.charAt(pattern.length()-1) != '*' || cut == 0 && pattern.charAt(pattern.length()-1) != '*') {
						newPatterns.add(pattern.substring(0, pattern.length()-1));
					} else {
						newPatterns.add(pattern);
					}
				}
				patterns = newPatterns;
				if (cut>0)
					resultRight = cut + resultRight;

			}
			//System.err.println(patterns + " " + resultLeft + "-" + resultRight);
		}
		System.out.println(resultLeft + resultRight);
		return true;
	}

	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = scanner.nextInt();
		scanner.nextLine();
		for (int i = 1; i <= testCases; i++) {
			System.out.print("Case #" + i + ": ");
			if (!new Solution().solve()) {
				System.out.println("*");
			}
		}
	}
}