import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			System.out.printf("Case #%d: ", i+1);
			solve(sc);
		}
		
		sc.close();
	}

	static void solve(Scanner sc) {
		long L = sc.nextLong();
		long R = sc.nextLong();
		
		long[] ans = solve(L, R);
		System.out.printf("%d %d %d\n", ans[0], ans[1], ans[2]);
	}
	
	static long[] solve(long L, long R) {
		long min = 0;
		long max = 2000000000;
		while(min+1 < max) {
			long mid = (min + max)/2;
			long served = mid*(mid+1)/2;
			if(L>=R) {
				if(L-served>=R) {
					min = mid;
				} else {
					max = mid;
				}
			} else {
				if(L<R-served) {
					min = mid;
				} else {
					max = mid;
				}
			}
		}
		
		long n = 0;
		if(L>=R) {
			n = min;
			L -= n*(n+1)/2;
		} else {
			n = min;
			R -= n*(n+1)/2;
			if(R>=n+1) {
				n++;
				R -= n;
			} else {
				return new long[]{n, L, R};
			}
		}
		
		min = n;
		max = 2000000000;
		while(min + 1 < max) {
			long mid = (min + max)/2;
			long ln = (mid+1-n)/2;
			long rn = mid-n-ln;
			if(L-ln*n-ln*ln>=0 && R-rn*n-rn*(rn+1)>=0) {
				min = mid;
			} else {
				max = mid;
			}
		}
		
		long ln = (min+1-n)/2;
		long rn = min-n-ln;
		
		return new long[]{min, L-ln*n-ln*ln, R-rn*n-rn*(rn+1)};
	}
}
