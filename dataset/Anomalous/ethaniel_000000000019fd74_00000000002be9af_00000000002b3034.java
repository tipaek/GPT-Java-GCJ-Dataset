import java.util.*;
import java.io.*;

public class PatternMatching {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(reader.readLine());

		for (int t = 1; t <= testCases; t++) {
			int patternsCount = Integer.parseInt(reader.readLine());
			List<String> prefixPatterns = new ArrayList<>();
			List<String> suffixPatterns = new ArrayList<>();

			for (int n = 0; n < patternsCount; n++) {
				String pattern = reader.readLine();

				if (pattern.charAt(0) == '*') {
					suffixPatterns.add(pattern.substring(1));
				} else if (pattern.charAt(pattern.length() - 1) == '*') {
					prefixPatterns.add(pattern.substring(0, pattern.length() - 1));
				} else {
					int starIndex = pattern.indexOf('*');
					prefixPatterns.add(pattern.substring(0, starIndex));
					suffixPatterns.add(pattern.substring(starIndex + 1));
				}
			}

			prefixPatterns.sort(Comparator.comparingInt(String::length));
			suffixPatterns.sort(Comparator.comparingInt(String::length));

			boolean isValid = true;

			while (prefixPatterns.size() > 1 && isValid) {
				String longestPrefix = prefixPatterns.get(prefixPatterns.size() - 1);
				String shortestPrefix = prefixPatterns.get(0);

				if (longestPrefix.startsWith(shortestPrefix)) {
					prefixPatterns.remove(0);
				} else {
					isValid = false;
				}
			}

			while (suffixPatterns.size() > 1 && isValid) {
				String longestSuffix = suffixPatterns.get(suffixPatterns.size() - 1);
				String shortestSuffix = suffixPatterns.get(0);

				if (longestSuffix.endsWith(shortestSuffix)) {
					suffixPatterns.remove(0);
				} else {
					isValid = false;
				}
			}

			if (isValid) {
				String prefix = prefixPatterns.isEmpty() ? "" : prefixPatterns.get(0);
				String suffix = suffixPatterns.isEmpty() ? "" : suffixPatterns.get(0);

				String commonSubstring = "";
				int minLength = Math.min(prefix.length(), suffix.length());

				for (int i = 1; i <= minLength; i++) {
					if (suffix.startsWith(prefix.substring(prefix.length() - i))) {
						commonSubstring = suffix.substring(i);
						break;
					}
				}

				String solution = prefix + commonSubstring;

				if (solution.length() > 10000) {
					System.out.println("Case #" + t + ": *");
				} else {
					System.out.println("Case #" + t + ": " + solution);
				}
			} else {
				System.out.println("Case #" + t + ": *");
			}
		}
	}
}