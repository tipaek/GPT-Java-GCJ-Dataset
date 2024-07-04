import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testAmount = scan.nextInt();
		for (int test = 1; test <= testAmount; test++) {
			String s = scan.next();

			StringBuilder solution = new StringBuilder("");
			int depth = 0;

			for (int i = 0; i < s.length(); i++) {
				while (depth < s.charAt(i) - '0') {
					solution.append("(");
					depth++;
				}
				while (depth > s.charAt(i) - '0') {
					solution.append(")");
					depth--;
				}

				solution.append(s.charAt(i));
			}

			while (depth > 0) {
				solution.append(")");
				depth--;
			}

			System.out.println("Case #" + test + ": " + solution);
		}
	}
}