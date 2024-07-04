
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = scan.nextInt();
		for (long it = 1; it <= t; ++it) {
			int n = scan.nextInt();
			scan.nextLine();
			String[] strs = new String[n];
			for (int in = 0; in < n; ++in) {
				strs[in] = scan.nextLine();
			}
			String res = cal(strs);
			System.out.println("Case #" + it + ": " + res);
		}
		scan.close();
	}

	private static String cal(String[] strs) {
		// test sets 1 and 2
		if (Stream.of(strs).allMatch(s -> s.indexOf('*') == s.lastIndexOf('*'))) {
			List<String> heads = Stream.of(strs).map(s -> s.substring(0, s.indexOf('*'))).collect(Collectors.toList());
			List<String> tails = Stream.of(strs).map(s -> s.substring(s.indexOf('*') + 1)).collect(Collectors.toList());
			String longestHead = heads.stream().max(Comparator.comparingInt(String::length)).get();
			String longestTail = tails.stream().max(Comparator.comparingInt(String::length)).get();
			boolean allHeadGood = heads.stream().allMatch(s -> longestHead.startsWith(s));
			if (!allHeadGood)
				return "*";
			boolean allTailGood = tails.stream().allMatch(s -> longestTail.endsWith(s));
			if (!allTailGood)
				return "*";
			return longestHead + longestTail;

		}
		return "bye";
	}

}