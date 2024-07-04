import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		String out = "";

		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int trace = 0;
			int r = 0;
			int c = 0;

			boolean[][] C = new boolean[N][N];
			boolean[] cCounted = new boolean[N];
			for (int j = 0; j < N; j++) {
				boolean[] R = new boolean[N];
				boolean rCounted = false;
				for (int k = 0; k < N; k++) {
					int a = in.nextInt();

					if (j == k) {
						trace += a;
					}

					if (R[a - 1]) {
						if (!rCounted) {
							r++;
						}

						rCounted = true;
					}
					R[a - 1] = true;

					if (C[k][a - 1]) {
						if (!cCounted[k]) {
							c++;
						}

						cCounted[k] = true;
					}
					C[k][a - 1] = true;
				}
			}

			out += "Case #" + (i + 1) + ": " + trace + " " + r + " " + c + "\n";
		}

		System.out.print(out);
	}

}
