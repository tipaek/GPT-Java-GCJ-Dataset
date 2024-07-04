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
		boolean impossible = false;
		for ( int t = 1 ; t <= T ; t++ ) {
			int N = sc.nextInt();
			String left = "";
			String right = "";
			String middle = "";
			for ( int i = 0 ; i < N ; i++ ) {
				String S = sc.next();
				if ( impossible ) {
					continue;
				}
				StringTokenizer token = new StringTokenizer(S, "*");
				ArrayList<String> arr = new ArrayList<>();
				while ( token.hasMoreTokens() ) {
					arr.add(token.nextToken());
				}
				boolean leftAster = S.startsWith("*");
				boolean rightAster = S.endsWith("*");
				for ( int j = 0 ; j < arr.size() ; j++ ) {
					String s = arr.get(j);
					if ( j == 0 && !leftAster ) {
						if ( left.length() >= s.length() ) {
							if ( left.startsWith(s) ) {
								//
							} else {
								impossible = true;
								break;
							}
						} else {
							if ( s.startsWith(left) ) {
								left = s;
							} else {
								impossible = true;
								break;
							}
						}
					} else if ( j == arr.size() - 1 && !rightAster ) {
						if ( right.length() >= s.length() ) {
							if ( right.endsWith(s) ) {
								//
							} else {
								impossible = true;
								break;
							}
						} else {
							if ( s.endsWith(right) ) {
								right = s;
							} else {
								impossible = true;
								break;
							}
						}
					} else {
						middle += s;
					}
				}
			}
			String ans = null;
			if ( impossible ) {
				ans = "*";
			} else {
				ans = left + middle + right;
			}

			System.out.println("Case #" + t + ": " + ans);
		}
		sc.close();
	}
}
