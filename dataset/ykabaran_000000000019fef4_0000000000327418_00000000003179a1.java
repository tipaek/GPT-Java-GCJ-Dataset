
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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
//		return new Solution(0, null).solve();
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

	private static class Count {

		int digit;
		int[] counts = new int[16];

		public Count(int digit) {
			this.digit = digit;
		}
	}

	public String solve2() {
		long max = 10000000000000000L;
		ThreadLocalRandom random = ThreadLocalRandom.current();

		Count[] counts = new Count[10];
		for (int i = 0; i < 10; i++) {
			counts[i] = new Count(i);
		}
		for (int i = 0; i < 10000; i++) {
			long rand1 = random.nextLong(1, max);
			long rand2 = random.nextLong(1, rand1 + 1);
			String s = Long.toString(rand2);
			for (int j = 0; j < s.length(); j++) {
				int digit = Character.getNumericValue(s.charAt(j));
				counts[digit].counts[j]++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append("\n").append(Arrays.toString(counts[i].counts));
		}
		return sb.toString();
	}

	private static class CharCount {

		char c;
		int count;

		public CharCount(char c, int count) {
			this.c = c;
			this.count = count;
		}

	}

	public String solve() {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < NUM_ITEMS; i++) {
			String str = this.items[i].str;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				Integer count = map.get(c);
				if (count == null) {
					map.put(c, 0);
				}
			}
		}
		for (int i = 0; i < NUM_ITEMS; i++) {
			char c = this.items[i].str.charAt(0);
			Integer count = map.get(c);
			if (count == null) {
				count = 0;
			}
			count++;
			map.put(c, count);
		}

		CharCount[] counts = new CharCount[10];
		int index = 0;
		for (Character c : map.keySet()) {
			counts[index] = new CharCount(c, map.get(c));
			index++;
		}

		Arrays.sort(counts, (a, b) -> Integer.compare(a.count, b.count));
		char[] secret = new char[10];
		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				secret[i] = counts[i].c;
			} else {
				secret[10 - i] = counts[i].c;
			}
		}
		return new String(secret);
	}
}
