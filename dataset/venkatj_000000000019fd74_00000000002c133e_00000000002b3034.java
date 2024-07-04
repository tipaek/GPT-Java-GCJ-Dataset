import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		// System.out.println("Test cases : " + t);

		for (int i = 1; i <= t; ++i) {
			int n = Integer.parseInt(in.nextLine());

			String[] st = new String[n];
			int bf = 0;
			int bl = 0;
			String[] firsts = new String[n];
			String[] lasts = new String[n];
			for (int j = 0; j < n; j++) {
				st[j] = in.nextLine();
				//System.out.println("READ : " + st[j]);
				String[] split = st[j].split("\\*");
				firsts[j] = (split[0] == null) ? "" : split[0];
				lasts[j] = (split.length == 1 || split[1] == null) ? "" : split[1];
				if (firsts[j].length() > firsts[bf].length()) {
					bf = j;
				}
				if (lasts[j].length() > lasts[bl].length()) {
					bl = j;
				}
				//System.out.println("First : " + firsts[j] + ". Last : " + lasts[j]);
				
			}

			boolean possible = true;

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < firsts[j].length(); k++) {

					if (firsts[j].charAt(k) != firsts[bf].charAt(k)) {
						possible = false;
						break;
					}
				}
				if (!possible)
					break;
			}

			for (int j = 0; j < n && possible; j++) {
				for (int k = 0; k < lasts[j].length(); k++) {

					if (lasts[j].charAt(lasts[j].length() - 1 - k) != lasts[bl].charAt(lasts[bl].length() - 1 - k)) {
						possible = false;
						break;
					}
				}
				if (!possible)
					break;
			}

			System.out.println("Case #" + i + ": " + (possible ? firsts[bf] + lasts[bl] : "*"));

		}
	}
}