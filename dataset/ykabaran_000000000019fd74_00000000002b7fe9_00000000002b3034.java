
import java.util.Scanner;

/**
 * Google Code Jam 2020 Round 1A
 */
public class Solution {

	final int numWords;
	final String[] words;

	public Solution(Scanner scanner) {
		this.numWords = scanner.nextInt();
		this.words = new String[this.numWords];
		for (int i = 0; i < this.numWords; i++) {
			this.words[i] = scanner.next();
		}
	}

	private String preMerge(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l = Math.min(l1, l2);
		for (int i = 0; i < l; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return null;
			}
		}

		if (l1 > l2) {
			return s1;
		}
		return s2;
	}

	private String postMerge(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l = Math.min(l1, l2);
		for (int i = 0; i < l; i++) {
			if (s1.charAt(l1 - 1 - i) != s2.charAt(l2 - 1 - i)) {
				return null;
			}
		}

		if (l1 > l2) {
			return s1;
		}
		return s2;
	}

	private String getPrefix(String[][] splits) {
		String prefix = "";
		for (int i = 0; i < this.numWords; i++) {
			prefix = this.preMerge(prefix, splits[i][0]);
			if (prefix == null) {
				return null;
			}
		}
		return prefix;
	}

	private String getPostfix(String[][] splits) {
		String postfix = "";
		for (int i = 0; i < this.numWords; i++) {
			postfix = this.postMerge(postfix, splits[i][1]);
			if (postfix == null) {
				return null;
			}
		}
		return postfix;
	}

	private String[] splitWord(String word) {
		if (word.charAt(0) == '*') {
			return new String[]{"", word.substring(1)};
		}
		int l = word.length();
		if (word.charAt(l - 1) == '*') {
			return new String[]{word.substring(0, l - 1), ""};
		}
		int index = word.indexOf("*");
		return new String[]{word.substring(0, index), word.substring(index + 1)};
	}

	private String[][] splitAll() {
		String[][] splits = new String[this.numWords][];
		for (int i = 0; i < this.numWords; i++) {
			splits[i] = this.splitWord(this.words[i]);
		}
		return splits;
	}

	public String solve() {
		String[][] splits = this.splitAll();
		String prefix = this.getPrefix(splits);
		if (prefix == null) {
			return "*";
		}
		String postfix = this.getPostfix(splits);
		if (postfix == null) {
			return "*";
		}
		return prefix + postfix;
	}

	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in);) {
			int T = scanner.nextInt();
			for (int i = 1; i <= T; i++) {
				String solution = new Solution(scanner).solve();
				System.out.println("Case #" + i + ": " + solution);
			}
		}
		System.exit(0);
	}

}
