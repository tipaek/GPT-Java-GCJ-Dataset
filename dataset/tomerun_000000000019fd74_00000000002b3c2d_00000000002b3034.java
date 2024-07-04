import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + " " + solve());
		}
	}

	static String solve() {
		int N = sc.nextInt();
		String[] prefix = new String[N];
		String[] suffix = new String[N];
		ArrayList<String> mid = new ArrayList<>();
		String longestPrefix = "";
		String longestSuffix = "";
		for (int i = 0; i < N; i++) {
			String[] P = sc.next().split("\\*", -1);
			prefix[i] = P[0];
			suffix[i] = P[P.length - 1];
			if (longestPrefix.length() < prefix[i].length()) {
				longestPrefix = prefix[i];
			}
			if (longestSuffix.length() < suffix[i].length()) {
				longestSuffix = suffix[i];
			}
			for (int j = 1; j < P.length - 1; j++) {
				mid.add(P[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			if (!longestPrefix.substring(0, prefix[i].length()).equals(prefix[i])) {
				return "*";
			}
			if (!longestSuffix.substring(longestSuffix.length() - suffix[i].length()).equals(suffix[i])) {
				return "*";
			}
		}
		StringBuilder ans = new StringBuilder();
		ans.append(longestPrefix);
		for (String m : mid) {
			ans.append(m);
		}
		ans.append(longestSuffix);
		return ans.toString();
	}

}
