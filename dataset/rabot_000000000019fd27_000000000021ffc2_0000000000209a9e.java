import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		int T = sc.nextInt();
		int B = sc.nextInt();
		for ( int t = 1 ; t <= T ; t++ ) {
			int[] bp = new int[B / 2];
			int cur = 0;
			while ( cur < B / 2 ) {
				int queries = 5;
				if ( cur > 0 ) {
					// check quantum fluctuations
					boolean flag0 = false;
					boolean flag1 = false;
					boolean swap0 = false;
					boolean swap1 = false;
					for ( int i = 0 ; i < cur && (flag0 == false || flag1 == false); i++ ) {
						if ( flag0 == false && (bp[i] == 0 || bp[i] == 3) ) {
							int b0 = query(i + 1, sc);
							if ( bp[i] != b0 + b0 * 2 ) {
								swap0 = true;
							}
							flag0 = true;
						} else if ( flag1 == false && (bp[i] == 1 || bp[i] == 2) ) {
							int b0 = query(i + 1, sc);
							if ( bp[i] != b0 + (1 - b0) * 2 ) {
								swap1 = true;
							}
							flag1 = true;
						}
					}
					if ( flag0 == false || flag1 == false ) {
						// dummy request
						query(1, sc);
					}
					for ( int i = 0 ; i < cur ; i++ ) {
						if ( swap0 && (bp[i] == 0 || bp[i] == 3) ) {
							bp[i] = 3 - bp[i];
						} else if ( swap1 && (bp[i] == 1 || bp[i] == 2) ) {
							bp[i] = 3 - bp[i];
						}
					}
					queries = 4;
				}
				for ( int i = 0 ; i < queries && cur < B / 2 ; i++ ) {
					int b0 = query(cur + 1, sc);
					int b1 = query(B - cur, sc);
					bp[cur] = b0 + b1 * 2;
					cur++;
				}
			}
			StringBuilder ans = new StringBuilder();
			for ( int i = 0 ; i < B ; i++ ) {
				if ( i < B / 2 ) {
					ans.append(bp[i] & 1);
				} else {
					ans.append((bp[B - i - 1] >> 1) & 1);
				}
			}
			System.out.println(ans.toString());
			System.out.flush();
			String result = sc.next();
			if ( result.equals("N") ) {
				break;
			}
		}
		sc.close();
	}

	static int query(int num, Scanner sc) {
		System.out.println(num);
		System.out.flush();
		return sc.nextInt();
	}
}
