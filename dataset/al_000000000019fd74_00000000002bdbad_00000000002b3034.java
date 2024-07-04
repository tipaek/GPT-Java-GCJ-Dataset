import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int count = scanner.nextInt();
			List<String> patterns = new ArrayList<>();
			for (int j = 0; j < count; j++) {
				patterns.add(scanner.next());
			}
			String result = solve(patterns);
			System.out.println("Case #" + (i + 1) + ": " + result);
		}

	}

	private static String solve(List<String> patterns) {
		List<String> fixedLengthPatterns = toFixedLength(patterns);
		int index = fixedLengthPatterns.get(0).length() - 1;
		while (fixedLengthPatterns.size() != 1) {
			char c = '-';
			for (int i = fixedLengthPatterns.size() - 1; i >= 0; i--) {
				String pattern = fixedLengthPatterns.get(i);
				char read = pattern.charAt(index);
				if (read == '*' || read == ' ') {
					fixedLengthPatterns.remove(i);
					continue;
				}
				if (c == '-') {
					c = read;
					continue;
				}
				if (c == read) {
					continue;
				}
				return "*";
			}
			index--;
		}
		String longest = fixedLengthPatterns.get(0);
		return longest.substring(1);
	}

	private static List<String> toFixedLength(List<String> patterns) {
		List<String> result = new ArrayList<>();
		int length = 0;
		for (String pattern : patterns) {
			if (length < pattern.length()) {
				length = pattern.length();
			}
		}
		for (String pattern : patterns) {
			if (pattern.length() < length) {
				String newPattern = new String(new char[length - pattern.length()]).replace('\0', ' ') + pattern;
				result.add(newPattern);
			} else {
				result.add(pattern);
			}
		}
		return result;
	}

}
