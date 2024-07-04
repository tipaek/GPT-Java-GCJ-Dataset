import java.util.*;
public class Solution {
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int ii = 1; ii<=T; ++ii) {
			long L = sc.nextLong();
			long R = sc.nextLong();
			long diff = Math.abs(L-R);
			long n0 = binFind(Math.abs(L-R));

			//System.err.println(n0 + " : " + del(n0));
			//System.err.println(L + " , " + R);

			if (L > R) L-= del(n0);
			else R-= del(n0);
			//System.err.println(L + " , " + R);
			if (R > L && R >= n0+1) {
				R -= n0+1;
				n0++;
			}

			n0++;
			//System.err.println(ii + " :: " + L + " , " + R + " , " + n0);

			long MIN = 0;
			long MAX = 2000000007;
			//long deln0 = del(n0);
			while (MIN < MAX) {
				long piv = (MIN+MAX+1)>>1;
				long sub = piv * (n0 + 1) + 2 * del(piv-1);
				//System.err.println("Trying " + sub + " @ " + piv);
				if (R >= sub) {
					MIN = piv;
				} else {
					MAX = piv-1;
				}
			}
			long ans = 2*MIN + n0 - 1;
			//System.err.println("Found MIN " + MIN + " vs " + n0);
			R -=  MIN * (n0+1) + 2 * del(MIN-1);
			L -=  MIN * (n0) + 2 * del(MIN-1);

			if (L >= ans+1) {
				L -= ans+1;
				ans++;
			}



			System.out.printf("Case #%d: %d %d %d\n",ii, ans, L, R);
		}
	}
	public static long binFind(long s) {
		if (s == 0) return 0;
		long MIN = 1;
		long MAX = 2000000007;
		while (MIN < MAX) {
			long piv = (MIN+MAX+1)>>1;
			long d = del(piv);
			if (d > s) {
				MAX = piv-1;
			} else {
				MIN = piv;
			}
		}
		return MIN;
	}
	public static long del(long n) {
		if (n <= 0) return 0;
		return (n * (n+1)) / 2;
	}
}
