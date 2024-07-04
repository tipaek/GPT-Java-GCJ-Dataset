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

			int m = Math.max(Math.abs(x), Math.abs(y));

			int start = (int) Math.ceil(Math.log(m) / Math.log(2));

			String result = null;
			for (int j = 0; j < 4; j++) {
				result = calc(x, y, start + j);
				if (result != null) {
					break;
				}
			}

			if (result == null) {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (i + 1) + ": " + result);
			}
		}
	}

	private String calc(final int x, final int y, final int start) {
		StringBuffer sb = new StringBuffer();
		int n = start;
		int nx = x;
		int ny = y;
		while (n > -1) {
			// System.out.println(n + " " + nx + " " + ny + " " + Math.pow(2, n));
			if (Math.abs(nx) > Math.abs(ny)) {
				if (nx > 0) {
					nx = (int) (nx - Math.pow(2, n));
					sb.append("E");
				} else {
					nx = (int) (nx + Math.pow(2, n));
					sb.append("W");
				}
			} else {
				if (ny > 0) {
					ny = (int) (ny - Math.pow(2, n));
					sb.append("N");
				} else {
					ny = (int) (ny + Math.pow(2, n));
					sb.append("S");
				}
			}
			n--;
		}
		// System.out.println(">" + n + " " + nx + " " + ny);
		if ((nx == 0) && (ny == 0)) {
			return sb.reverse().toString();
		}
		return null;
	}

}
