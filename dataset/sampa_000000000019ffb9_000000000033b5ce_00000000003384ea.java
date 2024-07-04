import java.util.*;

public class Solution {
	private static long bs(long N) {
		long l = 0, r = N, m, res = 0, t;
		
		while (l <= r) {
			m = l + (r - l) / 2;
			if (m % 2 == 0) {
				t = m / 2;
				t *= (m + 1);
			} else {
				t = (m + 1) / 2;
				t *= m;
			}

			if (t == N) {
				return m;
			} else if (t < N) {
				res = Math.max(res, m);
				l = m +1;
			} else {
				r = m - 1;
			}
		}

		return res;
	}

	private static long bs2(long N, long s) {
		long l = 0, r = N, m, res = 0, t;
		
		while (l <= r) {
			m = l + (r - l) / 2;
			if (m % 2 == 0) {
				t = m / 2;
				t *= (2 * s + (m - 1) * 2);
			} else {
				t = (s + (m - 1));
				t *= m;
			}

			//System.err.printf("bs2 N:%d, s:%d, m:%d, t:%d\n", N, s, m, t);

			if (t == N && t >= s) {
				return m;
			} else if (t < N) {
				if (t >= s) {
					res = Math.max(res, m);
				}
				l = m +1;
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
			long L = s.nextLong();
			long R = s.nextLong();
			long cc = 0, t;

			long diff = Math.abs(L - R);
			long N = bs(diff);

			if (N > 0) {
				cc = N;
				t = (N % 2 == 0) ? (N / 2 * (N + 1)) : (N * (N + 1)/2);
				if (L > R) {
					L -= t;
				} else {
					R -= t;
				}
			}

			//System.err.printf("1 -> L:%d, R:%d, N:%d\n", L, R, N);

			N++;
			if (R > L) {
				long N2 = bs2(R, N);
				if (N2 > 0) {
					t = (N2 % 2 == 0) ? (N2/2)*(2 * N + (N2 - 1) * 2) : N2*(N + (N2 - 1));
					R -= t;
					cc += N2;

					N++;
					N2 = bs2(L, N);
					if (N2 > 0) {
						t = (N2 % 2 == 0) ? (N2/2)*(2 * N + (N2 - 1) * 2) : N2*(N + (N2 - 1));
						L -= t;
						cc += N2;
					}
				}
			} else {
				long N2 = bs2(L, N);
				//System.err.printf("2 -> L:%d, R:%d, N:%d, N2:%d\n", L, R, N, N2);
				if (N2 > 0) {
					t = (N2 % 2 == 0) ? (N2/2)*(2 * N + (N2 - 1) * 2) : N2*(N + (N2 - 1));
					L -= t;
					cc += N2;
	
					N++;
					N2 = bs2(R, N);
					if (N2 > 0) {
						t = (N2 % 2 == 0) ? (N2/2)*(2 * N + (N2 - 1) * 2) : N2*(N + (N2 - 1));
						R -= t;
						cc += N2;
					}
				}
			}
	
			System.out.println("Case #" + i + ": " + cc + " " + L + " " + R);
		}

		s.close();
	}
}