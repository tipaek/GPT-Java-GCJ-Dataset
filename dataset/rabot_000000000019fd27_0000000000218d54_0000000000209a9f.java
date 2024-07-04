import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for ( int t = 1 ; t <= T ; t++ ) {
			String S = sc.next();

			int d = 0;
			StringBuilder ans = new StringBuilder();
			for ( int i = 0 ; i < S.length() ; i++ ) {
				int n = S.charAt(i) - '0';
				if ( d < n ) {
					for ( int k = 0 ; k < n - d ; k++ ) {
						ans.append('(');
					}
					d = n;
				} else if ( d > n ) {
					for ( int k = 0 ; k < d - n ; k++ ) {
						ans.append(')');
					}
					d = n;
				}
				ans.append(n);
			}
			if ( d > 0 ) {
				for ( int k = 0 ; k < d ; k++ ) {
					ans.append(')');
				}
			}

			System.out.println("Case #" + t + ": " + ans.toString());
		}
		sc.close();
	}
}
