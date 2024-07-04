import java.util.*;
public class Solution {
	static int B;
	public static void main (String [] arg) throws Throwable {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		B = sc.nextInt();
		char [] ans = new char [B];
		int [] same = new int [B/5];
		int [] diff = new int [B/5];

		for (int ii = 1; ii<=T; ++ii) {
			int q = 0;
			int posSame = -1;
			int posDiff = -1;
			Arrays.fill(same, -1);
			Arrays.fill(diff, -1);

			// Starting blocks of [5] paired with ending blocks of [5].
			for (int i = 0; i<B/2; i+=5) {
				for (int k = 0; k<5; ++k) {
					  int key1 = i+k+1;
						int key2 = B-i-k;

						ans[key1-1] = send(key1);
						ans[key2-1] = send(key2);
						if (ans[key1-1] == ans[key2-1]) {
							posSame = i+1;
							same[i/5] = i+1;
						} else {
							posDiff = i+1;
							diff[i/5] = i+1;
						}
				}
			}
			// B queries.
			int sameState = send(posSame);
			int diffState = send(posDiff);
			int sameState_init = sameState;
			int diffState_init = diffState;
			int scan = 0;
			int qcnt = 0;
			boolean flipped = false;
			boolean reversed = false;
			qcnt += 2;
			while (scan < B/2) {
				if (qcnt % 10 == 0 && scan != 0) {
						sameState = send(posSame);
						diffState = send(posDiff);
						flipped = (sameState == sameState_init);
						reversed = (flipped && diffState == diffState_init) || (!flipped && diffState != diffState_init);
						qcnt+=2;
				}

				int sameLocal = send(same[scan]);
				int diffLocal = send(diff[scan]);
				qcnt += 2;
				boolean localFlipped = (sameLocal != ans[same[scan]-1]);
				if (localFlipped != flipped) flip(ans, scan);
				boolean localReversed = false;
				if (diff[scan] > 0) localReversed = (localFlipped && diffLocal == ans[diff[scan]-1]) || (!localFlipped && diffLocal != ans[diff[scan]-1]);
				if (localReversed != reversed) reverse(ans, scan);
				scan += 5;
			}
			if (flipped) flip(ans, -1);
			if (reversed) reverse(ans, -1);
			System.out.print(new String(ans));
			System.out.flush();
			if (next() == 'N') throw new Exception("FF");
		}
	}
	public static void flip(char [] a, int at) {
		int five = (at < 0) ? B/2 : 5;
		for (int i = (at < 0) ? 0 : at; i<at+five; ++i) {
			a[i] = (a[i] == '1') ? '0' : '1';
			a[a.length-i-1] = (a[a.length-i-1] == '1') ? '0' : '1';
		}
	}
	public static void reverse(char [] a, int at) {
		int five = (at < 0) ? B/2 : 5;
		for (int i = (at < 0) ? 0 : at; i<at+five; ++i) {
			char tmp = a[i];
			a[i] = a[a.length-i-1];
			a[a.length-i-1] = tmp;
		}
	}
	static char send(int c) throws Throwable {
		System.out.print((c <= 0) ? 1 : c);
		System.out.flush();
		return next();
	}
	static char next() throws Throwable {
			char c = '0';
			while (c != 'N' && c != '1' && c != '0') c = (char)System.in.read();
			if (c == 'N') throw new Exception("F");
			return c;
	}
}
