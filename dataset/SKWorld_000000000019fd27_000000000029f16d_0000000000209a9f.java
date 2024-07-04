

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bc = 0;
		int testCase = Integer.parseInt(br.readLine());
		String op = "(";
		String cl = ")";
		for (int t = 0; t < testCase; t++) {
			bc = 0;
			String s = br.readLine();
			String ans = "";

			for (int i = 0; i < s.length(); i++) {
				int x = Integer.parseInt(s.charAt(i) + "");
				if (x > bc) {

					for (int b = 0; b < x - bc; b++) {
						ans = ans + op;
					}
				}
				if (x < bc) {
					for (int b = 0; b <  bc-x; b++) {
						ans = ans + cl;
					}

				}
				ans = ans + x;
				bc = x;
			}
			for (int b = 0; b < bc; b++) {
				ans = ans + cl;
			}

			System.out.println("Case #" + (t + 1) + ": " + ans);

		}

	}
}
