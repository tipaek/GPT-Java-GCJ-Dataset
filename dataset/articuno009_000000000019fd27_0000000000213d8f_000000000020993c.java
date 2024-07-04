import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	private static String process(int[][] a, int m, int d, int r, int c) {
		Set<Integer> rr = new HashSet<>();
		boolean isRIncremented = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (i == j) {
					d += a[i][j];
				}
				if (rr.contains(a[i][j]) && !isRIncremented) {
					r++;
					isRIncremented = true;
				}
				rr.add(a[i][j]);
			}
			isRIncremented = false;
			rr = new HashSet<>();
		}
		Set<Integer> cc = new HashSet<>();
		boolean isDIncremented = false;
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < m; i++) {
				if (cc.contains(a[i][j]) && !isDIncremented) {
					c++;
					isDIncremented = true;
				}
				cc.add(a[i][j]);
			}
			isDIncremented = false;
			cc = new HashSet<>();
		}
		return d + " " + r + " " + c;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int m = in.nextInt();
			int[][] a = new int[m][m];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					a[i][j] = in.nextInt();
				}
			}
			int d = 0, r = 0, c = 0;
			String[] drc = process(a, m, d, r, c).split(" ");

			System.out.println("Case #" + (t + 1) + ": " + drc[0] + " " + drc[1] + " " + drc[2]);
		}

		in.close();

	}
}
