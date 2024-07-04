
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	private static final boolean DEBUG = false;
	private static Scanner scanner;

	public static void main(String[] args) throws Exception {
		InputStream input = DEBUG ? new FileInputStream(new File(Solution.class.getResource("input.txt").toURI()))
				: System.in;
		scanner = new Scanner(input);
		run();
	}

	private static void run() {
		final int n = scanner.nextInt();
		long time = 0;
		if (DEBUG) {
			time = System.currentTimeMillis();
		}
		for (int i = 0; i < n; i++) {
			solve(i);
		}
		if (DEBUG) {
			System.out.println(System.currentTimeMillis() - time);
		}
	}

	private static void solve(int index) {
		final int u = scanner.nextInt();
		final int max = ((int) Math.pow(10, u)) - 1;
		final String maxStr = Integer.toString(max);
		final char[] chars = new char[10];
		Map<Integer, Set<Character>> possible = new HashMap<>();
		for (int i = 0; i < 1000; i++) {
			String q = scanner.next();
			if (q.equals("-1")) {
				q = maxStr;
			}
			String r = scanner.next();
			int j = q.length() - 1;
			if (r.length() < q.length()) {
				continue;
			}
			int d = Character.getNumericValue(q.charAt(q.length() - 1 - j));
			char rd = r.charAt(r.length() - j - 1);
			possible.compute(d, (k, set) -> {
				if (set == null) {
					set = new HashSet<>();
				}
				set.add(rd);
				return set;
			});
		}
		chars[0] = possible.get(0).iterator().next();
		Set<Character> used = new HashSet<>();
		used.add(chars[0]);
		for (int i = 1; i < 10; i++) {
			Set<Character> ipos = possible.get(i);
			ipos.removeAll(used);
			chars[i] = ipos.iterator().next();
			used.add(chars[i]);
		}
//		System.out.println(possible);
		printCase(index, String.valueOf(chars));
	}

	private static void printCase(int i, String str) {
		System.out.println("Case #" + (i + 1) + ": " + str);
	}

}
