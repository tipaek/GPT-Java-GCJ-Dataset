import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++)
			System.out.println("Case #" + i + ": " + resolv(sc));
	}

	private static String resolv(Scanner sc) {
		int N = sc.nextInt();
		String start = "", end = "", s1, s2;
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			if (s.indexOf("*") == 0) {
				s2 = s.substring(1, s.length());
				if (s2.endsWith(end))
					end = s2;
				else if (end.endsWith(s2))
					;
				else
					return "*";
			} else if (s.indexOf("*") == s.length() - 1) {
				s1 = s.substring(0, s.length() - 1);
				if (s1.startsWith(start))
					start = s1;
				else if (start.startsWith(s1))
					;
				else
					return "*";
			} else {
				int idx = s.indexOf("*");
				s2 = s.substring(idx + 1, s.length());
				if (s2.endsWith(end))
					end = s2;
				else if (end.endsWith(s2))
					;
				else
					return "*";

				s1 = s.substring(0, idx);
				if (s1.startsWith(start))
					start = s1;
				else if (start.startsWith(s1))
					;
				else
					return "*";
			}
		}
//		if (start.equals(end))
//			return start;
		return start + end;
	}
}
