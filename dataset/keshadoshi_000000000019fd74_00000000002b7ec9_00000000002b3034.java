import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int cases = 1; cases <= t; cases++) {
			int n = sc.nextInt();
			String[] patterns = new String[n];
			for (int i = 0; i < n; i++) {
				patterns[i] = sc.next();
			}
			String result = "*";
			for (int i = 0; i < n; i++) {
				result = Solution.getStringFromPattern(patterns[i]);
				boolean match = false;
				for (int j = 0; j < n; j++) {
					if (Solution.matches(patterns[j], result)) {
						match = true;
						continue;
					}
					match = false;
					break;
				}
				if (match) {
					break;
				} else {
					result = "*";
				}
			}
			System.out.println("Case #" + cases + ": " + result);
		}
		sc.close();
	}

	private static boolean matches(String p, String s) {
		if (p == null || p.isEmpty()) {
			return false;
		}
		if (Solution.hasOnlyOneStar(p)) {
			if (p.startsWith("*")) { // set 1
				return s.endsWith(p.substring(1));
			} else { // set 2

			}
		}
		for (int i = 0; i < p.length(); i++) {

		}

		return false;
	}

	private static boolean hasOnlyOneStar(String p) {
		if (p != null && !p.isEmpty()) {
			int count = 0;
			while (p.contains("*")) {
				p = p.replace("*", "");
				count++;
			}
			return count == 1;
		}
		return false;
	}

	private static String getStringFromPattern(String p) {
		if (p == null || p.isEmpty()) {
			return p;
		}
		while (p.contains("*")) {
			p = p.replace("*", "");
		}
		if (p.isEmpty()) {
			p = "*";
		}
		return p;
	}

}
