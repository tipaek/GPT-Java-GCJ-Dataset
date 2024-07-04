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
		int move = 0;
		while (patterns.size() != 1) {
			char c = '-';
			for (int i = patterns.size() - 1; i >= 0; i--) {
				String pattern = patterns.get(i);
				int index = pattern.length() - move - 1;
				if (index < 1) {
					patterns.remove(i);
					continue;
				}
				char read = pattern.charAt(index);
				if (c == '-') {
					c = read;
					continue;
				}
				if (c == read) {
					continue;
				}
				return "*";
			}
			move++;
		}
		String longest = patterns.get(0);
		return longest.substring(1);
	}

}