import java.io.*;
import java.util.*;

public class Solution {

	public static BufferedReader br;
	public static int max = 1000000000;
	public static int[] z;
	public static String next;

	public static int calc(int x1, int y1, int dir) throws IOException {

		if (dir == 0) {
			int y2 = max;

			System.out.println(x1 + " " + y2);
			System.out.flush();

			next = br.readLine();

			if (next.charAt(0) == 'C') {
				return 0;
			} else if (next.charAt(0) == 'H') {
				z[0] = x1;
				z[1] = y2;
				return 1;
			} else {
				return plus(y1, y2, x1, false);
			}
		} else if (dir == 1) {

			int x2 = max;

			System.out.println(max + " " + y1);
			System.out.flush();

			next = br.readLine();

			if (next.charAt(0) == 'C') {
				return 0;
			} else if (next.charAt(0) == 'H') {
				z[0] = x2;
				z[1] = y1;
				return 1;
			} else {
				return plus(x1, x2, y1, true);
			}
		} else if (dir == 2) {

			int y2 = -max;

			System.out.println(x1 + " " + y2);
			System.out.flush();

			next = br.readLine();

			if (next.charAt(0) == 'C') {
				return 0;
			} else if (next.charAt(0) == 'H') {
				z[0] = x1;
				z[1] = y2;
				return 1;
			} else {
				return minus(y1, y2, x1, false);
			}
		} else {
			int x2 = -max;

			System.out.println(x2 + " " + y1);
			System.out.flush();

			next = br.readLine();

			if (next.charAt(0) == 'C') {
				return 0;
			} else if (next.charAt(0) == 'H') {
				z[0] = x2;
				z[1] = y1;
				return 1;
			} else {
				return minus(x1, x2, y1, true);
			}
		}
	}

	public static int minus(int a1, int a2, int b1, boolean x) throws IOException {
		while (a2 < a1 - 1) {
			int a0 = (a1 + a2) / 2;

			System.out.println(a0 + " " + b1);
			System.out.flush();

			next = br.readLine();

			if (next.charAt(0) == 'C') {
				return 0;
			} else if (next.charAt(0) == 'H') {
				a1 = a0;
			} else {
				a2 = a0;
			}
		}

		if (x) {
			z[0] = a1;
			z[1] = b1;
		} else {
			z[0] = b1;
			z[1] = a1;
		}
		return 2;
	}

	public static int plus(int a1, int a2, int b1, boolean x) throws IOException {
		while (a2 > a1 + 1) {
			int a0 = (a1 + a2) / 2;

			System.out.println(a0 + " " + b1);
			System.out.flush();

			next = br.readLine();

			if (next.charAt(0) == 'C') {
				return 0;
			} else if (next.charAt(0) == 'H') {
				a1 = a0;
			} else {
				a2 = a0;
			}
		}

		if (x) {
			z[0] = a1;
			z[1] = b1;
		} else {
			z[0] = b1;
			z[1] = a1;
		}
		return 2;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int tC = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= tC; t++) {

			int[] x = new int[16];
			int[] y = new int[16];

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					x[4 * i + j] = -max + max / 5 * (i + 1) * 2;
					y[4 * i + j] = -max + max / 5 * (j + 1) * 2;
				}
			}

			z = new int[2];

			for (int i = 0; i < 16; i++) {

				System.out.println(x[i] + " " + y[i]);
				System.out.flush();

				next = br.readLine();

				if (next.charAt(0) == 'C') {
					break;
				} else if (next.charAt(0) == 'H') {
					int hitX = x[i], hitY = y[i];

					int[] xs = new int[4];
					int[] ys = new int[4];
					// t r b l

					int temp;
					boolean done = false;

					for (int k = 0; k < 4; k++) {
						temp = calc(hitX, hitY, k);

						if (temp == 0) {
							done = true;
							break;
						} else {
							xs[i] = z[0];
							ys[i] = z[1];
						}
					}

					hitX = (xs[3] + xs[1]) / 2;
					hitY = (ys[0] + ys[2]) / 2;

					if (done) {
						break;
					}

					System.out.println(hitX + " " + hitY);
					System.out.flush();

					next = br.readLine();

					if (next.charAt(0) == 'H' || next.charAt(0) == 'M')
						System.exit(0);
					else
						break;
				} else {
					continue;
				}
			}

		}
	}
}