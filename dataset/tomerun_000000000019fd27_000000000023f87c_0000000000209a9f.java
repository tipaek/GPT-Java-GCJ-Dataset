import java.util.ArrayList;
import java.util.Scanner;

public final class Solution {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}

	static void solve() {
		char[] s = sc.next().toCharArray();
		ArrayList<Character> ans = new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			int c = s[i] - '0';
			for (int j = 0; j < c; j++) {
				if (!ans.isEmpty() && ans.get(ans.size() - 1) == ')') {
					ans.remove(ans.size() - 1);
				} else {
					ans.add('(');
				}
			}
			ans.add(s[i]);
			for (int j = 0; j < c; j++) {
				ans.add(')');
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : ans) {
			sb.append(ch);
		}
		System.out.println(sb);
	}
}
