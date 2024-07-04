import java.util.*;
public class Solution {
	static int [][] M;
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int ii = 1; ii<=T; ++ii) {
			int tr = 0;
			int n = sc.nextInt();
			M = new int [n][n];
			for (int i = 0; i<n; ++i) for(int j = 0; j<n; ++j) M[i][j] = sc.nextInt();
			for (int i = 0; i<n; ++i) tr += M[i][i];
			System.out.printf("Case #%d: %d %d %d\n",ii,tr, eval1(true,n), eval1(false,n));
		}
	}
	public static int eval1(boolean order, int n) {
		int r = 0;
		boolean [] used = new boolean [101];
		for (int i = 0; i<n; ++i) {
			Arrays.fill(used, false);
			boolean inc = false;
			for (int j = 0; j<n && !inc; ++j) {
				int key = (order) ? M[i][j] : M[j][i];
				inc |= used[key];
				used[key] = true;
			}
			if (inc) r++;
		}
		return r;
	}
}
