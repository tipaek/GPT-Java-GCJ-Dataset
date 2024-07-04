import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		new Solution().start();
	}

	private InputStream in;

	public Solution() {
		in = System.in;
	}

	public Solution(final String fileName) {
		try {
			in = new FileInputStream(fileName);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		Scanner sc = new Scanner(in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String m = sc.nextLine();
			m = m.substring(1);

			int l = m.length();
			int step = 0;
			int sol = -1;
			for (int j = 0; j < l; j++) {
				String op = m.substring(0, 1);
				m = m.substring(1);
				if (op.equals("N")) {
					y++;
				} else if (op.equals("S")) {
					y--;
				} else if (op.equals("E")) {
					x++;
				} else if (op.equals("W")) {
					x--;
				}
				step++;

				// System.out.println(x + " " + y + " " + " > " + step);
				if ((Math.abs(x) + Math.abs(y)) <= step) {
					sol = step;
					break;
				}
			}

			if (sol >= 0) {
				System.out.println("Case #" + (i + 1) + ": " + sol);
			} else {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			}
		}
	}

}
