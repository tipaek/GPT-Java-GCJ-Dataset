import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for ( int t = 1 ; t <= T ; t++ ) {
			long L = sc.nextLong();
			long R = sc.nextLong();

			long d = L <= R ? R - L : L - R;
			long a = canTake(d, 1, 1);
			if ( L >= R ) {
				L = L - a * (a + 1) / 2;
			} else {
				R = R - a * (a + 1) / 2;
			}
			if ( L >= R ) {
				long l = canTake(L, a + 1, 2);
				long r = canTake(R, a + 2, 2);
				L = L - (a + 1) * l - l * (l - 1);
				R = R - (a + 2) * r - r * (r - 1);
				a = a + l + r;
			} else {
				long r = canTake(R, a + 1, 2);
				long l = canTake(L, a + 2, 2);
				R = R - (a + 1) * r - r * (r - 1);
				L = L - (a + 2) * l - l * (l - 1);
				a = a + l + r;
			}

			System.out.println("Case #" + t + ": " + a + " " + L + " " + R);
		}
		sc.close();
	}

	public static long canTake(long remain, long start, long step) {
		long min = 0;
		long max = 1500000000L;
		while ( max - min > 1 ) {
			long mid = (min + max) / 2;
			if ( start * mid + step * mid * (mid - 1) / 2 <= remain ) {
				min = mid;
			} else {
				max = mid;
			}
		}
		return min;
	}
}
