import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for ( int t = 1 ; t <= T ; t++ ) {
			StringBuilder ans = new StringBuilder();
			long N = sc.nextInt();
			int r = 1;
			int k = 1;
			long cur = 1;
			ans.append("1 1\n");
			if ( N >= 30 ) {
				long NN = N - 30;
				for ( int i = 1 ; i < 30 ; i++ ) {
					if ( ((NN >> i) & 1L) != 0 ) {
						if ( k == 1 ) {
							for ( int j = 1 ; j <= i + 1 ; j++ ) {
								ans.append((i + 1) + " " + j + "\n");
							}
							r = i + 1;
							k = i + 1;
						} else {
							for ( int j = i + 1; j >= 1 ; j-- ) {
								ans.append((i + 1) + " " + j + "\n");
							}
							r = i + 1;
							k = 1;
						}
						cur += (1L << i);
					} else {
						if ( k == 1 ) {
							ans.append((i + 1) + " 1" + "\n");
							r = i + 1;
							k = 1;
						} else {
							ans.append((i + 1) + " " + (i + 1) + "\n");
							r = i + 1;
							k = i + 1;
						}
						cur += 1;
					}
				}
			}
			while ( N - cur > 0 ) {
				if ( k == 1 ) {
					ans.append(++r);
					ans.append(" ");
					ans.append(1);
					ans.append("\n");
				} else {
					ans.append(++r);
					ans.append(" ");
					ans.append(++k);
					ans.append("\n");
				}
				cur++;
			}

			System.out.print("Case #" + t + ": " + "\n" + ans.toString());
		}
		sc.close();
	}
}
