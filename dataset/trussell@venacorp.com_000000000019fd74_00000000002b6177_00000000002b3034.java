import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] argv) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; ++i) {
			int numPatterns = in.nextInt();
			List<String> patterns = new ArrayList<>();
			for (int j = 0; j < numPatterns; j++) {
				patterns.add(in.next());
			}
			String result = computeResult(patterns);
			System.out.println(String.format("Case #%d: %s", i, result));
		}
	}

	private static String computeResult(List<String> patterns) {
		List<String[]> splits = new ArrayList<>();
		for (String pattern : patterns) {
			String[] split = pattern.split("\\*");
			splits.add(split);
		}

		String[] startEnd = new String[2];
		startEnd[0] = new String();
		startEnd[1] = new String();

		for (int i = 0; i < 2; i++) {
			final int index = i;
			List<String> strings = splits.stream().filter(l -> l.length >= index + 1).map(l -> l[index]).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
			for (String string : strings) {
				if (startEnd[i].length() == 0) {
					startEnd[i] = string;
				} else {
					if ((i == 1 && string.endsWith(startEnd[i])) || (i == 0 && string.startsWith(startEnd[i]))) {
						startEnd[i] = string;
					} else {
						return "*";
					}
				}
			}
		}

		return startEnd[0] + startEnd[1];
	}
}