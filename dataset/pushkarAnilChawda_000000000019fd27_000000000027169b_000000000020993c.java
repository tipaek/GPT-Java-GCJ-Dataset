import java.util.Scanner;

public class Solution {

	public static void main(String arg[]) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int a[][];
		for (int k = 0; k < T; k++) {
			int N = sc.nextInt();
			a = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					a[i][j] = sc.nextInt();
				}
			}

			int krc[] = perform(a, N);
			System.out.println("Case #" + (k + 1) + ": " + krc[0] + " " + krc[1] + " " + krc[2]);
		}

		sc.close();
	}

	private static int[] perform(int[][] a, int N) {
		int krc[] = new int[3];
		int k = 0, r = 1, c = 2;
		boolean dupR[], dupC[], rBreak, cBreak;
		for (int i = 0; i < N; i++) {
			krc[k] = krc[k] + a[i][i];
			dupR = new boolean[N + 1];
			dupC = new boolean[N + 1];
			rBreak = false;
			cBreak = false;
			for (int j = 0; j < N; j++) {
				if (!dupR[a[i][j]]) {
					dupR[a[i][j]] = true;
				} else {
					if (!rBreak)
						krc[r] = krc[r] + 1;
					rBreak = true;
				}

				if (!dupC[a[j][i]]) {
					dupC[a[j][i]] = true;
				} else {
					if (!cBreak)
						krc[c] = krc[c] + 1;
					cBreak = true;
				}
			}
		}

		return krc;
	}

}
