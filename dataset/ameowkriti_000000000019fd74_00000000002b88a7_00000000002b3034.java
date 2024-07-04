
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int c = 1;
		while (t-- > 0) {

			int n = scan.nextInt();
			String[] words = new String[n];

			for (int i = 0; i < n; i++)
				words[i] = scan.next();
			String ans = check(words);

			System.out.print("Case #" + c + ": ");
			System.out.print(ans);
			System.out.println();
			c++;
		}

	}

	public static String check(String[] words) {

		int max = 0;

		for (int i = 0; i < words.length; i++) {

			if (words[i].length() > words[max].length())
				max = i;

		}

		String pattern = "";
		for (int i = 0; i < words[max].length(); i++) {

			if (words[max].charAt(i) == '*')
				continue;
			else
				pattern+=words[max].charAt(i);

		}

		//String pattern = words[max].substring(1);
		//System.out.println(pattern);

		for (int i = 0; i < words.length; i++) {

			if (!wildcardPatternMatching(pattern, words[i]))
				return "*";

		}

		return pattern;

	}

	public static boolean wildcardPatternMatching(String src, String pattern) {

		if (src.length() == 0 && pattern.length() == 0) {

			return true;

		}

		if (src.length() != 0 && pattern.length() == 0) {

			return false;

		}

		if (src.length() == 0 && pattern.length() != 0) {

			for (int i = 0; i < pattern.length(); i++) {

				if (pattern.charAt(i) != '*') {

					return false;
				}

			}
			return true;

		}

		char charsrc = src.charAt(0);
		char charp = pattern.charAt(0);

		String rossrc = src.substring(1);
		String rospat = pattern.substring(1);

		boolean ans;

		if (charp == '*') {

			ans = wildcardPatternMatching(src, rospat) || wildcardPatternMatching(rossrc, pattern);

		} else if (charp == charsrc) {

			ans = wildcardPatternMatching(rossrc, rospat);

		} else {

			ans = false;

		}

		return ans;
	}

}
