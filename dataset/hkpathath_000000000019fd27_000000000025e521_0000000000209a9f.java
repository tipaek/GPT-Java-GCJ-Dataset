import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] res = new String[T];
		for(int i = 0; i < T; i++) {
			String S = sc.next();
			res[i] = constructNestingString(S);
		}
		
		for(int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + ": " + res[i - 1]);
		}
	}

	private static String constructNestingString(String s) {
		StringBuilder res = new StringBuilder("");
		int openPar = 0;
		for(char c : s.toCharArray()) {
			int n = c - '0';
			while(n > openPar) {
				res.append("(");
				openPar++;
			}
			while(n < openPar) {
				res.append(")");
				openPar--;
			}
			if(n == openPar)
				res.append("" + c);
		}
		while(openPar > 0) {
			res.append(")");
			openPar--;
		}
		return res.toString();
	}

}