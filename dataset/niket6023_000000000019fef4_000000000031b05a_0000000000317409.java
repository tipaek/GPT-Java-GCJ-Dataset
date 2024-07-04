

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution{

	public static void main(String[] args) {

		Scanner nik = new Scanner(System.in);
		int t = nik.nextInt();
		StringBuilder st = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			st.append("Case #" + tc + ": ");
			boolean b = false;

			int x = nik.nextInt();
			int y = nik.nextInt();

			if (x == 0 && y == 0) {
				st.append(0 + "\n");
				b = true;
			}
			char c[] = nik.next().toCharArray();

			for (int i = 0; i < c.length; i++) {

				if (c[i] == 'S') {
					y--;
				} else if (c[i] == 'N') {
					y++;
				} else if (c[i] == 'W') {
					x--;
				} else {
					x++;
				}
				int temp = Math.abs(x) + Math.abs(y);
				if (temp <= (i + 1)) {
					st.append(i + 1 + "\n");
					b = true;
					break;
				}

			}
			if (!b) {
				st.append("IMPOSSIBLE\n");
			}
		}
		System.out.println(st);
	}

}
