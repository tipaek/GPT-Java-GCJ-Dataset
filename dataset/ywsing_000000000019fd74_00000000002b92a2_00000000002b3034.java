import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		tc: for (int case_ = 1; case_ <= t; ++case_) {
			int n = in.nextInt();
			in.nextLine();

			String[] ps = new String[n];

			for (int i = 0; i < n; i++)
				ps[i] = in.nextLine();

			String allmatch0 = "";
			String allmatch1 = "";

			{
				int maxLen = 0;

				for (int si = 0; si < ps.length; si++) {
					String word = ps[si].split("\\*")[0];
					int fl = word.length();
					int ml = Math.min(word.length(), allmatch0.length());
					if (word.substring(0, ml).equals(allmatch0.substring(0, ml))) {
						if (fl > maxLen) {
							maxLen = fl;
							allmatch0 = word;
						}
					} else {
						System.out.println("Case #" + case_ + ": *");
						continue tc;
					}
				}
			}

			{
				int maxLen = 0;

				for (int si = 0; si < ps.length; si++) {
					String word = ps[si].split("\\*")[1];
					int fl = word.length();
					int ml = Math.min(word.length(), allmatch1.length());
					if (word.substring(word.length() - ml, word.length())
							.equals(allmatch1.substring(allmatch1.length() - ml, allmatch1.length()))) {
						if (fl > maxLen) {
							maxLen = fl;
							allmatch1 = word;
						}
					} else {
						System.out.println("Case #" + case_ + ": *");
						continue tc;
					}
				}
			}

			System.out.println("Case #" + case_ + ": " + allmatch0 + allmatch1);
		}
	}

}
