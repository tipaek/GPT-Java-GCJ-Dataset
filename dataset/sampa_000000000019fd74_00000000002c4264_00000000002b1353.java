import java.util.*;

public class Solution {

	private static int bs(int N) {
		long l = 1, r = N;
		long m = 0, v;
		int res = 0;

		while(l <= r) {
			//System.err.println(l + ", " + r);
			m = l + (r-l)/2;
			v = (m * (m + 1))/2;
			if (v == N) {
				return (int)m;
			} else if (v < N) {
				res = Math.max(res, (int)m);
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();
		for(int i = 1; i <= T; i++) {
			int N = s.nextInt();
			int K = bs(N - 1);
			//System.err.println(K);
			int R = N - 1 - (int)((K * (K + 1))/2L);

			System.out.println("Case #" + i + ": ");
			System.out.println("1 1");
			for (int j = 1; j <= K; j++) {
				System.out.println((j + 1) + " 2");
			}
			for (int j = K, m = R; m > 0; m--, j--) {
				System.out.println((j + 1) + " 1");
			}
		}

		s.close();
	}
}