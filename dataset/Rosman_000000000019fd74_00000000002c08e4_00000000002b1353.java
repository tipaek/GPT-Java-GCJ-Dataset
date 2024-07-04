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
			int n = sc.nextInt();
			int val = n;
			System.out.println("Case #" + (i + 1) + ":");
			int row = 1;
			int col = 1;

			int offset = 0;

			do {
				col = (int) Math.ceil((double) row / (double) 2) - offset;
				if (col == 0) {
					row++;
					col = 1;
				}
				int v = pos(row - 1, col - 1);
				val = val - v;
				System.out.println(row + " " + col);
				// System.out.println(row + " " + col + " " + v);
				// System.out.println("> " + val);

				row = row + 1;
				col = (int) Math.ceil((double) row / (double) 2) - offset;

				int s = sum(row, col);
				// System.out.println("S>" + s);

				if (s > val) {
					offset++;
					row--;
				}
				// System.out.println("O>" + offset);
			} while (val > 0);
		}
	}

	private int pos(final int n, int k) {
		int res = 1;
		if (k > (n - k)) {
			k = n - k;
		}
		for (int i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}

		return res;
	}

	private int sum(final int n, final int k) {
		int t = 0;
		for (int i = 1; i <= k; i++) {
			t = t + pos(n - 1, i - 1);
		}
		return t;
	}
}
