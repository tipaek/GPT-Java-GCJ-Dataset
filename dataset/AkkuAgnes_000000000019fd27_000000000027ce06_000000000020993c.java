import java.util.Scanner;

public class Solution {
	public static void main(String arg[]) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		int a[][];
		for (int k = 0; k < tc; k++) {
			int N = sc.nextInt();
			a = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			int output[] = calcDuplicate(a, N);
			System.out.println("Case #" + (k + 1) + ": " + output[0] + " " + output[1] + " " + output[2]);
		}
		sc.close();
	}
	private static int[] calcDuplicate(int[][] a, int N) {
		int output[] = new int[3];
		int k = 0, r = 1, c = 2;
		boolean duplicateRow[], duplicateCol[], rBrk, cBrk;
		for (int i = 0; i < N; i++) {
			output[k] = output[k] + a[i][i];
			duplicateRow = new boolean[N + 1];
			duplicateCol = new boolean[N + 1];
			rBrk = false;
			cBrk = false;
			for (int j = 0; j < N; j++) {
				if (!duplicateRow[a[i][j]]) {
					duplicateRow[a[i][j]] = true;
				} else {
					if (!rBrk)
						output[r] = output[r] + 1;
					rBrk = true;
				}

				if (!duplicateCol[a[j][i]]) {
					duplicateCol[a[j][i]] = true;
				} else {
					if (!cBrk)
						output[c] = output[c] + 1;
					cBrk = true;
				}
			}
		}
		return output;
	}
}