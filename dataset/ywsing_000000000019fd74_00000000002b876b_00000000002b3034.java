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
			int[] is = new int[n];

			for (int i = 0; i < n; i++)
				ps[i] = in.nextLine();

			String allmatch0 = "";
			int maxLen0 = 0;

			for (int si = 0; si < ps.length; si++) {
				String s0 = ps[si].split("\\*")[0];
				int fl = s0.length();
				int ml = Math.min(s0.length(), allmatch0.length());
				if (s0.substring(0, ml).equals(allmatch0.substring(0, ml))) {
					if (fl > maxLen0) {
						maxLen0 = fl;
						allmatch0 = s0;
					}
				} else {
					System.out.println("Case #" + case_ + ": *");
					continue tc;
				}
			}

			String allmatch1 = "";
			int maxLen1 = 0;

			for (int si = 0; si < ps.length; si++) {
				String s0 = ps[si].split("\\*")[1];
				int fl = s0.length();
				int ml = Math.min(s0.length(), allmatch1.length());
				if (s0.substring(s0.length() - ml, s0.length())
						.endsWith(allmatch1.substring(allmatch1.length() - ml, allmatch1.length()))) {
					if (fl > maxLen1) {
						maxLen1 = fl;
						allmatch1 = s0;
					}
				} else {
					System.out.println("Case #" + case_ + ": *");
					continue tc;
				}
			}

			System.out.println("Case #" + case_ + ": " + allmatch0 + allmatch1);
		}
	}

}
