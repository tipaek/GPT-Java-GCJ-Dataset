import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		List<Integer> answers = new ArrayList<>();

		for (int count = 1; count <= t; count++) {
			int x = s.nextInt();
			int y = s.nextInt();
			String m = s.next();

			int ans = -1;
			int x1 = -x, y1 = y;
			for (int i = 0; i < m.length(); i++) {
				char dir = m.charAt(i);
				switch (dir) {
				case 'N':
					y1++;
					break;
				case 'S':
					y1--;
					break;
				case 'E':
					x1--;
					break;
				case 'W':
					x1++;
					break;

				}

				int minDist = i + 1;
				int dist = Math.abs(x1) + Math.abs(y1);
				if (dist <= minDist) {
					ans = minDist;
					break;
				}
			}

			answers.add(ans);

		}

		int count = 1;
		for (int answer : answers) {
			if (answer == -1) {
				System.out.println("Case #" + count + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + count + ": " + answer);
			}
			count++;
		}
	}
}
