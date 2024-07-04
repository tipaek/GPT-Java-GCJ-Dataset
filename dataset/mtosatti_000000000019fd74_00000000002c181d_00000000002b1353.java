import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	static int[][] s = new int[501][501];
	static int[][] w = new int[501][2];

	public static int get(int r, int k) {
		if (r == 1 && k == 1 || r == k) {
			s[r][k] = 1;
			return 1;
		}
		if (s[r][k] > 0) {
			return s[r][k];
		}
		s[r][k] = s[r - 1][k - 1] + s[r - 1][k];
		s[r][r - k + 1] = s[r][k];
		return s[r][k];
	}

	public static int solve(int goal, int r, int k, int sum, int step) {
		if (step >= 500 || k < 1 || k > r)
			return -1;
		w[step][0] = r;
		w[step][1] = k;
		int v = sum + get(r, k);
		if (v == goal) {
			return step;
		} else if (v > goal) {
			return -1;
		} else if(r % 2 == 0) {
			// r
			int nstep = solve(goal, r, k + 1, v, step + 1);
			if (nstep > 0)
				return nstep;
			// br
			nstep = solve(goal, r + 1, k + 1, v, step + 1);
			if (nstep > 0)
				return nstep;
			// bl
			nstep = solve(goal, r + 1, k, v, step + 1);
			if (nstep > 0)
				return nstep;
		} else {
			// l
			int nstep = solve(goal, r, k - 1, v, step + 1);
			if (nstep > 0)
				return nstep;
			// bl
			nstep = solve(goal, r + 1, k, v, step + 1);
			if (nstep > 0)
				return nstep;
			// br
			nstep = solve(goal, r + 1, k + 1, v, step + 1);
			if (nstep > 0)
				return nstep;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			int steps = solve(N, 1, 1, 0, 1);

			System.out.println("Case #" + t + ": ");
			for (int i = 1; i <= steps; i++) {
				System.out.println(w[i][0] + " " + w[i][1]);
			}
		}
	}

}
