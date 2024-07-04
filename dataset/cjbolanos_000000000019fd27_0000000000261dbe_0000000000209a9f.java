
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		for ( int i = 1; i <= cases; i++ ) {
			processCase(i, in);
		}
	}
	
	static void processCase(int caseNo, Scanner in) throws Exception {
		String S = in.nextLine(); // A is either 20 or 200
		StringBuilder out = new StringBuilder();
		
		int parens = 0;
		for ( int i = 0; i < S.length(); i++ ) {
			int dig = Integer.valueOf(S.substring(i, i + 1));
			while ( parens > dig ) {
				out.append(")");
				parens--;
			}
			while ( parens < dig ) {
				out.append("(");
				parens ++;
			}
			out.append(dig);
		}

		while ( parens > 0) {
			out.append(")");
			parens--;
		}
		System.out.printf("Case #%s: %s\n", caseNo, out.toString());
	}
}
