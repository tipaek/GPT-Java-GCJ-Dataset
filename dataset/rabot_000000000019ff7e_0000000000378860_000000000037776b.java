import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solve();
	}

	int[] X = null;
	int K = 0;
	int N = 0;
	public void solve() {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for ( int t = 1 ; t <= T ; t++ ) {
			K = sc.nextInt() * 2;
			N = sc.nextInt();

			X = new int[N];
			int X0 = sc.nextInt();
			X[0] = 0;
			for ( int i = 1 ; i < N ; i++ ) {
				X[i] = (sc.nextInt() - X0) * 2;
			}
			int[] Te = new int[N];
			for ( int i = 0 ; i < N ; i++ ) {
				Te[i] = sc.nextInt();
			}

			int min = 100;
			for ( int x = 1 ; x < X[1] ; x++ ) {
				// # = 1
				min = Math.min(rec(X[1] - x, 1, 1, x), min);
				// # = 2
				for ( int y = x + 1 ; y < X[1] ; y++ ) {
					min = Math.min(rec(X[1] - y, 1, 2, x), min);
				}
			}

			System.out.println("Case #" + t + ": " + min );
		}
		sc.close();
	}

	public int rec(int d, int i, int cnt, int first) {
		if ( i == N - 1 ) {
			if ( K - (X[i] + d) == first ) {
				return cnt + 1;
			} else if ( K - (X[i] + d) > first ) {
				return cnt + 2;
			} else {
				return 100;
			}
		}
		if ( d + X[i] >= X[i + 1] ) {
			return 100;
		}
		// # = 1
		int min = rec(X[i + 1] - (X[i] + d), i + 1, cnt + 1, first);
		for ( int x = d + X[i] + 1 ; x < X[i + 1] ; x++ ) {
			// # = 2
			min = Math.min(rec(X[i + 1] - x, i + 1, cnt + 2, first), min);
		}
		return min;
	}
}
