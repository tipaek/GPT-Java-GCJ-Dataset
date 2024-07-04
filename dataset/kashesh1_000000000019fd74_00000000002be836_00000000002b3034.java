

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;


public class Solution {

	private void getPattern(int n, String[] pattern, int caseNo) {

		TreeSet<String> suffix = new TreeSet<>();
		TreeSet<String> prefix = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			int idx1 = pattern[i].indexOf('*');
			int idx2 = pattern[i].lastIndexOf('*');
			if (idx1 == idx2) {
				prefix.add(pattern[i].substring(0, idx1));
				suffix.add(pattern[i].substring(idx1 + 1, pattern[i].length()));
			} else {
				for (char ch : pattern[i].toCharArray()) {
					StringBuffer sbr = new StringBuffer("");
					if (ch != '#')
						sbr.append(ch);
					else {
						prefix.add(sbr.toString());
						sbr = new StringBuffer("");
					}
					if (sbr.length() != 0)
						suffix.add(sbr.toString());
				}
			}
		}

		String longestP = "";
		if (!prefix.isEmpty()) {
			for (String str : prefix)
				if (str.length() > longestP.length())
					longestP = str;

			for (String cur : prefix) {
				if (!longestP.startsWith(cur)) {
					System.out.println("Case #" + caseNo + ": " + "*");
					return;
				}
			}
		}

		String longestS = "";
		if (!suffix.isEmpty()) {
			for (String str : suffix)
				if (str.length() > longestS.length())
					longestS = str;
			for (String cur : suffix) {
				if (!longestS.endsWith(cur)) {
					System.out.println("Case #" + caseNo + ": " + "*");
					return;
				}
			}
		}

		System.out.println("Case #" + caseNo + ": " + longestP + longestS);

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			String[] pattern = new String[n];
			for (int j = 0; j < n; j++) {
				pattern[j] = in.next();
			}
			obj.getPattern(n, pattern, i);
		}
	}

}
