import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + ": " + solve());
		}
	}

	static long solve() {
		int R = sc.nextInt();
		int C = sc.nextInt();
		long[][] S = new long[R][C];
		long sum = 0;
		HashSet<Pos> cands = new HashSet<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				S[i][j] = sc.nextInt();
				sum += S[i][j];
				cands.add(new Pos(i, j));
			}
		}
		int[][] top = new int[R][C];
		int[][] bottom = new int[R][C];
		int[][] left = new int[R][C];
		int[][] right = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				top[i][j] = i - 1;
				bottom[i][j] = i + 1;
				left[i][j] = j - 1;
				right[i][j] = j + 1;
			}
			right[i][C - 1] = -1;
		}
		for (int i = 0; i < C; i++) {
			bottom[R - 1][i] = -1;
		}
		long ans = 0;
		while (true) {
//			System.err.println("sum:" + sum);
			ans += sum;
			ArrayList<Pos> elim = new ArrayList<>();
			for (Pos p : cands) {
				int c = 0;
				long s = 0;
				int adj = top[p.r][p.c];
				if (adj != -1) {
					c++;
					s += S[adj][p.c];
				}
				adj = bottom[p.r][p.c];
				if (adj != -1) {
					c++;
					s += S[adj][p.c];
				}
				adj = left[p.r][p.c];
				if (adj != -1) {
					c++;
					s += S[p.r][adj];
				}
				adj = right[p.r][p.c];
				if (adj != -1) {
					c++;
					s += S[p.r][adj];
				}
				if (S[p.r][p.c] * c < s) {
					elim.add(p);
				}
			}
			if (elim.isEmpty()) break;
//			System.err.println("elim:" + elim);
			cands.clear();
			for (Pos p : elim) {
				sum -= S[p.r][p.c];
				int t = top[p.r][p.c];
				int b = bottom[p.r][p.c];
				int l = left[p.r][p.c];
				int r = right[p.r][p.c];
				if (t != -1) {
					bottom[t][p.c] = b;
					cands.add(new Pos(t, p.c));
				}
				if (b != -1) {
					top[b][p.c] = t;
					cands.add(new Pos(b, p.c));
				}
				if (l != -1) {
					right[p.r][l] = r;
					cands.add(new Pos(p.r, l));
				}
				if (r != -1) {
					left[p.r][r] = l;
					cands.add(new Pos(p.r, r));
				}
			}
		}
		return ans;
	}

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public boolean equals(Object o) {
			Pos pos = (Pos) o;
			return r == pos.r && c == pos.c;
		}

		public int hashCode() {
			return Objects.hash(r, c);
		}

		@Override
		public String toString() {
			return "(" + r + "," + c + ')';
		}
	}

}
