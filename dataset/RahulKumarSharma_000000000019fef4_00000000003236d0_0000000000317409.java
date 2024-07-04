import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = Integer.parseInt(sc.nextLine());

		for (int cs = 1; cs <= cases; cs++) {

			String[] str = sc.nextLine().split(" ");

			int xp = Integer.parseInt(str[0]);
			int yp = Integer.parseInt(str[1]);

			char[] moves = str[2].toCharArray();

			int x = 0;
			int y = 0;

			int len = moves.length;

			int mins = 0;

			boolean found = false;

			for (int i = 0; i <= len; i++) {

				if ((x == xp) && (y == yp)) {
					found = true;
					break;
				}

				if(i >= len) {
					break;
				}
				
				mins++;

				if (x < xp) {
					x++;
				} else {
					if(yp - y > 1)  {
						y++;
					} else if ((yp - y == 1) && (moves[i] == 'N')) {
						y++;
					}else if(y - yp > 1)  {
						y--;
					} else if ((y - yp == 1) && (moves[i] == 'S')) {
						y--;
					}
				}

				if (moves[i] == 'N') {
					yp++;
				} else {
					yp--;
				}
			}

			System.out.println("Case #" + cs + ": " + (found ? ("" + mins) : "IMPOSSIBLE"));

		}

	}

}
