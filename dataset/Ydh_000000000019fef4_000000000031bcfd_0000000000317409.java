
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int tc = scan.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int x = scan.nextInt();
			int y = scan.nextInt();

			String s = scan.next();
			boolean imp = true;
			sb.append("Case #" + test_case + ": ");

			for (int i = 0; i < s.length(); i++) {
				switch (s.charAt(i)) {
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

				int diff = Math.abs(x) + Math.abs(y);

				if (diff <= i + 1) {
					sb.append(i + 1);
					imp = false;
					break;
				}

			}
			if (imp) {
				sb.append("IMPOSSIBLE\n");
			} else {
				sb.append('\n');
			}
		}
		System.out.println(sb.toString());
	}
}
