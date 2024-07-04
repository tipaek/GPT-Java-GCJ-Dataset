
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Code Jam 2020 Round 1C
 */
public class Solution {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in);
				 PrintStream out = System.out;) {
			int t = in.nextInt();
			for (int i = 1; i <= t; i++) {
				String solution = solveNext(in);
				out.println("Case #" + i + ": " + solution);
				out.flush();
			}
		}
		System.exit(0);
	}

	public static String solveNext(Scanner in) {
		int numDigits = in.nextInt();
		Entry[] items = new Entry[NUM_ITEMS];
		for (int i = 0; i < NUM_ITEMS; i++) {
			long max = in.nextLong();
			String str = in.next();
			items[i] = new Entry(max, str);
		}
		return new Solution(numDigits, items).solve();
	}

	public static class Entry {

		long max;
		String str;

		public Entry(long max, String str) {
			this.max = max;
			this.str = str;
		}
	}

	private static final int NUM_ITEMS = 10000;
	int numDigits;
	Entry[] items;

	public Solution(int numDigits, Entry[] items) {
		this.numDigits = numDigits;
		this.items = items;
	}

	private String getResult(Map<Character, Set<Integer>> map) {
		char[] chars = new char[10];
		for (Character c : map.keySet()) {
			Set<Integer> poss = map.get(c);
			if (poss.size() != 1) {
				return null;
			}
			for (Integer digit : poss) {
				chars[digit] = c;
			}
		}
		return new String(chars);
	}

	public String solve() {
		Arrays.sort(this.items, (a, b) -> Long.compare(a.max, b.max));
		Set<Character> chars = new HashSet<>();
		for (int i = 0; i < NUM_ITEMS; i++) {
			String str = this.items[i].str;
			for (int j = 0; j < str.length(); j++) {
				chars.add(str.charAt(j));
			}
		}
		Map<Character, Set<Integer>> map = new HashMap<>();
		for (Character c : chars) {
			Set<Integer> poss = new HashSet<>();
			for (int i = 0; i <= 10; i++) {
				poss.add(i);
			}
			map.put(c, poss);
		}

		int count = 0;
		String result = null;
		while (count < 100 && result == null) {
			for (int i = 0; i < NUM_ITEMS; i++) {
				Entry item = this.items[i];
				String str = item.str;
				map.get(str.charAt(0)).remove(0);

				long max = item.max;
				char[] digits = Long.toString(max).toCharArray();
				int len = str.length();
				if (digits.length != len) {
					continue;
				}
				for (int j = 0; j < len; j++) {
					int digit = Character.getNumericValue(digits[j]);
					Set<Integer> poss = map.get(str.charAt(j));
					for (int k = digit + 1; k <= 10; k++) {
						poss.remove(k);
					}
					if (poss.size() > 1 || !poss.contains(digit)) {
						break;
					}
				}
			}

			for (Character c : map.keySet()) {
				Set<Integer> poss = map.get(c);
				if (poss.size() != 1) {
					continue;
				}
				for (Integer digit : poss) {
					for (Character o : map.keySet()) {
						if (c == o) {
							continue;
						}
						map.get(o).remove(digit);
					}
				}
			}
			count++;
			result = this.getResult(map);
		}

		return result;
	}
}
