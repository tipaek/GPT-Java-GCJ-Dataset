import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int ans, N;
	static int[] X, Y;
	static int[] connect;

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + ": " + solve());
		}
	}

	static int solve() {
		N = sc.nextInt();
		X = new int[N];
		Y = new int[N];
		for (int i = 0; i < N; i++) {
			X[i] = sc.nextInt();
			Y[i] = sc.nextInt();
		}
		if (N <= 4) return N;
		if (N > 8) return N;
		connect = new int[N];
		Arrays.fill(connect, -1);
		ans = 4;
		boolean[] visitedI = new boolean[N];
		boolean[] visitedO = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				long dx = X[j] - X[i];
				long dy = Y[j] - Y[i];
				for (int k = 0; k < N; k++) {
					visitedI[k] = true;
					dfs(k, visitedI, visitedO, dx, dy);
					visitedI[k] = false;
				}
			}
		}
		return ans;
	}

	static void dfs(int cur, boolean[] visitedI, boolean[] visitedO, long dx, long dy) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (visitedI[i] || visitedO[i]) count++;
		}
//		System.err.println("cur:" + cur + " visitedI:" + Arrays.toString(visitedI) + "visitedO:" + Arrays.toString(visitedO));
		ans = Math.max(ans, count);
		for (int i = 0; i < N; i++) {
			if (visitedO[i]) continue;
			if (i == cur) continue;
			if (connect[cur] != -1 && i != connect[cur]) continue;
			int prevConnect = connect[cur];
			connect[cur] = i;
			connect[i] = cur;
			visitedO[i] = true;
			if (!visitedI[i]) {
				ans = Math.max(ans, count + 1);
			}
			int next = -1;
			long minDot = Long.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				long dot = dx * (X[j] - X[i]) + dy * (Y[j] - Y[i]);
				long rot = dx * (Y[j] - Y[i]) - dy * (X[j] - X[i]);
				if (dot > 0 && rot == 0 && dot < minDot) {
					minDot = dot;
					next = j;
				}
			}
			if (next != -1 && !visitedI[next]) {
				visitedI[next] = true;
				dfs(next, visitedI, visitedO, dx, dy);
				visitedI[next] = false;
			}
			if (prevConnect == -1) {
				connect[cur] = -1;
				connect[i] = -1;
			}
			visitedO[i] = false;
		}
	}

}
