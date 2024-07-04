import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
	public static void main (String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			int[] s = new int[n];
			int[] e = new int[n];
			int[] o = new int[n];
			String[] res = new String[n];
			boolean b = true;
			int c = 0;
			int j = 0;
			for (int i2 = 0; i2 < n; i2++) {
				s[i2] = in.nextInt();
				e[i2] = in.nextInt();
				o[i2] = i2;
				for (int i3 = i2; i3 > 0; i3--) {
					if (s[i3] < s[i3 - 1]) {
						int x = s[i3 - 1];
						s[i3 - 1] = s[i3];
						s[i3] = x;
						x = e[i3 - 1];
						e[i3 - 1] = e[i3];
						e[i3] = x;
						x = o[i3 - 1];
						o[i3 - 1] = o[i3];
						o[i3] = x;
					} else {
						break;
					}
				}
			}
			for (int i2 = 0; i2 < n; i2++) {
				if (c <= s[i2]) {
					res[o[i2]] = "C";
					c = e[i2];
				} else if (j <= s[i2]) {
					res[o[i2]] = "J";
					j = e[i2];
				} else {
					b = false;
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			if (b) for (String s2 : res) sb.append(s2);
			else sb = new StringBuilder("IMPOSSIBLE");
			System.out.printf("Case #%d: %s\n", i, sb.toString());
		}
		in.close();
	}
}