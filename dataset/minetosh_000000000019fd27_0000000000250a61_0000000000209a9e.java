import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		int B = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			resolv(sc, B);
		}
	}

	static boolean printSolution(String ns[], int idx, String s) {
		if (idx >= ns.length) {
			System.out.println(s);
			System.out.flush();
			String res = sc.next();
			if (res.equals("Y"))
				return true;
			else
				return false;
		}
		for (int i = 0; i < 4; i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(s);
			sb.append(ns[idx].substring(i * 10, i * 10 + 10));
			if (printSolution(ns, idx + 1, sb.toString()))
				return true;
		}
		return false;
	}

	private static void resolv(Scanner sc, int B) {
		int N = B / 10;
		String ns[] = new String[N];
		char c;
		for (int i = 0; i < N; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < 10; j++) {
				System.out.println(i * 10 + j);
				System.out.flush();
				sb.append(sc.next());
			}
			String first = sb.toString();
			for (int j = 0; j < first.length(); j++) {
				c = first.charAt(j);
				if (c == '0')
					sb.append('1');
				else
					sb.append('0');
			}
			for (int j = 0; j < first.length(); j++) {
				c = first.charAt(9 - j);
				sb.append(c);
			}
			for (int j = 0; j < first.length(); j++) {
				c = first.charAt(9 - j);
				if (c == '0')
					sb.append('1');
				else
					sb.append('0');
			}
			ns[i] = sb.toString();
		}

		printSolution(ns, 0, "");
	}
}