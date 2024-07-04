import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) throws Exception {
		int t = new Integer(br.readLine());
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}

	// **SOLUTION**
	public static void solve() throws Exception {
		String s = br.readLine();
		String ans = rec(0, s.length() - 1, s, 0);
		System.out.println(ans);
	}

	private static String rec(int l, int r, String s, int level) {
		boolean[] d = new boolean[10];
		int min = 10;
		for (int i = l; i <= r; i++) {
			d[s.charAt(i) - '0'] = true;
			min = Math.min(min, s.charAt(i) - '0');
		}
		StringBuilder pre = new StringBuilder("");
		StringBuilder suf = new StringBuilder("");
		for (int i = 0; i < min - level; i++) {
			pre.append("(");
			suf.append(")");
		}

		StringBuilder ans = new StringBuilder("");

		ans.append(pre);

		for (int i = l; i <= r;) {
			int j = i;
			int end = i;
			if (s.charAt(i) - '0' == min) {
				String mid = "";
				while (j <= r && s.charAt(j) - '0' == min) {
					end = j;
					mid += s.charAt(j);
					j++;
				}
				ans.append(mid);
			} else {
				while (j <= r && s.charAt(j) - '0' != min) {
					end = j;
					j++;
				}
				ans.append(rec(i, end, s, min));
			}
			i = j;
		}

		ans.append(suf);

		return ans.toString();
	}

	public static InputStreamReader r = new InputStreamReader(System.in);

	public static BufferedReader br = new BufferedReader(r);

	public static Scanner sc = new Scanner(System.in);
}
