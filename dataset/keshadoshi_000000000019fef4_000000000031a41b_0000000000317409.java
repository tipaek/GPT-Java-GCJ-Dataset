import java.util.Scanner;

public class Solution {

	public static final String STAR = "*";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int cases = 1; cases <= t; cases++) {
			long x = sc.nextLong();
			long y = sc.nextLong();
			String m = sc.next();
			boolean found = false;
			int result = 0;
			for (int i = 0; i < m.length(); i++) {
				switch (m.charAt(i)) {
				case 'N':
					y++;
					break;
				case 'S':
					y--;
					break;
				case 'E':
					x++;
					break;
				case 'W':
					x--;
					break;
				}
				if (Math.abs(x) + Math.abs(y) <= i+1) {
					found = true;
					result = i+1;
					break;
				}
			}
			if (found) {
				System.out.println("Case #" + cases + ": " + result);
			} else {
				System.out.println("Case #" + cases + ": IMPOSSIBLE");
			}
		}
		sc.close();
	}
}