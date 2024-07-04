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

	private static void resolv(Scanner sc, int B) {
		if (B == 10) {
			StringBuffer sb = new StringBuffer();
			String s;
			for (int n = 1; n <= 10; n++) {
				System.out.println(n);
				System.out.flush();
				s = sc.next();
				if (s.equals("0") || s.equals("1"))
					sb.append(s);
				else
					System.exit(1);
			}
			System.out.println(sb.toString());
			System.out.flush();
			s = sc.next();
			if (s.equals("Y"))
				System.err.println("YES");
			else
				System.exit(1);
		} else {
			System.out.println("00000000001111111111");
			System.out.flush();
			System.err.println(sc.next());
			System.exit(1);
		}
	}
}
