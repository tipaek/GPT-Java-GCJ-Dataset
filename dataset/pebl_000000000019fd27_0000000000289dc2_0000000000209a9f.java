import java.util.Scanner;

public class Solution {

	// Doh, openJDK
	private static void repeat(StringBuilder sb, String s, int copy) {
		for(int i=0; i<copy; i++)
			sb.append(s);		
	}
	
	private static void solve(int nr, Scanner sc) {
		String S = sc.next();

		StringBuilder A = new StringBuilder(S.length()); 

		int nested = 0;
		for(int i=0; i<S.length(); i++) {
			char c = S.charAt(i);
			int n = c - '0';
			int diff = n - nested;
			if (diff < 0) {
				repeat(A,")",-diff);
				//A.append(")".repeat(-diff));
			} else if (diff > 0) {
				repeat(A,"(",diff);
				//A.append("(".repeat(diff));
			}
			A.append(c);
			nested = n;
		}
		repeat(A,")",nested);
		//A.append(")".repeat(nested));
		
		System.out.println("Case #"+nr+": "+A);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			solve(i+1,sc);
		}
	}
}
