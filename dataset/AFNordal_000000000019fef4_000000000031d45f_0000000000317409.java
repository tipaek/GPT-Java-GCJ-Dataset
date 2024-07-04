import java.util.*;
import java.lang.Math;

import javax.lang.model.util.ElementScanner6;

/**
 * solution
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			char[] cs = scan.nextLine().toCharArray();
			for (int j = 1; j < cs.length; j++) {
				if (cs[j] == 'N')
					y++;
				else if (cs[j] == 'S')
					y--;
				else if (cs[j] == 'E')
					x++;
				else if (cs[j] == 'W')
					x--;
				if (j >= Math.abs(x) + Math.abs(y)) {
					System.out.println("case #" + (i + 1) + ": " + j);
					break;
				} else if (j == cs.length - 1)
					System.out.println("case #" + (i + 1) + ": " + "IMPOSSIBLE");

			}
		}
		scan.close();
	}
}