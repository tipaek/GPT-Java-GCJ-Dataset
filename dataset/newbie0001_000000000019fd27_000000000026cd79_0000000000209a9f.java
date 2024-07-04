import java.util.*;
import java.io.*;
import static java.lang.System.out;

/**
 * Nesting Depth
 * 
 */ 
public class Solution {

	private static Scanner sc;
	
	
	
	public static void main(String[] args) throws Exception {
		
		sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; ++t) {
			solve(t);			
		}
		
		sc.close();
	}
	
	private static void solve(int t) {
		
		char[] S = sc.next().toCharArray();
		StringBuilder sb = new StringBuilder();

		int m = S.length - 1;
		for (int i = 0; i < S[0] - '0'; ++i) {
			sb.append("(");
		}
		for (int i = 0; i < m; i++) {
			sb.append(S[i]);
			int a = S[i] - '0';
			int b = S[i+1] - '0';
			int diff = a - b;
			if (diff == 0) continue;
			if (diff < 0) {
				for (int p = diff; p < 0; ++p) {
					sb.append("(");
				}
				continue;
			}

			for (int p = 0; p < diff; ++p) {
				sb.append(")");
			}
		}
		int lastDigit = S[S.length - 1] - '0';
		sb.append(lastDigit);
		for (int i = 0; i < lastDigit; ++i) {
			sb.append(")");
		}

		out.printf("Case #%d: %s\n", t, sb.toString());
	}
}
