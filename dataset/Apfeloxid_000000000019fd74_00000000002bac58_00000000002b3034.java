import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testAmount = scanner.nextInt();


		for (int testId = 1; testId <= testAmount; testId++) {
			int n = scanner.nextInt();
			scanner.nextLine();

			List<String> prefixs = new ArrayList<>();
			List<String> suffixs = new ArrayList<>();
			List<String> middle = new ArrayList<>();
			List<String> patterns = new ArrayList<>();

			StringBuilder result = new StringBuilder();

			for (int i = 0; i < n; i++) {
				String p = scanner.nextLine();
				patterns.add(p);
				String[] pSplitted = p.split("\\*");

				if (result.length() == 0 && !p.contains("*")) {
					result.append(p);
				}

				if (p.charAt(0) != '*') {
					prefixs.add(pSplitted[0]);
				}
				if (p.charAt(p.length()-1) != '*') {
					suffixs.add(pSplitted[pSplitted.length-1]);
				}
				for (String str: pSplitted) {
					if (!str.isEmpty()) {
						middle.add(str);
					}
				}
			}

			String prefix = getPrefix(prefixs);
			String suffix = getSuffix((suffixs));

			if (prefix.equals("ERROR") || suffix.equals("ERROR")) {
				System.out.println("Case #" + testId + ": *");
				continue;
			}

			if (result.length() > 0) {
				boolean possible = true;
				for (String p: patterns) {
					int resultPointer = 0;
					for (int i = 0; i < p.length(); i++) {
						if (p.charAt(i) == '*') {
							continue;
						}

						if (resultPointer >= result.length()) {
							possible = false;
							break;
						}

						if (p.charAt(i) == result.charAt(resultPointer)) {
							resultPointer++;
						} else {
							resultPointer++;
							i--;
						}
					}
				}

				if (!possible) {
					System.out.println("Case #" + testId + ": *");
				} else {
					System.out.println("Case #" + testId + ": " + result);
				}
				continue;
			}


			result.append(prefix);


			for (String mid: middle) {
				result.append(mid);
			}
			result.append(suffix);

			System.out.println("Case #" + testId + ": " + result);
		}
	}

	private static String getPrefix(List<String> prefixes) {
		String result = "";

		for (String str: prefixes) {
			for (int i = 0; i < Math.min(result.length(), str.length()); i++) {
				if (result.charAt(i) != str.charAt(i)) {
					return "ERROR";
				}
			}
			if (str.length() > result.length()) {
				result = str;
			}
		}

		return result;
	}

	private static String getSuffix(List<String> suffix) {
		String result = "";

		for (String str: suffix) {
			for (int i = 0; i < Math.min(result.length(), str.length()); i++) {
				if (result.charAt(result.length() - i - 1) != str.charAt(str.length() - i - 1)) {
					return "ERROR";
				}
			}
			if (str.length() > result.length()) {
				result = str;
			}
		}

		return result;
	}
}
