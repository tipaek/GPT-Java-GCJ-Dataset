import java.util.Scanner;

public class Solution {

	static long[] getMinEven(long max, long start) {
		long[] ans = new long[2];
		start = start / 2-1;
		long lo = 0;
		long hi = Integer.MAX_VALUE;

		while (hi - lo > 1) {
			long mid = (hi + lo) / 2;
			long s1 = start + mid;
			if (s1 * (s1 + 1) - (start + 1) * start <= max) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		ans[0] = lo;
		long s1 = start + lo;
		ans[1] = max - (s1 * (s1 + 1) - (start + 1) * start);

		return ans;
	}

	static long[] getMinOdd(long max, long start) {
		long[] ans = new long[2];
		start = start / 2;
		long lo = 0;
		long hi = Integer.MAX_VALUE;

		while (hi - lo > 1) {
			long mid = (hi + lo) / 2;
			long s1 = start + mid;
			if (s1 * s1 - start * start <= max) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		ans[0] = lo;
		long s1 = start + lo;
		ans[1] = max - (s1 * (s1) - start * start);

		return ans;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int t = 1; t <= T; t++) {
			long L = scan.nextLong();
			long R = scan.nextLong();
			boolean byt = false;
			if (L < R) {
				byt = true;
				long temp = L;
				L = R;
				R = temp;
			}

			long diff = L - R;

			long lo = 0;
			long hi = Integer.MAX_VALUE;

			while (hi - lo > 1) {
				long mid = (hi + lo) / 2;
				if (mid * (mid + 1) / 2 <= diff) {
					lo = mid;
				} else {
					hi = mid;
				}
			}

			long start = lo;
			long leftL = 0;
			long leftR = 0;

			L = L - start * (start + 1) / 2;
			if(L == R && byt){
				byt = false;
			}
			if (start % 2 == 0) {
				long[] nbrL = getMinOdd(L, start + 1);
				long[] nbrR = getMinEven(R, start + 2);
				if (nbrL[0] == nbrR[0]) {
					long nbr = nbrL[0];
					start += 2 * nbr;
					leftL = nbrL[1];
					leftR = nbrR[1];
				} else if (nbrL[0] > nbrR[0]) {
					long nbr = nbrR[0];
					long k = (start + 1) / 2;
					long s = k + nbr + 1;
					leftL = L - s * s + k * k;
					start += 2 * nbr + 1;

					leftR = nbrR[1];
				} else {
					long nbr = nbrL[0];
					long k = (start + 2) / 2-1;
					long s = k + nbr + 1;
					leftL = nbrL[1];
					start += 2 * nbr;

					leftR = R - s * (s + 1) + (k + 1) * k;
				}

			} else {
				long[] nbrL = getMinEven(L, start + 1);
				long[] nbrR = getMinOdd(R, start + 2);
				if (nbrL[0] == nbrR[0]) {
					long nbr = nbrL[0];
					start += 2 * nbr;
					leftL = nbrL[1];
					leftR = nbrR[1];
				} else if (nbrL[0] > nbrR[0]) {
					long nbr = nbrR[0];
					long k = (start + 2) / 2-1;
					long s = k + nbr + 1;

					start += 2 * nbr + 1;
					leftL = L - s * (s + 1) + (k + 1) * k;
					
					leftR = nbrR[1];
				} else {
					long nbr = nbrL[0];
					long k = (start + 1) / 2;
					long s = k + nbr + 1;

					leftL = nbrL[1];
					start += 2 * nbr;

					leftR = R - s * s + k * k;
				}
			}

			if (byt) {
				System.out.println("Case #" + t + ": " + start + " " + leftR + " " + leftL);

			} else {
				System.out.println("Case #" + t + ": " + start + " " + leftL + " " + leftR);

			}

		}

	}
}
