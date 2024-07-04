import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static final char EMPTY = '$';

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.print("Case #" + i + ": ");
			System.out.println(solve());
		}
	}

	static String solve() {
		char[] A = sc.next().toCharArray();
		char[] B = sc.next().toCharArray();
		int N = A.length;
		int M = B.length;
		State[][][] dp = new State[N + 1][M + 1][N + M + 2];
		dp[0][0][M] = new State(EMPTY, 0, 0, 0, 0);
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				for (int k = 0; k <= N + M + 1; k++) {
					if (dp[i][j][k] == null) continue;
					for (int l = 0; l < 26; l++) {
						char c = (char) ('A' + l);
						boolean oka = i < N && A[i] == c;
						boolean okb = j < M && B[j] == c;
						if (oka && okb) {
							if (dp[i + 1][j + 1][k] == null || dp[i][j][k].sum < dp[i + 1][j + 1][k].sum) {
								dp[i + 1][j + 1][k] = new State(c, dp[i][j][k].sum, 1, 1, 0);
							}
						}
						if (oka && k > 0) {
							if (dp[i + 1][j][k - 1] == null || dp[i][j][k].sum + 1 < dp[i + 1][j][k - 1].sum) {
								dp[i + 1][j][k - 1] = new State(c, dp[i][j][k].sum + 1, 1, 0, -1);
							}
							if (j < M) {
								if (dp[i + 1][j + 1][k - 1] == null || dp[i][j][k].sum + 1 < dp[i + 1][j + 1][k - 1].sum) {
									dp[i + 1][j + 1][k - 1] = new State(c, dp[i][j][k].sum + 1, 1, 1, -1);
								}
							}
						}
						if (okb && k < N + M + 1) {
							if (dp[i][j + 1][k + 1] == null || dp[i][j][k].sum + 1 < dp[i][j + 1][k + 1].sum) {
								dp[i][j + 1][k + 1] = new State(c, dp[i][j][k].sum + 1, 0, 1, 1);
							}
							if (i < N) {
								if (dp[i + 1][j + 1][k + 1] == null || dp[i][j][k].sum + 1 < dp[i + 1][j + 1][k + 1].sum) {
									dp[i + 1][j + 1][k + 1] = new State(c, dp[i][j][k].sum + 1, 1, 1, 1);
								}
							}
						}
						if (i < N) {
							if (dp[i + 1][j][k] == null || dp[i][j][k].sum + 2 < dp[i + 1][j][k].sum) {
								dp[i + 1][j][k] = new State(c, dp[i][j][k].sum + 2, 1, 0, 0);
							}
						}
						if (j < M) {
							if (dp[i][j + 1][k] == null || dp[i][j][k].sum + 2 < dp[i][j + 1][k].sum) {
								dp[i][j + 1][k] = new State(c, dp[i][j][k].sum + 2, 0, 1, 0);
							}
						}
						if (i < N && j < M) {
							if (dp[i + 1][j + 1][k] == null || dp[i][j][k].sum + 2 < dp[i + 1][j + 1][k].sum) {
								dp[i + 1][j + 1][k] = new State(c, dp[i][j][k].sum + 2, 1, 1, 0);
							}
						}
					}
					if (i < N && k < N + M + 1) {
						if (dp[i + 1][j][k + 1] == null || dp[i][j][k].sum + 1 < dp[i + 1][j][k + 1].sum) {
							dp[i + 1][j][k + 1] = new State(EMPTY, dp[i][j][k].sum + 1, 1, 0, 1);
						}
					}
					if (j < M && k > 0) {
						if (dp[i][j + 1][k - 1] == null || dp[i][j][k].sum + 1 < dp[i][j + 1][k - 1].sum) {
							dp[i][j + 1][k - 1] = new State(EMPTY, dp[i][j][k].sum + 1, 0, 1, -1);
						}
					}
					if (i < N && j < M) {
						if (dp[i + 1][j + 1][k] == null || dp[i][j][k].sum + 2 < dp[i + 1][j + 1][k].sum) {
							dp[i + 1][j + 1][k] = new State(EMPTY, dp[i][j][k].sum + 2, 1, 1, 0);
						}
					}
				}
			}
		}
//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= M; j++) {
//				System.err.print(i + " " + j + " : ");
//				for (int k = 0; k < N + M + 1; k++) {
//					System.err.print((dp[i][j][k] == null ? -1 : dp[i][j][k].sum) + " ");
//				}
//				System.err.println();
//			}
//		}
		int minSum = 1 << 20;
		int minDiff = 1 << 20;
		int minK = 0;
		for (int i = 0; i < N + M + 1; i++) {
			State st = dp[N][M][i];
			if (st == null) continue;
			int diff = Math.abs(i - M);
			if (st.sum < minSum) {
				minSum = st.sum;
				minDiff = diff;
				minK = i;
			} else if (st.sum == minSum && diff < minDiff) {
				minDiff = diff;
				minK = i;
			}
		}
//		System.err.println(minSum);
//		System.err.println(minDiff);
		StringBuilder sb = new StringBuilder();
		int i = N;
		int j = M;
		int k = minK;
		while (i > 0 || j > 0) {
			State st = dp[i][j][k];
			if (st.ch != EMPTY) {
				sb.append(st.ch);
			}
			i -= st.am;
			j -= st.bm;
			k -= st.dm;
		}
		return sb.reverse().toString();
	}

	static class State {
		char ch;
		int sum;
		int am, bm, dm;

		public State(char ch, int sum, int am, int bm, int dm) {
			this.ch = ch;
			this.sum = sum;
			this.am = am;
			this.bm = bm;
			this.dm = dm;
		}
	}

}
