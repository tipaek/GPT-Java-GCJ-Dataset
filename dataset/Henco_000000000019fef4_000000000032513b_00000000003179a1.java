
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
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
		final long u = scanner.nextInt();
		final long max = ((long) Math.pow(10, u)) - 1;
		final String maxStr = Long.toString(max);
		final char[] chars = new char[10];
		Set<Character>[] possible = new Set[10];
		for (int i = 0; i < 10; i++) {
			possible[i] = new HashSet<>();
		}
		Set<Character> charsUsed = new HashSet<>();
		for (int i = 0; i < 10000; i++) {
			String q = scanner.next();
			if (q.equals("-1")) {
				q = maxStr;
			}
			String r = scanner.next();
			r.chars().forEach(c -> charsUsed.add((char) c));
			int j = q.length() - 1;
			if (r.length() < q.length()) {
				continue;
			}
			int d = Character.getNumericValue(q.charAt(q.length() - 1 - j));
			char rd = r.charAt(r.length() - j - 1);
			possible[d].add(rd);
		}
//		System.out.println(Arrays.toString(possible));
		boolean cont = true;
		while (cont) {
			cont = false;
			for (int i = 0; i < 10; i++) {
				Set<Character> p = possible[i];
				if (p.size() != 1) {
					continue;
				}
				cont = true;
				char c = p.iterator().next();
				chars[i] = c;
				charsUsed.remove(c);
//				System.out.println("Char " + c + " " + i);
				for (int j = 0; j < 10; j++) {
//					System.out.println("chars " + j + " " + chars[j]);
					possible[j].remove(c);
				}
			}
		}
		chars[0] = charsUsed.iterator().next();
//		System.out.println(Arrays.toString(possible));
//		System.out.println(Arrays.toString(chars));
		printCase(index, String.valueOf(chars));
	}

	private static void printCase(int i, String str) {
		System.out.println("Case #" + (i + 1) + ": " + str);
	}

}
