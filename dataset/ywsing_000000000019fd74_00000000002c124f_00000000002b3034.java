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
			int maxLen0 = 0;
			int maxLen1 = 0;

			{
				for (int si = 0; si < ps.length; si++) {
					int si_ = si;
					{
						String word = ps[si_].substring(0, ps[si_].indexOf('*'));
						int fl = word.length();
						if (fl > maxLen0) {
							maxLen0 = fl;
							allmatch0 = word;
						}
					}
					{
						String word = ps[si_].substring(ps[si_].indexOf('*') + 1);
						int fl = word.length();
						if (fl > maxLen1) {
							maxLen1 = fl;
							allmatch1 = word;
						}
					}
				}
			}

			{
				for (int si = 0; si < ps.length; si++) {
					int si_ = si;
					{
						String word = ps[si_].substring(0, ps[si_].indexOf('*'));
						int ml = word.length();
						if (word.equals(allmatch0.substring(0, ml)))
							;
						else {
							System.out.println("Case #" + case_ + ": *");
							continue tc;
						}
					}
					{
						String word = ps[si_].substring(ps[si_].indexOf('*') + 1);
						int ml = word.length();
						if (word.equals(allmatch1.substring(allmatch1.length() - ml)))
							;
						else {
							System.out.println("Case #" + case_ + ": *");
							continue tc;
						}
					}
				}
			}

			System.out.println("Case #" + case_ + ": " + allmatch0 + allmatch1);
		}
	}

}
