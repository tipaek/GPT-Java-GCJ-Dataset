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
			int r = sc.nextInt();
			int c = sc.nextInt();

			int interest = 0;

			int[][] map = new int[r][c];
			boolean go = true;
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					map[j][k] = sc.nextInt();
				}
			}

			while (go) {
				go = false;

				double[][] power = new double[r][c];
				for (int j = 0; j < r; j++) {
					for (int k = 0; k < c; k++) {
						if (map[j][k] > 0) {
							power[j][k] = power(map, j, k, r, c);
						} else {
							power[j][k] = 0;
						}
					}
				}

				for (int j = 0; j < r; j++) {
					for (int k = 0; k < c; k++) {
						interest = interest + map[j][k];
						if (map[j][k] < power[j][k]) {
							map[j][k] = 0;
							go = true;
						}
					}
				}

			}

			System.out.println("Case #" + (i + 1) + ": " + interest);
		}
	}

	private double power(final int[][] map, final int j, final int k, final int r, final int c) {
		double t = 0;
		int comp = 0;
		for (int i = j + 1; i < r; i++) {
			if (map[i][k] > 0) {
				comp++;
				t = t + map[i][k];
				break;
			}
		}
		for (int i = j - 1; i >= 0; i--) {
			if (map[i][k] > 0) {
				comp++;
				t = t + map[i][k];
				break;
			}
		}

		for (int i = k + 1; i < c; i++) {
			if (map[j][i] > 0) {
				comp++;
				t = t + map[j][i];
				break;
			}
		}
		for (int i = k - 1; i >= 0; i--) {
			if (map[j][i] > 0) {
				comp++;
				t = t + map[j][i];
				break;
			}
		}

		if (comp == 0) {
			return 0;
		}
		return t / comp;
	}
}
