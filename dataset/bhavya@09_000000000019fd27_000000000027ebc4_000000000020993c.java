

import java.util.*;

class Code4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		int t = 1;
		while (tc > 0) {
			int n = sc.nextInt();

			int matrix[][] = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}

			int trace = 0;

			for (int i = 0; i < n; i++) {
				trace += matrix[i][i];
			}

			int ro = 0;

			for (int i = 0; i < n; i++) {
				boolean ar[] = new boolean[n];
				for (int j = 0; j < n; j++) {
					if (ar[matrix[i][j] - 1]) {
						ro++;
						break;
					}
					ar[matrix[i][j] - 1] = true;
				}
			}

			int co = 0;

			for (int i = 0; i < n; i++) {
				boolean ar[] = new boolean[n];
				for (int j = 0; j < n; j++) {
					if (ar[matrix[j][i] - 1]) {
						co++;
						break;
					}
					ar[matrix[j][i] - 1] = true;
				}
			}

			System.out.println("Case #" + t + ":" + " " + trace + " " + ro + " " + co);
			t++;
			tc--;
		}

	}

}
