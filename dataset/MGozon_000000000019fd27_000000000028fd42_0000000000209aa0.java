import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		// can we prove with math that the only numbers that can be represented are n, 2*n, 3*n, ..., n*n?
		for (int t = 1; t <= tc; t++) {
			int n = in.nextInt();
			int k = in.nextInt();
			if (k >= n && k <= n*n && k % n == 0) {
				int s = k/n;
				int[][] sol = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						sol[i][j] = (i+j)%n + 1;
					}
				}
				StringBuilder r = new StringBuilder();
				for (int i = 0; i < n; i++) r.append((char)(i+'0'));
				StringBuilder f = new StringBuilder(r.substring(0, s));
				StringBuilder sec = new StringBuilder(r.substring(s));
				r = new StringBuilder(f.reverse().toString() + sec.reverse().toString());
				
				System.out.println("Case #" + t + ": POSSIBLE");
				for (int i = 0; i < n; i++) {
					String rres = "";
					for (int j = 0; j < n; j++) {
						rres += sol[r.charAt(i) - '0'][j] + " ";
					}
					System.out.println(rres.trim());
				}
			} else {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			}
		}
	}
}
